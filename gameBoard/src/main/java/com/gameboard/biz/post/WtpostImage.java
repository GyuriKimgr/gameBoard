package com.gameboard.biz.post;

public class WtpostImage {
	private int wtimageID;
	private int wtID;
	private String wtimageUrl;

	public WtpostImage() {
	}

	public WtpostImage(int wtimageID, int wtID, String wtimageUrl) {
		this.wtimageID = wtimageID;
		this.wtID = wtID;
		this.wtimageUrl = wtimageUrl;
	}

	public int getWtImageID() {
		return wtimageID;
	}

	public void setWtImageID(int wtimageID) {
		this.wtimageID = wtimageID;
	}

	public int getWtID() {
		return wtID;
	}

	public void setWtID(int wtID) {
		this.wtID = wtID;
	}

	public String getWtImageUrl() {
		return wtimageUrl;
	}

	public void setWtImageUrl(String wtimageUrl) {
		this.wtimageUrl = wtimageUrl;
	}

}