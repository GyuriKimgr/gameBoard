package com.gameboard.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gameboard.biz.post.Wtpost;
import com.gameboard.biz.post.WtpostService;

@Controller
public class WtpostController{
	@Autowired
	private WtpostService wt;
	
	@RequestMapping(value = "getWtID.do")
	public String getWtID(Model model) {
		model.addAttribute("wtID", wt.getWtID());
		return "insertWtpost.jsp";
	}
	
	@RequestMapping(value = "insertWtpost.do")
		public String insertWtpost(Wtpost vo) {
		return "getWtpost.do";
	}
	
	@RequestMapping(value = "getWtpost.do")
	public String getWtpost(Wtpost vo, Model model) {
		List<Wtpost> WtList = wt.getWtpostList(vo);
		model.addAttribute("WtpostList", WtList);
		return "walkThrough.jsp";
	}
}
