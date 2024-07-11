package com.gameboard.biz.post;

public class Mod {
    private int mID;
    private String mTitle;
    private String userID;
    private String mDate;
    private String mContent;
    private String searchCondition;
	private String searchKeyword;
	
	public Mod() {}
	
	public Mod(int mID, String mTitle, String userID, String mDate, String mContent, String searchCondition,
			String searchKeyword) {
		super();
		this.mID = mID;
		this.mTitle = mTitle;
		this.userID = userID;
		this.mDate = mDate;
		this.mContent = mContent;
		this.searchCondition = searchCondition;
		this.searchKeyword = searchKeyword;
	}

	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
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
	
}