package com.gameboard.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gameboard.biz.post.GameMember;
import com.gameboard.biz.post.GameMemberService;
import com.gameboard.biz.post.Wtpost;
import com.gameboard.biz.post.WtpostService;

@Controller
public class GameMemberController{
	@Autowired
	private GameMemberService gs;
	
	@RequestMapping(value = "getJoinDate.do")
	public String getJoinDate(Model model) {
		model.addAttribute("memberJoinDate", gs.getJoinDate());
		return "member_join.jsp";
	}
	
	@RequestMapping(value = "/checkIdDuplicate")
	@ResponseBody
	public String checkIdDuplicate(@RequestParam("member_id") String memberId) {
		int result = gs.checkIdDuplicate(memberId);
	    if (result > 0) {
	        return "duplicate";
	    } else {
	        return "available";
	    }
	}
	
	@RequestMapping(value = "memberJoin.do")
	public String memberJoin(GameMember gm) {
		gs.insertGameMember(gm);
		return "redirect:index.jsp";
	}
	
    // ���̵� ã�� ����
	@RequestMapping(value="find_id_phone.do")
	@ResponseBody
	public String findId_phone(@RequestParam("member_name") String memberName, 
								@RequestParam("member_phone") String memberPhone) {
		String id = gs.findId_NameAndPhone(memberName, memberPhone);
		return id;
	}
	
	@RequestMapping(value="find_id_email.do")
	@ResponseBody
	public String findId_email(@RequestParam("member_name") String memberName, 
							  @RequestParam("member_email") String memberEmail) {
		String id = gs.findId_NameAndEmail(memberName, memberEmail);
		return id;
	}
	
	 // ��й�ȣ ã�� ����
		@RequestMapping(value="find_pw_phone.do")
		@ResponseBody
		public String findPw_phone(@RequestParam("member_id") String memberId,
								   @RequestParam("member_name") String memberName, 
								   @RequestParam("member_phone") String memberPhone) {
			String pw = gs.findPw_NameAndPhone(memberId, memberName, memberPhone);
			return pw;
		}
		
		@RequestMapping(value="find_pw_email.do")
		@ResponseBody
		public String findPw_email(@RequestParam("member_id") String memberId,
								   @RequestParam("member_name") String memberName, 
								   @RequestParam("member_email") String memberEmail) {
			String pw = gs.findPw_NameAndEmail(memberId, memberName, memberEmail);
			return pw;
		}


}

