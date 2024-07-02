package com.gameboard.view.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WtpostController{
	@RequestMapping (value = "getwtID.do")
	public String getwtID(Model model) {
		model.addAttribute("wtID", 1);
		return "insertWtpost.jsp";
	}
	@RequestsMapping(value = "inserWtpost.do"){
		public String insertWtpost(wtpost vo,
					HttpServletRequest request) {
			
		}
	}
