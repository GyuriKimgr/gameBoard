package com.gameboard.biz.post;

import java.util.List;

public interface ModCommentDao {
	public void insertModComment(ModComment comment);
	public List<ModComment> selectModCommentByPostId(int mID);
	public void deleteModComment(int mCommentID);
	public void deleteModAllComment(int mID);
	ModComment selectModCommentById(int mCommentID);
	public int countModCommentByPostId(int mID);
}
