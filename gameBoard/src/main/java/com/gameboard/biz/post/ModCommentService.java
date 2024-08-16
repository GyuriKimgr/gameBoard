package com.gameboard.biz.post;

import java.util.List;

public interface ModCommentService {
	public void addModComment(ModComment comment);
	public List<ModComment> getModCommentsByPostId(int mID);
	public void deleteModComment(int mCommentID);
	public void deleteModAllComment(int mID);
	ModComment getModCommentById(int mCommentID);
	public int countModCommentsByPostId(int mID);
}
