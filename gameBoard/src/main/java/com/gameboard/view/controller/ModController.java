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
import com.gameboard.biz.post.Sgpost;
import com.gameboard.biz.post.Wtpost;

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
	
	// IP 주소를 일부 마스킹하는 메서드
		private String maskIpAddress(String ipAddress) {
			// IPv4 처리
		    if (ipAddress.contains(".")) {
		        String[] parts = ipAddress.split("\\.");
		        if (parts.length == 4) {
		            return parts[0] + "." + parts[1] + ".***." + parts[3];
		        }
		    }
		    // IPv6 처리
		    else if (ipAddress.contains(":")) {
		        if ("0:0:0:0:0:0:0:1".equals(ipAddress)) {
		            return "local:01"; // 로컬호스트 주소를 처리
		        } else {
		            // IPv6 주소의 일부를 마스킹
		            String[] parts = ipAddress.split(":");
		            return parts[0] + ":" + parts[1] + ":" + parts[2] + ":****:****:" + parts[5] + ":" + parts[6] + ":" + parts[7];
		        }
		    }
		    return ipAddress; // IP 주소 형식이 맞지 않으면 마스킹하지 않고 반환
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

	// 수정 + 삭제
	@RequestMapping(value = "getMod.do")
	public String getModById(int mID, Model model) {
		// 조회수 업데이트
		m.updateModViews(mID);

		Mod post = m.getModById(mID);
		model.addAttribute("post", post);

		// 이전 게시물과 다음 게시물을 가져오기 위해 ID를 기준으로 조회한다.
		Mod prevPost = m.getPrevMod(mID); // 이전 게시물 조회
		Mod nextPost = m.getNextMod(mID); // 다음 게시물 조회

		// 이전 게시물과 다음 게시물이 존재할 경우 모델에 추가한다.
		if (prevPost != null) {
			model.addAttribute("prevPost", prevPost);
		}
		if (nextPost != null) {
			model.addAttribute("nextPost", nextPost);
		}

		// 최신 목록을 가져와서 모델에 추가 (조회수가 업데이트된 상태)
		List<Mod> ModList = m.getModList(null);
		model.addAttribute("ModList", ModList);
		return "getMod.jsp"; // 상세 정보를 보여줄 뷰 이름
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
		Mod post = m.getModById(mID); // 게시물 정보를 가져옴
		model.addAttribute("post", post); // 수정 폼에서 사용할 게시물 정보를 모델에 추가
		return "updateModForm.jsp"; // 수정 폼 JSP 페이지로 이동
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