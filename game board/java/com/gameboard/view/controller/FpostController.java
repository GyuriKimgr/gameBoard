package com.gameboard.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gameboard.biz.post.Fpost;
import com.gameboard.biz.post.FpostService;
import com.gameboard.biz.post.Sgpost;


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
	
	@RequestMapping(value = "searchFpost.do")
		public String searchFpost (Fpost vo, Model model) {
		List<Fpost> FList = f.searchFpost(vo);
		model.addAttribute("FList", FList);
		return "searchF.jsp";
	}
}
