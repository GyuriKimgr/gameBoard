package com.gameboard.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gameboard.biz.post.GameMember;
import com.gameboard.biz.post.GameMemberService;

@Controller
public class GameMemberController{
	@Autowired
	private GameMemberService gs;
	
	@RequestMapping(value = "checkIdDuplicate.do", method = RequestMethod.GET)
	@ResponseBody
	public String checkIdDuplicate(@RequestParam("memberId") String memberId) {
		int result = gs.checkIdDuplicate(memberId);
	    if (result > 0) {
	        return "duplicate";
	    } else {
	        return "available";
	    }
	}
	
	@RequestMapping(value = "getJoinDate.do")
	public String getJoinDate(Model model) {
		model.addAttribute("memberJoinDate", gs.getJoinDate());
		return "member_join.jsp";
	}
	
	@RequestMapping(value = "memberJoin.do", method = RequestMethod.POST)
	public String memberJoin(GameMember gm) {
		gs.insertGameMember(gm);
		return "redirect:index.jsp";
	}
}
