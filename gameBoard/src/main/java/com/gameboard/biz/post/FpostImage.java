package com.gameboard.biz.post;

public class FpostImage {
	private int fimageID;
	private int fID;
	private String fimageUrl;

	public FpostImage() {
	}

	public FpostImage(int fimageID, int fID, String fimageUrl) {
		this.fimageID = fimageID;
		this.fID = fID;
		this.fimageUrl = fimageUrl;
	}

	public int getfImageID() {
		return fimageID;
	}

	public void setfImageID(int fimageID) {
		this.fimageID = fimageID;
	}

	public int getfID() {
		return fID;
	}

	public void setfID(int fID) {
		this.fID = fID;
	}

	public String getfImageUrl() {
		return fimageUrl;
	}

	public void setfImageUrl(String fimageUrl) {
		this.fimageUrl = fimageUrl;
	}
}
