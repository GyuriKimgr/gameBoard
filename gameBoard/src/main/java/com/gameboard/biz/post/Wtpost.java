package com.gameboard.biz.post;
import org.springframework.web.multipart.MultipartFile;

public class Wtpost{
    private int wtID;
    private String wtTitle;
    private String userID;
    private String wtDate;
    private String wtContent;
	public Wtpost(int wtID, String wtTitle, String userID, String wtDate, String wtContent) {
		super();
		this.wtID = wtID;
		this.wtTitle = wtTitle;
		this.userID = userID;
		this.wtDate = wtDate;
		this.wtContent = wtContent;
	}
	public int getWtID() {
		return wtID;
	}
	public void setWtID(int wtID) {
		this.wtID = wtID;
	}
	public String getWtTitle() {
		return wtTitle;
	}
	public void setWtTitle(String wtTitle) {
		this.wtTitle = wtTitle;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getWtDate() {
		return wtDate;
	}
	public void setWtDate(String wtDate) {
		this.wtDate = wtDate;
	}
	public String getWtContent() {
		return wtContent;
	}
	public void setWtContent(String wtContent) {
		this.wtContent = wtContent;
	}
    
    
}

