package com.gameboard.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gameboard.biz.post.BoardNotice;
import com.gameboard.biz.post.BoardNoticeService;

@Controller
public class BoardNoticeController {
	
	@Autowired
	private BoardNoticeService noticeService;

	@RequestMapping(value = "getNotice.do")
	public String getNoticeById(@RequestParam("noticeID") String noticeID, Model model) {
		// 공지사항의 세부 정보를 가져오기
		BoardNotice notice = noticeService.getNoticeById(noticeID);
		model.addAttribute("notice", notice);

		// 공지사항 상세 페이지로 이동
		return "getNotice.jsp";
	}

}