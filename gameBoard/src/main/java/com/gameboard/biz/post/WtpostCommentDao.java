package com.gameboard.biz.post;

import java.util.List;

public interface WtpostCommentDao {
    public void insertWtComment(WtpostComment comment);
    public List<WtpostComment> selectWtCommentsByPostId(int wtID);
    public void deleteWtComment(int commentID);
    public void deleteWtAllComment(int wtID);
    WtpostComment selectWtCommentById(int commentID);
	public int countWtCommentByPostId(int wtID);
}