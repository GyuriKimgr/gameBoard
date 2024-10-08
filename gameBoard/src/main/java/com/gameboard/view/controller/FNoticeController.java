package com.gameboard.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gameboard.biz.post.FNotice;
import com.gameboard.biz.post.FNoticeService;

@Controller
public class FNoticeController {

	@Autowired
	private FNoticeService noticeService;

	@RequestMapping(value = "getFNotice.do")
	public String getNoticeById(@RequestParam("noticeTitle") String noticeTitle, Model model) {
		// 공지사항의 세부 정보를 가져오기
		FNotice notice = noticeService.getNoticeByTitle(noticeTitle);
		model.addAttribute("notice", notice);

		// 조회수 업데이트
		noticeService.updateNoticeViews(noticeTitle);
		// 업데이트된 공지사항의 정보를 다시 가져오기 (조회수 반영)
		notice = noticeService.getNoticeByTitle(noticeTitle);
		model.addAttribute("notice", notice);

		// 공지사항 상세 페이지로 이동
		return "getFNotice.jsp";

	}
}