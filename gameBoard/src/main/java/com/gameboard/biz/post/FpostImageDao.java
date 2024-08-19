package com.gameboard.biz.post;

import java.util.List;

public interface FpostImageDao {
	public void insertPostImage(FpostImage fpostImage);
	public List<FpostImage> getImagesByFID(int fID);
	public void deleteFAllImage(int fID);
}
