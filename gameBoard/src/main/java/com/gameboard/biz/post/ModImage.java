package com.gameboard.biz.post;

public class ModImage {
	private int mimageID;
	private int mID;
	private String mimageUrl;

	public ModImage() {
	}

	public ModImage(int mimageID, int mID, String mimageUrl) {
		this.mimageID = mimageID;
		this.mID = mID;
		this.mimageUrl = mimageUrl;
	}

	public int getmImageID() {
		return mimageID;
	}

	public void setmImageID(int mimageID) {
		this.mimageID = mimageID;
	}

	public int getmID() {
		return mID;
	}

	public void setmID(int mID) {
		this.mID = mID;
	}

	public String getmImageUrl() {
		return mimageUrl;
	}

	public void setmImageUrl(String mimageUrl) {
		this.mimageUrl = mimageUrl;
	}

}
