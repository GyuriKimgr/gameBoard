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
	
	// 수정 + 삭제 
	@RequestMapping(value = "getMod.do")
	public String getModById(int mID, Model model) {
		Mod post = m.getModById(mID);
		model.addAttribute("post", post);
		return "getMod.jsp"; // 상세 정보를 보여줄 뷰 이름
	}
	
	@RequestMapping(value = "deleteMod.do")
	public String deleteMod(int mID) {
	    m.deleteMod(mID);
	    return "redirect:Mod.do";
	}
	
	@RequestMapping(value = "updateModForm.do")
	public String updateModForm(int mID, Model model) {
		Mod post = m.getModById(mID); // 게시물 정보를 가져옴
	    model.addAttribute("post", post); // 수정 폼에서 사용할 게시물 정보를 모델에 추가
	    return "updateModForm.jsp"; // 수정 폼 JSP 페이지로 이동
	}
	
	@RequestMapping(value = "updateMod.do")
	public String updateMod(Mod vo) {
	    m.updateMod(vo); // 게시물 정보를 업데이트
	    return "redirect:getMod.do?mID=" + vo.getmID();
	}
}