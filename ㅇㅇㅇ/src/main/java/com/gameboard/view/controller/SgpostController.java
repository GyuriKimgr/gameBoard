package com.gameboard.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping(value = "insertSgpost.do")
		public String insertSgpost(Sgpost vo) {
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
		Sgpost post = sg.getSgpostById(sgID);
		model.addAttribute("post", post);
		return "getSgpost.jsp"; // 상세 정보를 보여줄 뷰 이름
	}
	
	@RequestMapping(value = "deleteSgpost.do")
	public String deleteSgpost(int sgID) {
	    sg.deleteSgpost(sgID);
	    return "redirect:suggest.do";
	}
	
	@RequestMapping(value = "updateSgpostForm.do")
	public String updateSgpostForm(int sgID, Model model) {
	    Sgpost post = sg.getSgpostById(sgID); // 게시물 정보를 가져옴
	    model.addAttribute("post", post); // 수정 폼에서 사용할 게시물 정보를 모델에 추가
	    return "updateSgpostForm.jsp"; // 수정 폼 JSP 페이지로 이동
	}
	
	@RequestMapping(value = "updateSgpost.do")
	public String updateSgpost(Sgpost vo) {
	    sg.updateSgpost(vo); // 게시물 정보를 업데이트
	    return "redirect:getSgpost.do?sgID=" + vo.getSgID();
	}
}