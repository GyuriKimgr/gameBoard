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
}