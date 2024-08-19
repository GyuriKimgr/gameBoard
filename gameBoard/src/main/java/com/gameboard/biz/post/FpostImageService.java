package com.gameboard.biz.post;

import java.util.List;

public interface FpostImageService {
	public void insertPostImage(FpostImage fpostImage);
	public List<FpostImage> getImagesByFID(int fID);
}
