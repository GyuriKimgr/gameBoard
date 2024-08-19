package com.gameboard.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gameboard.biz.post.ModComment;
import com.gameboard.biz.post.ModCommentService;

@Controller
public class ModCommentController {

	@Autowired
	private ModCommentService ms;
	
	private String maskIpAddress(String ipAddress) {
	    if (ipAddress.contains(".")) {
	        String[] parts = ipAddress.split("\\.");
	        if (parts.length == 4) {
	            return parts[0] + "." + parts[1] + ".***." + parts[3];
	        }
	    }
	    else if (ipAddress.contains(":")) {
	        if ("0:0:0:0:0:0:0:1".equals(ipAddress)) {
	            return "local:01";
	        } else {
	            String[] parts = ipAddress.split(":");
	            return parts[0] + ":" + parts[1] + ":" + parts[2] + ":****:****:" + parts[5] + ":" + parts[6] + ":" + parts[7];
	        }
	    }
	    return ipAddress; 
	}
	
	@RequestMapping(value = "addModComment.do", method = RequestMethod.POST)
	public String addModComment(ModComment comment, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		
		if(loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}
		comment.setUserID(loggedInMemberId);
		ms.addModComment(comment);
		
		return "redirect:getMod.do?mID="+comment.getmID();
	}
	
	@RequestMapping(value = "deleteModComment.do", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String deleteModComment(@RequestParam("mCommentID") int mCommentID, @RequestParam("mID") int mID,
			HttpServletRequest request, HttpSession session) {
		String loggedInMemberId=(String) session.getAttribute("loggedInMemberId");
		if(loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}
		ModComment comment = ms.getModCommentById(mCommentID);
		
		if(comment != null && comment.getUserID().equals(loggedInMemberId)) {
			ms.deleteModComment(mCommentID);
			return "deleteModCommentSuccess";
		}else {
			return "deleteModCommentFailed";
		}
	}
}
