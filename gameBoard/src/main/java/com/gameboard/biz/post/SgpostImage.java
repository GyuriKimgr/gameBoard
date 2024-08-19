package com.gameboard.biz.post;

public class SgpostImage {
	private int sgimageID;
	private int sgID;
	private String sgimageUrl;

	public SgpostImage() {
	}

	public SgpostImage(int sgimageID, int sgID, String sgimageUrl) {
		this.sgimageID = sgimageID;
		this.sgID = sgID;
		this.sgimageUrl = sgimageUrl;
	}

	public int getSgImageID() {
		return sgimageID;
	}

	public void setSgImageID(int sgimageID) {
		this.sgimageID = sgimageID;
	}

	public int getSgID() {
		return sgID;
	}

	public void setSgID(int sgID) {
		this.sgID = sgID;
	}

	public String getSgImageUrl() {
		return sgimageUrl;
	}

	public void setSgImageUrl(String sgimageUrl) {
		this.sgimageUrl = sgimageUrl;
	}

}