package com.gameboard.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		@RequestMapping(value ="login.do", method = RequestMethod.POST)
		@ResponseBody
		public String login(@RequestParam("member_id") String memberId,
							@RequestParam("member_pw") String memberPw,
							HttpServletRequest request,
							HttpServletResponse response, Model model) {
			String memberName = gs.findMemberByIdAndPw(memberId, memberPw);
			
	        System.out.println("Controller: login - " + memberName);
			if(memberName != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loggedInMemberId", memberId);
				session.setAttribute("loggedInMember", memberName);
				return "success";
			}
			else {
				return "failure";
			}
		}
		@RequestMapping(value = "logout.do", method = RequestMethod.POST)
		public String logout(HttpSession session) {
			session.invalidate();
	        return "redirect:index.jsp";
		}
		
		@RequestMapping(value = "index.do", method = RequestMethod.GET)
	    public String index(HttpSession session) {
	        return "index.jsp";
	    }

}

