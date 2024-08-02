package com.gameboard.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gameboard.biz.post.Mod;
import com.gameboard.biz.post.ModService;
import com.gameboard.biz.post.Sgpost;
import com.gameboard.biz.post.SgpostService;
import com.gameboard.biz.post.Wtpost;
import com.gameboard.biz.post.WtpostService;

@Controller
public class MiddleController {
	@Autowired
    private WtpostService wt;
    @Autowired
    private SgpostService sg;
    @Autowired
    private ModService m;

    @RequestMapping(value = "middle2Page.do")
    public String getMiddle2Page(Model model) {
        // ������ ���񽺿��� �ֱ� �Խù� ��������
    	List<Wtpost> recentWtPosts = wt.getRecentWtPosts(3);
    	List<Sgpost> recentSgPosts = sg.getRecentSgPosts(3);
    	List<Mod> recentMdPosts = m.getRecentMdPosts(3);

        // �𵨿� �����͸� �߰�
        model.addAttribute("recentWtPosts", recentWtPosts);
        model.addAttribute("recentSgPosts", recentSgPosts);
        model.addAttribute("recentMdPosts", recentMdPosts);

        // �߰� ������ �並 ��ȯ
        return "middle2.jsp";
    }
}
