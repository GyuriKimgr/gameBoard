package com.gameboard.view.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.gameboard.biz.post.SgpostComment;
import com.gameboard.biz.post.SgpostCommentService;
import com.gameboard.biz.post.SgpostService;

@Controller
public class SgpostController {
	@Autowired
	private SgpostService sg;
	
	@Autowired
	private SgpostCommentService sgCommentService;

	@RequestMapping(value = "getSgID.do")
	public String getSgID(Model model) {
		model.addAttribute("sgID", sg.getSgID());
		model.addAttribute("sgDate", sg.getSgDate());
		return "insertSgpost.jsp";
	}
	
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

	@RequestMapping(value = "insertSgpost.do")
	public String insertSgpost(Sgpost vo, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");

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
		
		Map<Integer, Integer> SGcommentCounts = new HashMap<>();
		for(Sgpost post : SgList) {
			int sgCommentCount = sgCommentService.countSgCommentsByPostId(post.getSgID());
			SGcommentCounts.put(post.getSgID(), sgCommentCount);
		}
		model.addAttribute("SgList", SgList);
		model.addAttribute("SGcommentCounts", SGcommentCounts);
		
		return "suggest.jsp";
	}

	@RequestMapping(value = "searchSgpost.do")
	public String searchSgpost(Sgpost vo, Model model) {
		List<Sgpost> SgList = sg.searchSgpost(vo);
		model.addAttribute("SgList", SgList);
		return "searchSg.jsp";
	}

	@RequestMapping(value = "getSgpost.do")
	public String getSgpostById(int sgID, Model model) {
		sg.updateSgpostViews(sgID);

		Sgpost post = sg.getSgpostById(sgID);
		model.addAttribute("post",post);

		Sgpost prevPost = sg.getPrevSgpost(sgID);
		Sgpost nextPost = sg.getNextSgpost(sgID);

		if (prevPost != null) {
			model.addAttribute("prevPost", prevPost);
		}
		if (nextPost != null) {
			model.addAttribute("nextPost", nextPost);
		}

		List<Sgpost> SgList = sg.getSgpostList(null);
		model.addAttribute("SgList", SgList);
		
		List<SgpostComment> sgCommentList = sgCommentService.getSgCommentsByPostId(sgID);
		model.addAttribute("sgCommentList", sgCommentList);
		int SGcommentCounts = sgCommentService.countSgCommentsByPostId(sgID);
		model.addAttribute("SGcommentCounts", SGcommentCounts);
		model.addAttribute("sgID", sgID);

		return"getSgpost.jsp";
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
	    	sgCommentService.deleteSgAllComment(sgID);
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
		Sgpost post = sg.getSgpostById(sgID); 
		model.addAttribute("post", post); 
		return "updateSgpostForm.jsp"; 
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