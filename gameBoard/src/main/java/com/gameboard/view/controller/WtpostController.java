package com.gameboard.view.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gameboard.biz.post.WtNoticeService;
import com.gameboard.biz.post.Wtpost;
import com.gameboard.biz.post.WtpostComment;
import com.gameboard.biz.post.WtpostCommentService;
import com.gameboard.biz.post.WtpostImage;
import com.gameboard.biz.post.WtpostImageService;
import com.gameboard.biz.post.WtpostService;

@Controller
public class WtpostController {
	@Autowired
	private WtpostService wt;
	@Autowired
	private WtNoticeService noticeService;
	@Autowired
	private WtpostImageService ImageService;

	@Autowired
	private WtpostCommentService commentService;

	@RequestMapping(value = "getWtID.do")
	public String getWtID(Model model) {
		model.addAttribute("wtID", wt.getWtID());
		model.addAttribute("wtDate", wt.getWtDate());
		return "insertWtpost.jsp";
	}

	private String maskIpAddress(String ipAddress) {
		if (ipAddress.contains(".")) {
			String[] parts = ipAddress.split("\\.");
			if (parts.length == 4) {
				return parts[0] + "." + parts[1] + ".***." + parts[3];
			}
		} else if (ipAddress.contains(":")) {
			if ("0:0:0:0:0:0:0:1".equals(ipAddress)) {
				return "local:01";
			} else {
				String[] parts = ipAddress.split(":");
				return parts[0] + ":" + parts[1] + ":" + parts[2] + ":****:****:" + parts[5] + ":" + parts[6] + ":"
						+ parts[7];
			}
		}
		return ipAddress;
	}

	private String saveFile(MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		String filePath = "C:/Users/User/Desktop/»çÁø/" + fileName;
		File destinationFile = new File(filePath);
		file.transferTo(destinationFile);
		return fileName;
	}

	@RequestMapping(value = "insertWtpost.do")
	public String insertWtpost(Wtpost vo, HttpServletRequest request, HttpSession session,
			MultipartHttpServletRequest wrequest) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");

		if (loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}
		vo.setUserID(loggedInMemberId);
		wt.insertWtpost(vo);
		List<MultipartFile> files = wrequest.getFiles("images");
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				try {
					String imageUrl = saveFile(file);
					WtpostImage image = new WtpostImage();
					image.setWtID(vo.getWtID());
					image.setWtImageUrl(imageUrl);
					ImageService.insertPostImage(image);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return "redirect:getWtpost.do?wtID=" + vo.getWtID();
	}

	@RequestMapping(value = "walkThrough.do")
	public String getWtpost(Wtpost vo, Model model) {
		model.addAttribute("NoticeList", noticeService.getNotices("WT_BOARD_POST"));
		List<Wtpost> WtList = wt.getWtpostList(vo);

		Map<Integer, Integer> WTcommentConunts = new HashMap<>();

		for (Wtpost post : WtList) {
			int commentCount = commentService.countWtCommentsByPostId(post.getWtID());
			WTcommentConunts.put(post.getWtID(), commentCount);
		}

		model.addAttribute("WtList", WtList);
		model.addAttribute("WTcommentConunts", WTcommentConunts);
		return "walkThrough.jsp";
	}

	@RequestMapping(value = "searchWtpost.do")
	public String searchWtpost(Wtpost vo, Model model) {
		List<Wtpost> WtList = wt.searchWtpost(vo);

		Map<Integer, Integer> WTcommentCounts = new HashMap<>();
		
		for (Wtpost post : WtList) {
			int commentCount = commentService.countWtCommentsByPostId(post.getWtID());
			WTcommentCounts.put(post.getWtID(), commentCount);
		}

		model.addAttribute("WtList", WtList);
		model.addAttribute("WTcommentCounts", WTcommentCounts);
		return "searchWt.jsp";
	}

	@RequestMapping(value = "getWtpost.do")
	public String getWtpostById(int wtID, Model model) {
		wt.updateWtpostViews(wtID);

		Wtpost post = wt.getWtpostById(wtID);
		model.addAttribute("post", post);

		List<WtpostImage> images = ImageService.getImagesByWtID(wtID);
		model.addAttribute("images", images);

		Wtpost prevPost = wt.getPrevWtpost(wtID);
		Wtpost nextPost = wt.getNextWtpost(wtID);

		if (prevPost != null) {
			model.addAttribute("prevPost", prevPost);
		}
		if (nextPost != null) {
			model.addAttribute("nextPost", nextPost);
		}
		List<Wtpost> WtList = wt.getWtpostList(null);
		model.addAttribute("WtList", WtList);

		List<WtpostComment> commentList = commentService.getWtCommentsByPostId(wtID);
		model.addAttribute("commentList", commentList);
		int WTcommentConunts = commentService.countWtCommentsByPostId(wtID);
		model.addAttribute("WTcommentConunts", WTcommentConunts);
		model.addAttribute("wtID", wtID);

		return "getWtpost.jsp";
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
			commentService.deleteWtAllComment(wtID);
			ImageService.deleteWtAllImage(wtID);

			wt.deleteWtpost(wtID);
			return "deleteSuccess";
		} else {
			return "deleteFailed";
		}

	}

	@RequestMapping(value = "checkEditPermissionWT.do", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> checkEditPermission(@RequestParam("wtID") int wtID, HttpSession session,
			HttpServletRequest request) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");

		if (loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}

		Wtpost post = wt.getWtpostById(wtID);

		if (post != null && post.getUserID().equals(loggedInMemberId)) {
			return ResponseEntity.ok("updateSuccess|updateWtpostForm.do?wtID=" + wtID);
		} else {
			return ResponseEntity.ok("updateFailed");
		}
	}

	@RequestMapping(value = "updateWtpostForm.do")
	public String updateWtpostForm(@RequestParam("wtID") int wtID, Model model) {
		Wtpost post = wt.getWtpostById(wtID);
		List<WtpostImage> images = ImageService.getImagesByWtID(wtID);
		model.addAttribute("post", post);
		model.addAttribute("images", images);
		return "updateWtpostForm.jsp";
	}

	@RequestMapping(value = "updateWtpost.do", method = RequestMethod.POST)
	public String updateWtpost(@RequestParam("wtID") int wtID, @ModelAttribute Wtpost vo, HttpSession session,
			HttpServletRequest request, MultipartHttpServletRequest wrequest) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");

		if (loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}

		Wtpost existingPost = wt.getWtpostById(wtID);

		if (existingPost != null && existingPost.getUserID().equals(loggedInMemberId)) {
			existingPost.setWtTitle(vo.getWtTitle());
			existingPost.setWtContent(vo.getWtContent());
			wt.updateWtpost(existingPost);
		}

		List<MultipartFile> files = wrequest.getFiles("images");
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				try {
					String imageUrl = saveFile(file);
					WtpostImage image = new WtpostImage();
					image.setWtID(vo.getWtID());
					image.setWtImageUrl(imageUrl);
					ImageService.insertPostImage(image);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return "redirect:getWtpost.do?wtID=" + vo.getWtID();
	}
}