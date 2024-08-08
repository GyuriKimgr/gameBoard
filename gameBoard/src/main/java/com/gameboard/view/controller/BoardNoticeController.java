package com.gameboard.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gameboard.biz.post.BoardNoticeService;

@Controller
public class BoardNoticeController {

    @Autowired
    private BoardNoticeService noticeService;

    @RequestMapping(value = "WT.do", method = RequestMethod.GET)
    public String showWtBoard(Model model) {
        // "WT_BOARD_POST"는 walkthrough 게시판의 boardType 값입니다.
        model.addAttribute("notices", noticeService.getNotices("WT_BOARD_POST"));
        return "walkThrough.jsp";  // JSP 파일 이름이 정확한지 확인하세요.
    }

    @RequestMapping(value = "SG.do", method = RequestMethod.GET)
    public String showSgBoard(Model model) {
        // "SG_BOARD_POST"는 suggest 게시판의 boardType 값입니다.
        model.addAttribute("notices", noticeService.getNotices("SG_BOARD_POST"));
        return "suggest.jsp";  // JSP 파일 이름이 정확한지 확인하세요.
    }

    @RequestMapping(value = "MD.do", method = RequestMethod.GET)
    public String showModBoard(Model model) {
        // "MOD_BOARD"는 mod 게시판의 boardType 값입니다.
        model.addAttribute("notices", noticeService.getNotices("MOD_BOARD"));
        return "mod.jsp";  // JSP 파일 이름이 정확한지 확인하세요.
    }

    @RequestMapping(value = "FA.do", method = RequestMethod.GET)
    public String showFAQBoard(Model model) {
        // "FAQ_BOARD"는 FAQ 게시판의 boardType 값입니다.
        model.addAttribute("notices", noticeService.getNotices("FAQ_BOARD"));
        return "FAQ.jsp";  // JSP 파일 이름이 정확한지 확인하세요.
    }
}