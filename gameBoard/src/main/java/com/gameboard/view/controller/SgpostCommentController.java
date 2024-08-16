package com.gameboard.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gameboard.biz.post.SgpostComment;
import com.gameboard.biz.post.SgpostCommentService;

@Controller
public class SgpostCommentController {

	@Autowired
	private SgpostCommentService sgCommentService;
	
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
	
	@RequestMapping(value = "addSgComment.do", method = RequestMethod.POST)
	public String addSgComment(SgpostComment comment, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		
		if(loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}
		comment.setUserID(loggedInMemberId);
		sgCommentService.addSgComment(comment);
		return "redirect:getSgpost.do?sgID="+comment.getSgID();
	}
	
	@RequestMapping(value = "deleteSgComment.do", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String deleteSgComment(@RequestParam("sgCommentID") int sgCommentID, @RequestParam("sgID") int sgID,
			HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
	    if (loggedInMemberId == null) {
	        String ipAddress = request.getRemoteAddr();
	        loggedInMemberId = maskIpAddress(ipAddress);
	    }
	    
	    SgpostComment sgComment = sgCommentService.getSgCommentById(sgCommentID);
	    
	    if(sgComment != null && sgComment.getUserID().equals(loggedInMemberId)) {
	    	sgCommentService.deleteSgComment(sgCommentID);
	    	return "deleteSgCommentSuccess";
	    }else {
	    	return "deleteSgCommentFailed";
	    }
	}
}
