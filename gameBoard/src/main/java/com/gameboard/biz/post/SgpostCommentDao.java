package com.gameboard.biz.post;

import java.util.List;

public interface SgpostCommentDao {
	public void insertSgComment(SgpostComment sgComment);
	public List<SgpostComment> selectSgCommentsByPostId(int sgID);
	public void deleteSgComment(int sgCommentID);
	public void deleteSgAllComment(int sgCommentID);
	SgpostComment selectSgCommentById(int sgCommentID);
	public int countSgCommentsByPostId(int sgID);
	
}
