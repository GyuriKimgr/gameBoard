package com.gameboard.view.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gameboard.biz.post.Wtpost;
import com.gameboard.biz.post.WtpostService;

@Controller
public class WtpostController {
	@RequestMapping(value = "getwtID.do")
	public String getwtID(Model model) {
		model.addAttribute("wtID", 1);
		return "insertWtpost.jsp";
	}
	
	@RequestMapping(value = "insertWtpost.do")
		public String insertWtpost(Wtpost vo) {
		return "getWtpostList.do";
		}
}
