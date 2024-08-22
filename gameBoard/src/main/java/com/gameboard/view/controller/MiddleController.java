package com.gameboard.view.controller;

import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    	List<Wtpost> recentWtPosts = wt.getRecentWtPosts(4);
    	List<Sgpost> recentSgPosts = sg.getRecentSgPosts(4);
    	List<Mod> recentMdPosts = m.getRecentMdPosts(4);

        model.addAttribute("recentWtPosts", recentWtPosts);
        model.addAttribute("recentSgPosts", recentSgPosts);
        model.addAttribute("recentMdPosts", recentMdPosts);

        return "middle2.jsp";
    }
    
    @RequestMapping(value = "recentWtPosts.do", method = RequestMethod.GET,produces = "application/text; charset=utf8" )
    @ResponseBody
    public String getRecentWtPosts() {

        List<Wtpost> recentWtPosts = wt.getRecentWtPosts(3);
        StringJoiner sj = new StringJoiner("\n");
        for (Wtpost post : recentWtPosts) {
            sj.add(post.getWtID() + "|" + post.getWtTitle() + "|" + post.getWtDate() + "|" + post.getWtContent());
        }
		return sj.toString();
    }

    @RequestMapping(value = "recentSgPosts.do", method = RequestMethod.GET,produces = "application/text; charset=utf8")
    @ResponseBody
    public String wtResponse() {
        List<Sgpost> recentSgPosts = sg.getRecentSgPosts(3);
        StringJoiner sj = new StringJoiner("\n");
        for (Sgpost post : recentSgPosts) {
            sj.add(post.getSgID() + "|" + post.getSgTitle() + "|" + post.getSgDate() + "|" + post.getSgContent());
        }
		return sj.toString();
    }

    @RequestMapping(value = "recentMdPosts.do", method = RequestMethod.GET,produces = "application/text; charset=utf8")
    @ResponseBody
    public String getRecentMdPosts() {
        List<Mod> recentMdPosts = m.getRecentMdPosts(3);
        StringJoiner sj = new StringJoiner("\n");
        for (Mod post : recentMdPosts) {
            sj.add(post.getmID() + "|" + post.getmTitle() + "|" + post.getmDate() + "|" + post.getmContent());
        }
		return sj.toString();
    }
}
