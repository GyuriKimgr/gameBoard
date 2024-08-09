package com.gameboard.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gameboard.biz.post.Comment;
import com.gameboard.biz.post.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "addComment.do", method = RequestMethod.POST)
	public String addComment(Comment comment) {
		System.out.println("	@RequestMapping(value = \"addComment.do\", method = RequestMethod.POST)"); 
		
		System.out.println(comment);
		commentService.addComment(comment);
		return "redirect:getWtpost.do?wtID="+comment.getWtID();
	}


	@RequestMapping(value = "deleteComment.do", method = RequestMethod.POST)
	public String deleteComment(@RequestParam("commentID") int commentID, @RequestParam("wtID") int wtID) {
		commentService.deleteComment(commentID);
		return "redirect:getWtpost.do?wtID="+wtID;
	}

}