package com.gameboard.biz.post;

import java.util.List;

public interface WtpostImageService {
	public void insertPostImage(WtpostImage wtpostImage);
	public List<WtpostImage> getImagesByWtID(int wtID);

}
