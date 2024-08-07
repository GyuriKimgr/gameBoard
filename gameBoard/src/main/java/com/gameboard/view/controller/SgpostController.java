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

import com.gameboard.biz.post.Sgpost;
import com.gameboard.biz.post.SgpostService;

@Controller
public class SgpostController {
	@Autowired
	private SgpostService sg;

	@RequestMapping(value = "getSgID.do")
	public String getSgID(Model model) {
		model.addAttribute("sgID", sg.getSgID());
		model.addAttribute("sgDate", sg.getSgDate());
		return "insertSgpost.jsp";
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

	@RequestMapping(value = "insertSgpost.do")
	public String insertSgpost(Sgpost vo, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		//세션에 id 없을 시 ip 주소
		if(loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}
		vo.setUserID(loggedInMemberId);
		sg.insertSgpost(vo);
		return "redirect:suggest.do";
	}

	@RequestMapping(value = "suggest.do")
	public String getSgpost(Sgpost vo, Model model) {
		List<Sgpost> SgList = sg.getSgpostList(vo);
		model.addAttribute("SgList", SgList);
		return "suggest.jsp";
	}

	@RequestMapping(value = "searchSgpost.do")
	public String searchSgpost(Sgpost vo, Model model) {
		List<Sgpost> SgList = sg.searchSgpost(vo);
		model.addAttribute("SgList", SgList);
		return "searchSg.jsp";
	}

	// 수정 + 삭제
	@RequestMapping(value = "getSgpost.do")
	public String getSgpostById(int sgID, Model model) {
		// 조회수 업데이트
		sg.updateSgpostViews(sgID);

		Sgpost post = sg.getSgpostById(sgID);
		model.addAttribute("post",post);

		// 이전 게시물과 다음 게시물을 가져오기 위해 ID를 기준으로 조회한다.
		Sgpost prevPost = sg.getPrevSgpost(sgID); // 이전 게시물 조회
		Sgpost nextPost = sg.getNextSgpost(sgID); // 다음 게시물 조회

		// 이전 게시물과 다음 게시물이 존재할 경우 모델에 추가한다.
		if (prevPost != null) {
			model.addAttribute("prevPost", prevPost);
		}
		if (nextPost != null) {
			model.addAttribute("nextPost", nextPost);
		}

		// 최신 목록을 가져와서 모델에 추가 (조회수가 업데이트된 상태)
		List<Sgpost> SgList = sg.getSgpostList(null);
		model.addAttribute("SgList", SgList);

		return"getSgpost.jsp"; // 상세 정보를 보여줄 뷰 이름
	}


	@RequestMapping(value = "deleteSgpost.do", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String deleteSgpost(int sgID, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
	    if (loggedInMemberId == null) {
	        String ipAddress = request.getRemoteAddr();
	        loggedInMemberId = maskIpAddress(ipAddress);
	    }
	    Sgpost post = sg.getSgpostById(sgID);
		
	    if(post != null && post.getUserID().equals(loggedInMemberId)) {
	    	sg.deleteSgpost(sgID);
	    	return "deleteSuccess";
	    }else {
	    	return "deleteFailed";
	    }
	}
	
	@RequestMapping(value = "checkEditPermissionSG.do", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> checkEditPermission(@RequestParam("sgID") int sgID, HttpSession session, HttpServletRequest request) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
	    if (loggedInMemberId == null) {
	        String ipAddress = request.getRemoteAddr();
	        loggedInMemberId = maskIpAddress(ipAddress);
	    }
	    
	    Sgpost post = sg.getSgpostById(sgID);
	    
	    if(post != null && post.getUserID().equals(loggedInMemberId)) {
	    	return ResponseEntity.ok("updateSuccess|updateSgpostForm.do?sgID=" + sgID);
        } else {
            return ResponseEntity.ok("updateFailed");
        }
	}

	@RequestMapping(value = "updateSgpostForm.do")
	public String updateSgpostForm(@RequestParam("sgID") int sgID, Model model) {
		Sgpost post = sg.getSgpostById(sgID); // 게시물 정보를 가져옴
		model.addAttribute("post", post); // 수정 폼에서 사용할 게시물 정보를 모델에 추가
		return "updateSgpostForm.jsp"; // 수정 폼 JSP 페이지로 이동
	}

	@RequestMapping(value = "updateSgpost.do", method = RequestMethod.POST)
	public String updateSgpost(@RequestParam("sgID") int sgID, @ModelAttribute Sgpost vo,
			HttpSession session, HttpServletRequest request) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");

        if (loggedInMemberId == null) {
            String ipAddress = request.getRemoteAddr();
            loggedInMemberId = maskIpAddress(ipAddress);
        }
        Sgpost existingPost = sg.getSgpostById(sgID);
        
        if(existingPost != null && existingPost.getUserID().equals(loggedInMemberId)) {
        	existingPost.setSgTitle(vo.getSgTitle());
        	existingPost.setSgContent(vo.getSgContent());
        	sg.updateSgpost(existingPost);
        }
		return "redirect:getSgpost.do?sgID=" + vo.getSgID();
	}
}