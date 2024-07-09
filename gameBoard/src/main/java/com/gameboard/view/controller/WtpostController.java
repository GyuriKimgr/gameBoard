package com.gameboard.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("wtDate", wt.getWtDate());
		return "insertWtpost.jsp";
	}
	
	@RequestMapping(value = "insertWtpost.do")
		public String insertWtpost(Wtpost vo) {
		wt.insertWtpost(vo);
		return "redirect:walkThrough.do";
	}
	
	@RequestMapping(value = "walkThrough.do")
	public String getWtpost(Wtpost vo, Model model) {
		List<Wtpost> WtList = wt.getWtpostList(vo);
		model.addAttribute("WtList", WtList);
		return "walkThrough.jsp";
	}
		
	@RequestMapping(value = "getWtpost.do")
	public String getWtpostById(int wtID, Model model) {
		Wtpost post = wt.getWtpostById(wtID);
		model.addAttribute("post", post);
		return "getWtpost.jsp"; // 상세 정보를 보여줄 뷰 이름
	}
	
	@RequestMapping(value = "deleteWtpost.do")
	public String deleteWtpost(int wtID) {
	    wt.deleteWtpost(wtID);
	    return "redirect:walkThrough.do";
	}



	
}
