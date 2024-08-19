package com.gameboard.biz.post;

import java.sql.Date;

public class ModComment {
	private int mCommentID;
    private int mID;
    private String userID;
    private Date mCommentDate;
    private String mCommentContent;
    
	public int getmCommentID() {
		return mCommentID;
	}
	public void setmCommentID(int mCommentID) {
		this.mCommentID = mCommentID;
	}
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Date getmCommentDate() {
		return mCommentDate;
	}
	public void setmCommentDate(Date mCommentDate) {
		this.mCommentDate = mCommentDate;
	}
	public String getmCommentContent() {
		return mCommentContent;
	}
	public void setmCommentContent(String mCommentContent) {
		this.mCommentContent = mCommentContent;
	}
	
	@Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "mCommentID:"+mCommentID+
    			",mID:"+mID+",userID:"+userID+",mCommentDate:"
    			+mCommentDate+",mCommentContent:"+mCommentContent;
    }
}
