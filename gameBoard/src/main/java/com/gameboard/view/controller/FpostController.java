package com.gameboard.view.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gameboard.biz.post.FNoticeService;
import com.gameboard.biz.post.Fpost;
import com.gameboard.biz.post.FpostImage;
import com.gameboard.biz.post.FpostImageService;
import com.gameboard.biz.post.FpostService;

@Controller
public class FpostController {
	@Autowired
	private FpostService f;
	
	@Autowired
	private FNoticeService noticeService;

	@Autowired
	private FpostImageService ImageService;

	@RequestMapping(value = "getFID.do")
	public String getFID(Model model) {
		model.addAttribute("fID", f.getFID());
		model.addAttribute("fDate", f.getFDate());
		return "insertFpost.jsp";
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
	private String saveFile(MultipartFile file) throws IOException {
			String fileName = file.getOriginalFilename();
			String filePath = "resources/images/" + fileName;
			File destinationFile = new File(filePath);
			file.transferTo(destinationFile);
			return fileName;
	}

	@RequestMapping(value = "insertFpost.do")
	public String insertFpost(Fpost vo, HttpServletRequest request, HttpSession session,
			MultipartHttpServletRequest frequest) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		if(loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}
		vo.setUserID(loggedInMemberId);
		
		f.insertFpost(vo);
		List<MultipartFile> files = frequest.getFiles("images");
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				try {
					String imageUrl = saveFile(file);
					FpostImage image = new FpostImage();
					image.setfID(vo.getfID());
					image.setfImageUrl(imageUrl);
					ImageService.insertPostImage(image);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:getFpost.do?fID=" + vo.getfID();
	}

	@RequestMapping(value = "FAQ.do")
	public String getFpost(Fpost vo, Model model) {
		model.addAttribute("NoticeList", noticeService.getNotices("FAQ_BOARD_POST"));
		List<Fpost> FList = f.getFpostList(vo);
		model.addAttribute("FList", FList);
		return "FAQ.jsp";
	}

	@RequestMapping(value = "searchFpost.do")
	public String searchFpost(Fpost vo, Model model) {
		List<Fpost> FList = f.searchFpost(vo);
		model.addAttribute("FList", FList);
		return "searchF.jsp";
	}

	@RequestMapping(value = "getFpost.do")
	public String getFpostById(int fID, Model model) {
		f.updateFpostViews(fID);

		Fpost post = f.getFpostById(fID);
		model.addAttribute("post", post);
		
		// �떟蹂� �셿猷뚮맂 寃쎌슦�뿉留� �떟蹂� 媛��졇�삤湲�
        Fpost completedPost = f.getAnswerIfCompleted(fID);
        if (completedPost != null && "�떟蹂��셿猷�".equals(completedPost.getStatus())) {
            model.addAttribute("answer", completedPost.getAnswer());
        }

		Fpost prevPost = f.getPrevFpost(fID); 
		Fpost nextPost = f.getNextFpost(fID);

		if (prevPost != null) {
			model.addAttribute("prevPost", prevPost);
		}
		if (nextPost != null) {
			model.addAttribute("nextPost", nextPost);
		}
		List<Fpost> FList = f.getFpostList(null);
		model.addAttribute("FList", FList);

		return "getFpost.jsp"; 
	}

	@RequestMapping(value = "deleteFpost.do", produces = "text/plain; charset = UTF-8")
	@ResponseBody
	public String deleteFpost(int fID, HttpServletRequest request, HttpSession session) {
		String loggedInMemberId = (String) session.getAttribute("loggedInMemberId");
		if(loggedInMemberId == null) {
			String ipAddress = request.getRemoteAddr();
			loggedInMemberId = maskIpAddress(ipAddress);
		}
		Fpost post = f.getFpostById(fID);
		
		if(post != null && post.getUserID().equals(loggedInMemberId)) {
			ImageService.deleteFAllImage(fID);
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
            return ResponseEntity.ok("updateSuccess|updateFpostForm.do?fID=" + fID);
        } else {
            return ResponseEntity.ok("updateFailed");
        }
    }

	@RequestMapping(value = "updateFpostForm.do")
	public String updateFpostForm(@RequestParam("fID") int fID, Model model) {
		Fpost post = f.getFpostById(fID);
		List<FpostImage> images = ImageService.getImagesByFID(fID);
		model.addAttribute("post", post);
		model.addAttribute("images", images);
		return "updateFpostForm.jsp";
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
            f.updateFpost(existingPost);
        }
		return "redirect:getFpost.do?fID=" + vo.getfID();
	}
}
