package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.Comment;
import com.gameboard.biz.post.CommentDao;
import com.gameboard.biz.post.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public void addComment(Comment comment) {
		System.out.println("CommentServiceImpl");
		System.out.println(comment);
		commentDao.insertComment(comment);
	}

	@Override
	public List<Comment> getCommentsByPostId(int wtID) {
		return commentDao.selectCommentsByPostId(wtID);
	}
	
	@Override
    public void deleteComment(int commentID) {
        commentDao.deleteComment(commentID);
    }
}