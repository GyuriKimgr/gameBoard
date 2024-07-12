package com.gameboard.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gameboard.biz.post.Wtpost;
import com.gameboard.biz.post.WtpostService;

@Controller
public class WtpostController{
	@Autowired
	private WtpostService wt;
	
	@RequestMapping(value = "getWtID.do")
	public String getWtID(Model model) {
		model.addAttribute("wtID", wt.getWtID());
		model.addAttribute("wtDate", wt.getWtDate());
		return "insertWtpost.jsp";
	}
	
	@RequestMapping(value = "insertWtpost.do")
		public String insertWtpost(Wtpost vo) {
		wt.insertWtpost(vo);
		return "redirect:walkThrough.do";
	}
	
	@RequestMapping(value = "walkThrough.do")
	public String getWtpost(Wtpost vo, Model model) {
		List<Wtpost> WtList = wt.getWtpostList(vo);
		model.addAttribute("WtList", WtList);
		return "walkThrough.jsp";
	}
	
	// 검색
	@RequestMapping(value = "searchWtpost.do")
	public String searchWtpost(Wtpost vo, Model model) {
		List<Wtpost> WtList = wt.searchWtpost(vo);
		model.addAttribute("WtList", WtList);
		return "searchWt.jsp";
	}
	
	
	@RequestMapping(value = "getWtpost.do")
	public String getWtpostById(int wtID, Model model) {
		// 조회수 업데이트
		wt.updateWtpostViews(wtID);

		Wtpost post = wt.getWtpostById(wtID);
		model.addAttribute("post", post);

		// 이전 게시물과 다음 게시물을 가져오기 위해 ID를 기준으로 조회한다.
		Wtpost prevPost = wt.getPrevWtpost(wtID); // 이전 게시물 조회
		Wtpost nextPost = wt.getNextWtpost(wtID); // 다음 게시물 조회

		// 이전 게시물과 다음 게시물이 존재할 경우 모델에 추가한다.
		if (prevPost != null) {
			model.addAttribute("prevPost", prevPost);
		}
		if (nextPost != null) {
			model.addAttribute("nextPost", nextPost);
		}

		// 최신 목록을 가져와서 모델에 추가 (조회수가 업데이트된 상태)
		List<Wtpost> WtList = wt.getWtpostList(null);
		model.addAttribute("WtList", WtList);

		return "getWtpost.jsp"; // 상세 정보를 보여줄 뷰 이름
	}
	
	@RequestMapping(value = "deleteWtpost.do")
	public String deleteWtpost(int wtID) {
	    wt.deleteWtpost(wtID);
	    return "redirect:walkThrough.do";
	}
	
	@RequestMapping(value = "updateWtpostForm.do")
	public String updateWtpostForm(int wtID, Model model) {
	    Wtpost post = wt.getWtpostById(wtID); // 게시물 정보를 가져옴
	    model.addAttribute("post", post); // 수정 폼에서 사용할 게시물 정보를 모델에 추가
	    return "updateWtpostForm.jsp"; // 수정 폼 JSP 페이지로 이동
	}
	
	@RequestMapping(value = "updateWtpost.do")
	public String updateWtpost(Wtpost vo) {
	    wt.updateWtpost(vo); // 게시물 정보를 업데이트
	    return "redirect:getWtpost.do?wtID=" + vo.getWtID();
	}
}