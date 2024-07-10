package com.gameboard.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gameboard.biz.post.Sgpost;
import com.gameboard.biz.post.SgpostService;

@Controller
public class SgpostController {
	@Autowired
	private SgpostService sg;
	
	@RequestMapping(value = "getSgID.do")
		public String getSgID(Model model) {
		model.addAttribute("sgID", sg.getSgID());
		model.addAttribute("sgDate", sg.getSgDate());
		return "insertSgpost.jsp";
	}
	
	@RequestMapping(value = "insertSgpost.do")
		public String insertSgpost(Sgpost vo) {
		sg.insertSgpost(vo);
		return "redirect:suggest.do";
	}
	
	@RequestMapping(value = "suggest.do")
		public String getSgpost(Sgpost vo, Model model) {
		List<Sgpost> SgList = sg.getSgpostList(vo);
		model.addAttribute("SgList", SgList);
		return "suggest.jsp";
	}
	
	@RequestMapping(value = "searchSgpost.do")
	public String searchSgpost(Sgpost vo, Model model) {
	List<Sgpost> SgList = sg.searchSgpost(vo);
	model.addAttribute("SgList", SgList);
	return "searchSg.jsp";
	}
	
	// ���� + ���� 
	@RequestMapping(value = "getSgpost.do")
	public String getSgpostById(int sgID, Model model) {
		Sgpost post = sg.getSgpostById(sgID);
		model.addAttribute("post", post);
		return "getSgpost.jsp"; // �� ������ ������ �� �̸�
	}
	
	@RequestMapping(value = "deleteSgpost.do")
	public String deleteSgpost(int sgID) {
	    sg.deleteSgpost(sgID);
	    return "redirect:suggest.do";
	}
	
	@RequestMapping(value = "updateSgpostForm.do")
	public String updateSgpostForm(int sgID, Model model) {
	    Sgpost post = sg.getSgpostById(sgID); // �Խù� ������ ������
	    model.addAttribute("post", post); // ���� ������ ����� �Խù� ������ �𵨿� �߰�
	    return "updateSgpostForm.jsp"; // ���� �� JSP �������� �̵�
	}
	
	@RequestMapping(value = "updateSgpost.do")
	public String updateSgpost(Sgpost vo) {
	    sg.updateSgpost(vo); // �Խù� ������ ������Ʈ
	    return "redirect:getSgpost.do?sgID=" + vo.getSgID();
	}
}