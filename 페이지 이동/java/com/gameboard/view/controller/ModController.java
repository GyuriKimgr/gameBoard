package com.gameboard.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gameboard.biz.post.Mod;
import com.gameboard.biz.post.ModService;


@Controller
public class ModController {
	@Autowired
	private ModService m;
	
	@RequestMapping(value = "getMID.do")
	public String getMID(Model model) {
		model.addAttribute("mID", m.getMID());
		model.addAttribute("mDate", m.getMDate());
		return "insertMod.jsp";
	}
	
	@RequestMapping(value = "insertMod.do")
	public String insertMod(Mod vo) {
		m.insertMod(vo);
		return "redirect:Mod.do";
	}

	@RequestMapping(value = "Mod.do")
	public String getModList(Mod vo, Model model) {
		List<Mod> ModList = m.getModList(vo);
		model.addAttribute("ModList", ModList);
		return "mod.jsp";
	}
	
	@RequestMapping(value = "searchMod.do")
	public String searchMod(Mod vo, Model model) {
		List<Mod> ModList = m.searchMod(vo);
		model.addAttribute("ModList", ModList);
		return "searchMod.jsp";
	}
}