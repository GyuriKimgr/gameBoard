package com.gameboard.biz.post;

public class Fpost {
	private int fID;
	private String fTitle;
	private String userID;
	private String fDate;
	private String fContent;
	private String searchCondition;
	private String searchKeyword;
	private int fViews;
	private String answer;
	private String status;

	public Fpost() {
	}

	public Fpost(int fID, String fTitle, String userID, String fDate, String fContent, String searchCondition,
			String searchKeyword, int fViews, String answer, String status) {
		super();
		this.fID = fID;
		this.fTitle = fTitle;
		this.userID = userID;
		this.fDate = fDate;
		this.fContent = fContent;
		this.searchCondition = searchCondition;
		this.searchKeyword = searchKeyword;
		this.fViews = fViews;
		this.answer = answer;
		this.status = status;
	}

	public int getfID() {
		return fID;
	}

	public void setfID(int fID) {
		this.fID = fID;
	}

	public String getfTitle() {
		return fTitle;
	}

	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getfDate() {
		return fDate;
	}

	public void setfDate(String fDate) {
		this.fDate = fDate;
	}

	public String getfContent() {
		return fContent;
	}

	public void setfContent(String fContent) {
		this.fContent = fContent;
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

	public int getfViews() {
		return fViews;
	}

	public void setfViews(int fViews) {
		this.fViews = fViews;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
