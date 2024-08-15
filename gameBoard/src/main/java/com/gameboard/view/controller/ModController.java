package com.gameboard.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gameboard.biz.post.Mod;
import com.gameboard.biz.post.ModService;

@Controller
public class ModController {
	@Autowired
	private ModService m;

	
	@RequestMapping(value = "getMID.do")
	public String getMID(Model model) {
		model.addAttribute("mID", m.getMID());
		model.addAttribute("mDate", m.getMDate());
		return "insertMod.jsp";
	}
	
	// IP �ּҸ� �Ϻ� ����ŷ�ϴ� �޼���
		private String maskIpAddress(String ipAddress) {
			// IPv4 ó��
		    if (ipAddress.contains(".")) {
		        String[] parts = ipAddress.split("\\.");
		        if (parts.length == 4) {
		            return parts[0] + "." + parts[1] + ".***." + parts[3];
		        }
		    }
		    // IPv6 ó��
		    else if (ipAddress.contains(":")) {
		        if ("0:0:0:0:0:0:0:1".equals(ipAddress)) {
		            return "local:01"; // ����ȣ��Ʈ �ּҸ� ó��
		        } else {
		            // IPv6 �ּ��� �Ϻθ� ����ŷ
		            String[] parts = ipAddress.split(":");
		            return parts[0] + ":" + parts[1] + ":" + parts[2] + ":****:****:" + parts[5] + ":" + parts[6] + ":" + parts[7];
		        }
		    }
		    return ipAddress; // IP �ּ� ������ ���� ������ ����ŷ���� �ʰ� ��ȯ
		}

	@RequestMapping(value = "insertMod.do")
	public String insertMod(Mod vo, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		if(loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}
		vo.setUserID(loggedInMemberId);
		m.insertMod(vo);
		return "redirect:Mod.do";
	}

	@RequestMapping(value = "Mod.do")
	public String getModList(Mod vo, Model model) {
		List<Mod> ModList = m.getModList(vo);
		model.addAttribute("ModList", ModList);
		return "mod.jsp";
	}

	@RequestMapping(value = "searchMod.do")
	public String searchMod(Mod vo, Model model) {
		List<Mod> ModList = m.searchMod(vo);
		model.addAttribute("ModList", ModList);
		return "searchMod.jsp";
	}

	// ���� + ����
	@RequestMapping(value = "getMod.do")
	public String getModById(int mID, Model model) {
		// ��ȸ�� ������Ʈ
		m.updateModViews(mID);

		Mod post = m.getModById(mID);
		model.addAttribute("post", post);

		// ���� �Խù��� ���� �Խù��� �������� ���� ID�� �������� ��ȸ�Ѵ�.
		Mod prevPost = m.getPrevMod(mID); // ���� �Խù� ��ȸ
		Mod nextPost = m.getNextMod(mID); // ���� �Խù� ��ȸ

		// ���� �Խù��� ���� �Խù��� ������ ��� �𵨿� �߰��Ѵ�.
		if (prevPost != null) {
			model.addAttribute("prevPost", prevPost);
		}
		if (nextPost != null) {
			model.addAttribute("nextPost", nextPost);
		}

		// �ֽ� ����� �����ͼ� �𵨿� �߰� (��ȸ���� ������Ʈ�� ����)
		List<Mod> ModList = m.getModList(null);
		model.addAttribute("ModList", ModList);
		return "getMod.jsp"; // �� ������ ������ �� �̸�
	}

	@RequestMapping(value = "deleteMod.do", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String deleteMod(int mID, HttpServletRequest request, HttpSession session) {
		 String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		    if (loggedInMemberId == null) {
		        String ipAddress = request.getRemoteAddr();
		        loggedInMemberId = maskIpAddress(ipAddress);
		    }
		    
		    Mod post = m.getModById(mID);
		    
		    if(post != null && post.getUserID().equals(loggedInMemberId)) {
		    	m.deleteMod(mID);
		    	return "deleteSuccess";
		    } else {
		        return "deleteFailed";
		    }
	}
	
	@RequestMapping(value = "checkEditPermissionM.do", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> checkEditPermission(@RequestParam("mID") int mID, HttpSession session, HttpServletRequest request) {
        String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");

        if (loggedInMemberId == null) {
            String ipAddress = request.getRemoteAddr();
            loggedInMemberId = maskIpAddress(ipAddress);
        }

        Mod post = m.getModById(mID);

        if (post != null && post.getUserID().equals(loggedInMemberId)) {
            return ResponseEntity.ok("updateSuccess|updateModForm.do?mID=" + mID);
        } else {
            return ResponseEntity.ok("updateFailed");
        }
    }

	@RequestMapping(value = "updateModForm.do")
	public String updateModForm(@RequestParam("mID") int mID, Model model) {
		Mod post = m.getModById(mID); // �Խù� ������ ������
		model.addAttribute("post", post); // ���� ������ ����� �Խù� ������ �𵨿� �߰�
		return "updateModForm.jsp"; // ���� �� JSP �������� �̵�
	}

	@RequestMapping(value = "updateMod.do", method = RequestMethod.POST)
	public String updateMod(@RequestParam("mID") int mID, @ModelAttribute Mod vo,
			HttpSession session, HttpServletRequest request) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");

        if (loggedInMemberId == null) {
            String ipAddress = request.getRemoteAddr();
            loggedInMemberId = maskIpAddress(ipAddress);
        }
		Mod existingPost = m.getModById(mID);
		if(existingPost!= null && existingPost.getUserID().equals(loggedInMemberId)) {
			existingPost.setmTitle(vo.getmTitle());
			existingPost.setmContent(vo.getmContent());
			m.updateMod(existingPost);
		}
		return "redirect:getMod.do?mID=" + vo.getmID();
	}
}