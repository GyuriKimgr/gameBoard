package com.gameboard.biz.post;

import java.util.List;

public interface SgpostCommentService {
	public void addSgComment(SgpostComment sgComment);
	public List<SgpostComment> getSgCommentsByPostId(int sgID);
	public void deleteSgComment(int sgCommentID);
	public void deleteSgAllComment(int sgID);
	SgpostComment getSgCommentById(int sgCommentID);
	public int countSgCommentsByPostId(int sgID);
}
