package com.gameboard.biz.post;

import java.sql.Date;

public class SgpostComment {
	private int sgCommentID;
	private int sgID;
	private String userID;
	private Date sgCommentDate;
	private String sgCommentContent;
	
	public int getSgCommentID() {
		return sgCommentID;
	}
	
	public void setSgCommentID(int sgCommentID) {
		this.sgCommentID = sgCommentID;
	}
	public int getSgID() {
		return sgID;
	}
	public void setSgID(int sgID) {
		this.sgID = sgID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Date getSgCommentDate() {
		return sgCommentDate;
	}
	public void setSgCommentDate(Date sgCommentDate) {
		this.sgCommentDate = sgCommentDate;
	}
	public String getSgCommentContent() {
		return sgCommentContent;
	}
	public void setSgCommentContent(String sgCommentContent) {
		this.sgCommentContent = sgCommentContent;
	}
	
	@Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "sgCommentID:"+sgCommentID+",sgID:"+sgID
    			+",userID:"+userID+",sgCommentDate:"+sgCommentDate+
    			",sgCommentContent:"+sgCommentContent;
    }

}
