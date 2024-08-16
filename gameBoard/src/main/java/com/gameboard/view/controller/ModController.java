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

import com.gameboard.biz.post.Mod;
import com.gameboard.biz.post.ModComment;
import com.gameboard.biz.post.ModCommentService;
import com.gameboard.biz.post.ModService;

@Controller
public class ModController {
	@Autowired
	private ModService m;

	@Autowired
	private ModCommentService ms;
	
	@RequestMapping(value = "getMID.do")
	public String getMID(Model model) {
		model.addAttribute("mID", m.getMID());
		model.addAttribute("mDate", m.getMDate());
		return "insertMod.jsp";
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
		
		Map<Integer, Integer> MODcommentCounts = new HashMap<>();
		for(Mod post : ModList) {
			int mCommentCount = ms.countModCommentsByPostId(post.getmID());
			MODcommentCounts.put(post.getmID(), mCommentCount);
		}
		model.addAttribute("ModList", ModList);
		model.addAttribute("MODCommentCounts", MODcommentCounts);
		return "mod.jsp";
	}

	@RequestMapping(value = "searchMod.do")
	public String searchMod(Mod vo, Model model) {
		List<Mod> ModList = m.searchMod(vo);
		model.addAttribute("ModList", ModList);
		return "searchMod.jsp";
	}

	@RequestMapping(value = "getMod.do")
	public String getModById(int mID, Model model) {
		m.updateModViews(mID);

		Mod post = m.getModById(mID);
		model.addAttribute("post", post);

		Mod prevPost = m.getPrevMod(mID);
		Mod nextPost = m.getNextMod(mID);

		if (prevPost != null) {
			model.addAttribute("prevPost", prevPost);
		}
		if (nextPost != null) {
			model.addAttribute("nextPost", nextPost);
		}

		List<Mod> ModList = m.getModList(null);
		model.addAttribute("ModList", ModList);
		
		List<ModComment> McommentList = ms.getModCommentsByPostId(mID);
		model.addAttribute("McommentList", McommentList);
		int MODcommentCounts = ms.countModCommentsByPostId(mID);
		model.addAttribute("MODcommentCounts", MODcommentCounts);
		model.addAttribute("mID", mID);
		return "getMod.jsp";
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
		    	ms.deleteModAllComment(mID);
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
		Mod post = m.getModById(mID);
		model.addAttribute("post", post);
		return "updateModForm.jsp";
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