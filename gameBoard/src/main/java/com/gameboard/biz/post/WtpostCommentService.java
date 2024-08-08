package com.gameboard.biz.post;

import java.util.List;

public interface WtpostCommentService {
	public void addWtComment(WtpostComment comment);
	public List<WtpostComment> getWtCommentsByPostId(int wtID);
	public void deleteWtComment(int commentID);
	WtpostComment getWtCommentById(int commentID);
}