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
import com.gameboard.biz.post.Wtpost;

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

	@RequestMapping(value = "insertFpost.do")
	public String insertFpost(Fpost vo, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		//세션에 id 없을 시 ip 주소
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

	// 검색
	@RequestMapping(value = "searchFpost.do")
	public String searchFpost(Fpost vo, Model model) {
		List<Fpost> FList = f.searchFpost(vo);
		model.addAttribute("FList", FList);
		return "searchF.jsp";
	}

	// 수정 + 삭제
	@RequestMapping(value = "getFpost.do")
	public String getFpostById(int fID, Model model) {
		// 조회수 업데이트
		f.updateFpostViews(fID);

		Fpost post = f.getFpostById(fID);
		model.addAttribute("post", post);

		// 이전 게시물과 다음 게시물을 가져오기 위해 ID를 기준으로 조회한다.
		Fpost prevPost = f.getPrevFpost(fID); // 이전 게시물 조회
		Fpost nextPost = f.getNextFpost(fID); // 다음 게시물 조회

		// 이전 게시물과 다음 게시물이 존재할 경우 모델에 추가한다.
		if (prevPost != null) {
			model.addAttribute("prevPost", prevPost);
		}
		if (nextPost != null) {
			model.addAttribute("nextPost", nextPost);
		}

		// 최신 목록을 가져와서 모델에 추가 (조회수가 업데이트된 상태)
		List<Fpost> FList = f.getFpostList(null);
		model.addAttribute("FList", FList);

		return "getFpost.jsp"; // 상세 정보를 보여줄 뷰 이름
	}

	@RequestMapping(value = "deleteFpost.do", produces = "text/plain; charset = UTF-8")
	@ResponseBody
	public String deleteFpost(int fID, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		//세션에 id 없을 시 ip 주소
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
            // 권한이 있으면 페이지 정보를 포함한 URL을 반환
            return ResponseEntity.ok("updateSuccess|updateFpostForm.do?fID=" + fID);
        } else {
            return ResponseEntity.ok("updateFailed");
        }
    }

	@RequestMapping(value = "updateFpostForm.do")
	public String updateFpostForm(@RequestParam("fID") int fID, Model model) {
		Fpost post = f.getFpostById(fID); // 게시물 정보를 가져옴
		model.addAttribute("post", post); // 수정 폼에서 사용할 게시물 정보를 모델에 추가
		return "updateFpostForm.jsp"; // 수정 폼 JSP 페이지로 이동
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
            // 게시물 정보를 업데이트
            f.updateFpost(existingPost);
        }
		return "redirect:getFpost.do?fID=" + vo.getfID();
	}
}
