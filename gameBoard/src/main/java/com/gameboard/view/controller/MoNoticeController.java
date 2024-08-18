package com.gameboard.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gameboard.biz.post.MoNotice;
import com.gameboard.biz.post.MoNoticeService;

@Controller
public class MoNoticeController {

	@Autowired
	private MoNoticeService noticeService;

	@RequestMapping(value = "getMoNotice.do")
	public String getNoticeById(@RequestParam("noticeTitle") String noticeTitle, Model model) {
		// ���������� ���� ������ ��������
		MoNotice notice = noticeService.getNoticeByTitle(noticeTitle);
		model.addAttribute("notice", notice);

		// ��ȸ�� ������Ʈ
		noticeService.updateNoticeViews(noticeTitle);
		// ������Ʈ�� ���������� ������ �ٽ� �������� (��ȸ�� �ݿ�)
		notice = noticeService.getNoticeByTitle(noticeTitle);
		model.addAttribute("notice", notice);

		// �������� �� �������� �̵�
		return "getMoNotice.jsp";

	}
}