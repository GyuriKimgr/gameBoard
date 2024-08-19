package com.gameboard.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gameboard.biz.post.SgNotice;
import com.gameboard.biz.post.SgNoticeService;

@Controller
public class SgNoticeController {

	@Autowired
	private SgNoticeService noticeService;

	@RequestMapping(value = "getSgNotice.do")
	public String getNoticeById(@RequestParam("noticeTitle") String noticeTitle, Model model) {
		// ���������� ���� ������ ��������
		SgNotice notice = noticeService.getNoticeByTitle(noticeTitle);
		model.addAttribute("notice", notice);

		// ��ȸ�� ������Ʈ
		noticeService.updateNoticeViews(noticeTitle);
		// ������Ʈ�� ���������� ������ �ٽ� �������� (��ȸ�� �ݿ�)
		notice = noticeService.getNoticeByTitle(noticeTitle);
		model.addAttribute("notice", notice);

		// �������� �� �������� �̵�
		return "getSgNotice.jsp";

	}
}