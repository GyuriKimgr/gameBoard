package com.gameboard.biz.post;

import java.sql.Date;

public class Comment {
    private int commentID;
    private int wtID;
    private String userID;
    private Date commentDate;
    private String commentContent;

    // Getters and Setters
    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getWtID() {
        return wtID;
    }

    public void setWtID(int wtID) {
        this.wtID = wtID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "commentID:"+commentID+",wtID:"+wtID+",userID:"+userID+",commentDate:"+commentDate+",commentContent:"+commentContent;
    }
}