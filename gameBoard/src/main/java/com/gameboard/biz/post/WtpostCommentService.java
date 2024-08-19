package com.gameboard.biz.post;

import java.util.List;

public interface WtpostCommentService {
	public void addWtComment(WtpostComment comment);
	public List<WtpostComment> getWtCommentsByPostId(int wtID);
	public void deleteWtComment(int commentID);
	public void deleteWtAllComment(int wtID);
	WtpostComment getWtCommentById(int commentID);
	public int countWtCommentsByPostId(int wtID);
}