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

import com.gameboard.biz.post.Wtpost;
import com.gameboard.biz.post.WtpostService;

@Controller
public class WtpostController{
	@Autowired
	private WtpostService wt;

	@RequestMapping(value = "getWtID.do")
	public String getWtID(Model model) {
		model.addAttribute("wtID", wt.getWtID());
		model.addAttribute("wtDate", wt.getWtDate());
		return "insertWtpost.jsp";
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
	
	@RequestMapping(value = "insertWtpost.do")
		public String insertWtpost(Wtpost vo, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		//세션에 id 없을 시 ip 주소
		if(loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}
		vo.setUserID(loggedInMemberId);
		wt.insertWtpost(vo);
		return "redirect:walkThrough.do";
	}
	
	@RequestMapping(value = "walkThrough.do")
	public String getWtpost(Wtpost vo, Model model) {
		List<Wtpost> WtList = wt.getWtpostList(vo);
		model.addAttribute("WtList", WtList);
		return "walkThrough.jsp";
	}
	
	// 검색
	@RequestMapping(value = "searchWtpost.do")
	public String searchWtpost(Wtpost vo, Model model) {
		List<Wtpost> WtList = wt.searchWtpost(vo);
		model.addAttribute("WtList", WtList);
		return "searchWt.jsp";
	}
	
	
	@RequestMapping(value = "getWtpost.do")
	public String getWtpostById(int wtID, Model model) {
		// 조회수 업데이트
		wt.updateWtpostViews(wtID);

		Wtpost post = wt.getWtpostById(wtID);
		model.addAttribute("post", post);

		// 이전 게시물과 다음 게시물을 가져오기 위해 ID를 기준으로 조회한다.
		Wtpost prevPost = wt.getPrevWtpost(wtID); // 이전 게시물 조회
		Wtpost nextPost = wt.getNextWtpost(wtID); // 다음 게시물 조회

		// 이전 게시물과 다음 게시물이 존재할 경우 모델에 추가한다.
		if (prevPost != null) {
			model.addAttribute("prevPost", prevPost);
		}
		if (nextPost != null) {
			model.addAttribute("nextPost", nextPost);
		}

		// 최신 목록을 가져와서 모델에 추가 (조회수가 업데이트된 상태)
		List<Wtpost> WtList = wt.getWtpostList(null);
		model.addAttribute("WtList", WtList);

		return "getWtpost.jsp"; // 상세 정보를 보여줄 뷰 이름
	}
	
	@RequestMapping(value = "deleteWtpost.do", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String deleteWtpost(int wtID, HttpServletRequest request, HttpSession session) {
	    String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
	    if (loggedInMemberId == null) {
	        String ipAddress = request.getRemoteAddr();
	        loggedInMemberId = maskIpAddress(ipAddress);
	    }
	    Wtpost post = wt.getWtpostById(wtID);

	    if (post != null && post.getUserID().equals(loggedInMemberId)) {
	        wt.deleteWtpost(wtID);
	        return "deleteSuccess";
	    } else {
	        return "deleteFailed";
	    }
	}
	
	@RequestMapping(value = "checkEditPermissionWT.do", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> checkEditPermission(@RequestParam("wtID") int wtID, HttpSession session, HttpServletRequest request) {
        String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");

        if (loggedInMemberId == null) {
            String ipAddress = request.getRemoteAddr();
            loggedInMemberId = maskIpAddress(ipAddress);
        }

        Wtpost post = wt.getWtpostById(wtID);

        if (post != null && post.getUserID().equals(loggedInMemberId)) {
            // 권한이 있으면 페이지 정보를 포함한 URL을 반환
            return ResponseEntity.ok("updateSuccess|updateWtpostForm.do?wtID=" + wtID);
        } else {
            return ResponseEntity.ok("updateFailed");
        }
    }

	@RequestMapping(value = "updateWtpostForm.do")
	public String updateWtpostForm(@RequestParam("wtID") int wtID, Model model) {
	    Wtpost post = wt.getWtpostById(wtID); // 게시물 정보를 가져옴
	    model.addAttribute("post", post); // 수정 폼에서 사용할 게시물 정보를 모델에 추가
	    return "updateWtpostForm.jsp"; // 수정 폼 JSP 페이지로 이동
	}
	
	@RequestMapping(value = "updateWtpost.do", method = RequestMethod.POST)
	public String updateWtpost(@RequestParam("wtID") int wtID, @ModelAttribute Wtpost vo,
			HttpSession session, HttpServletRequest request) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");

        if (loggedInMemberId == null) {
            String ipAddress = request.getRemoteAddr();
            loggedInMemberId = maskIpAddress(ipAddress);
        }

        Wtpost existingPost = wt.getWtpostById(wtID);

        if (existingPost != null && existingPost.getUserID().equals(loggedInMemberId)) {
            existingPost.setWtTitle(vo.getWtTitle());
            existingPost.setWtContent(vo.getWtContent());
            // 게시물 정보를 업데이트합니다.
            wt.updateWtpost(existingPost);
        }
	    return "redirect:getWtpost.do?wtID=" + vo.getWtID();
	}
}