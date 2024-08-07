package com.gameboard.biz.post;

import java.util.List;

public interface CommentDao {
    public void insertComment(Comment comment);
    public List<Comment> selectCommentsByPostId(int wtID);
    public void deleteComment(int commentID);
}