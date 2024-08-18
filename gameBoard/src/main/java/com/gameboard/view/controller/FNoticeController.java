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
		// ���������� ���� ������ ��������
		FNotice notice = noticeService.getNoticeByTitle(noticeTitle);
		model.addAttribute("notice", notice);

		// ��ȸ�� ������Ʈ
		noticeService.updateNoticeViews(noticeTitle);
		// ������Ʈ�� ���������� ������ �ٽ� �������� (��ȸ�� �ݿ�)
		notice = noticeService.getNoticeByTitle(noticeTitle);
		model.addAttribute("notice", notice);

		// �������� �� �������� �̵�
		return "getFNotice.jsp";

	}
}