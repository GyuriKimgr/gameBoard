package com.gameboard.biz.post;

import java.util.List;

public interface CommentService {
	public void addComment(Comment comment);
	public List<Comment> getCommentsByPostId(int wtID);
	public void deleteComment(int commentID);
	
}