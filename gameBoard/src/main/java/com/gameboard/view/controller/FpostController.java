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

import com.gameboard.biz.post.Fpost;
import com.gameboard.biz.post.FpostService;

@Controller
public class FpostController {
	@Autowired
	private FpostService f;

	@RequestMapping(value = "getFID.do")
	public String getFID(Model model) {
		model.addAttribute("fID", f.getFID());
		model.addAttribute("fDate", f.getFDate());
		return "insertFpost.jsp";
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

	@RequestMapping(value = "insertFpost.do")
	public String insertFpost(Fpost vo, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		//���ǿ� id ���� �� ip �ּ�
		if(loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}
		vo.setUserID(loggedInMemberId);
		f.insertFpost(vo);
		return "redirect:FAQ.do";
	}

	@RequestMapping(value = "FAQ.do")
	public String getFpost(Fpost vo, Model model) {
		List<Fpost> FList = f.getFpostList(vo);
		model.addAttribute("FList", FList);
		return "FAQ.jsp";
	}

	// �˻�
	@RequestMapping(value = "searchFpost.do")
	public String searchFpost(Fpost vo, Model model) {
		List<Fpost> FList = f.searchFpost(vo);
		model.addAttribute("FList", FList);
		return "searchF.jsp";
	}

	// ���� + ����
	@RequestMapping(value = "getFpost.do")
	public String getFpostById(int fID, Model model) {
		// ��ȸ�� ������Ʈ
		f.updateFpostViews(fID);

		Fpost post = f.getFpostById(fID);
		model.addAttribute("post", post);

		// ���� �Խù��� ���� �Խù��� �������� ���� ID�� �������� ��ȸ�Ѵ�.
		Fpost prevPost = f.getPrevFpost(fID); // ���� �Խù� ��ȸ
		Fpost nextPost = f.getNextFpost(fID); // ���� �Խù� ��ȸ

		// ���� �Խù��� ���� �Խù��� ������ ��� �𵨿� �߰��Ѵ�.
		if (prevPost != null) {
			model.addAttribute("prevPost", prevPost);
		}
		if (nextPost != null) {
			model.addAttribute("nextPost", nextPost);
		}

		// �ֽ� ����� �����ͼ� �𵨿� �߰� (��ȸ���� ������Ʈ�� ����)
		List<Fpost> FList = f.getFpostList(null);
		model.addAttribute("FList", FList);

		return "getFpost.jsp"; // �� ������ ������ �� �̸�
	}

	@RequestMapping(value = "deleteFpost.do", produces = "text/plain; charset = UTF-8")
	@ResponseBody
	public String deleteFpost(int fID, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		//���ǿ� id ���� �� ip �ּ�
		if(loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}
		Fpost post = f.getFpostById(fID);
		
		if(post != null && post.getUserID().equals(loggedInMemberId)) {
			f.deleteFpost(fID);
		    return "deleteSuccess";
	    } else {
	        return "deleteFailed";
	    }
	}
	
	@RequestMapping(value = "checkEditPermissionF.do", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> checkEditPermission(@RequestParam("fID") int fID, HttpSession session, HttpServletRequest request) {
        String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");

        if (loggedInMemberId == null) {
            String ipAddress = request.getRemoteAddr();
            loggedInMemberId = maskIpAddress(ipAddress);
        }

        Fpost post = f.getFpostById(fID);

        if (post != null && post.getUserID().equals(loggedInMemberId)) {
            // ������ ������ ������ ������ ������ URL�� ��ȯ
            return ResponseEntity.ok("updateSuccess|updateFpostForm.do?fID=" + fID);
        } else {
            return ResponseEntity.ok("updateFailed");
        }
    }

	@RequestMapping(value = "updateFpostForm.do")
	public String updateFpostForm(@RequestParam("fID") int fID, Model model) {
		Fpost post = f.getFpostById(fID); // �Խù� ������ ������
		model.addAttribute("post", post); // ���� ������ ����� �Խù� ������ �𵨿� �߰�
		return "updateFpostForm.jsp"; // ���� �� JSP �������� �̵�
	}

	@RequestMapping(value = "updateFpost.do")
	public String updateFpost(@RequestParam("fID") int fID, @ModelAttribute Fpost vo,
			HttpSession session, HttpServletRequest request) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");

        if (loggedInMemberId == null) {
            String ipAddress = request.getRemoteAddr();
            loggedInMemberId = maskIpAddress(ipAddress);
        }
        
        Fpost existingPost = f.getFpostById(fID);
        
        if (existingPost != null && existingPost.getUserID().equals(loggedInMemberId)) {
            existingPost.setfTitle(vo.getfTitle());
            existingPost.setfContent(vo.getfContent());
            // �Խù� ������ ������Ʈ
            f.updateFpost(existingPost);
        }
		return "redirect:getFpost.do?fID=" + vo.getfID();
	}
}
