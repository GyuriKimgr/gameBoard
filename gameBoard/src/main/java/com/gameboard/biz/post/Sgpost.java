package com.gameboard.biz.post;

public class Sgpost {
	private int sgID;
    private String sgTitle;
    private String userID;
    private String sgDate;
    private String sgContent;
    private String searchCondition;
	private String searchKeyword;
	private int sgViews;
	
	public Sgpost() {}
	
	public Sgpost(int sgID, String sgTitle, String userID, String sgDate, String sgContent, String searchCondition,
			String searchKeyword, int sgViews) {
		super();
		this.sgID = sgID;
		this.sgTitle = sgTitle;
		this.userID = userID;
		this.sgDate = sgDate;
		this.sgContent = sgContent;
		this.searchCondition = searchCondition;
		this.searchKeyword = searchKeyword;
		this.sgViews = sgViews;
	}
	
	public int getSgID() {
		return sgID;
	}
	public void setSgID(int sgID) {
		this.sgID = sgID;
	}
	public String getSgTitle() {
		return sgTitle;
	}
	public void setSgTitle(String sgTitle) {
		this.sgTitle = sgTitle;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getSgDate() {
		return sgDate;
	}
	public void setSgDate(String sgDate) {
		this.sgDate = sgDate;
	}
	public String getSgContent() {
		return sgContent;
	}
	public void setSgContent(String sgContent) {
		this.sgContent = sgContent;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public int getSgViews() {
		return sgViews;
	}
	public void setWtViews(int sgViews) {
		this.sgViews = sgViews;
	}
}
