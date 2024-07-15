package com.gameboard.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gameboard.biz.post.Fpost;
import com.gameboard.biz.post.FpostService;

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

	@RequestMapping(value = "insertFpost.do")
	public String insertFpost(Fpost vo) {
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

	@RequestMapping(value = "deleteFpost.do")
	public String deleteFpost(int fID) {
		f.deleteFpost(fID);
		return "redirect:FAQ.do";
	}

	@RequestMapping(value = "updateFpostForm.do")
	public String updateFpostForm(int fID, Model model) {
		Fpost post = f.getFpostById(fID); // 게시물 정보를 가져옴
		model.addAttribute("post", post); // 수정 폼에서 사용할 게시물 정보를 모델에 추가
		return "updateFpostForm.jsp"; // 수정 폼 JSP 페이지로 이동
	}

	@RequestMapping(value = "updateFpost.do")
	public String updateFpost(Fpost vo) {
		f.updateFpost(vo); // 게시물 정보를 업데이트
		return "redirect:getFpost.do?fID=" + vo.getfID();
	}
}
