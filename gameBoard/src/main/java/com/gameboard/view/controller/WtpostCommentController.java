package com.gameboard.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gameboard.biz.post.Wtpost;
import com.gameboard.biz.post.WtpostComment;
import com.gameboard.biz.post.WtpostCommentService;

@Controller
public class WtpostCommentController {

	@Autowired
	private WtpostCommentService commentService;
	
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

	@RequestMapping(value = "addWtComment.do", method = RequestMethod.POST)
	public String addWtComment(WtpostComment comment, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		System.out.println("addWtComment - loggedInMemberId: " + loggedInMemberId);
		
		if(loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}
		comment.setUserID(loggedInMemberId);
		commentService.addWtComment(comment);
		return "redirect:getWtpost.do?wtID="+comment.getWtID();
	}

	@RequestMapping(value = "deleteWtComment.do", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String deleteWtComment(@RequestParam("commentID") int commentID, @RequestParam("wtID") int wtID, 
			HttpServletRequest request, HttpSession session) {
	    String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
	    if (loggedInMemberId == null) {
	        String ipAddress = request.getRemoteAddr();
	        loggedInMemberId = maskIpAddress(ipAddress);
	    }
	    
	    WtpostComment comment = commentService.getWtCommentById(commentID);

	    // 댓글이 존재하고 댓글 작성자 ID가 로그인된 사용자 ID와 동일한지 확인
	    if (comment != null && comment.getUserID().equals(loggedInMemberId)) {
	    	commentService.deleteWtComment(commentID);
	        return "deleteCommentSuccess";
	    } else {
	        return "deleteCommentFailed";
	    }
	}
}