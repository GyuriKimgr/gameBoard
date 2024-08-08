package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.WtpostComment;
import com.gameboard.biz.post.WtpostCommentDao;
import com.gameboard.biz.post.WtpostCommentService;

@Service
public class WtpostCommentServiceImpl implements WtpostCommentService {

	@Autowired
	private WtpostCommentDao commentDao;

	@Override
	public void addWtComment(WtpostComment comment) {
		System.out.println("CommentServiceImpl");
		System.out.println(comment);
		commentDao.insertWtComment(comment);
	}

	@Override
	public List<WtpostComment> getWtCommentsByPostId(int wtID) {
		return commentDao.selectWtCommentsByPostId(wtID);
	}

	@Override
    public void deleteWtComment(int commentID) {
        commentDao.deleteWtComment(commentID);
    }
	
	@Override
    public WtpostComment getWtCommentById(int commentID) {
        return commentDao.selectWtCommentById(commentID);
    }
}