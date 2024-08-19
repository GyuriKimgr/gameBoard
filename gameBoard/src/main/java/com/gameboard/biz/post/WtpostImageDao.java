package com.gameboard.biz.post;

import java.util.List;

public interface WtpostImageDao {
	public void insertPostImage(WtpostImage wtpostImage);
	public List<WtpostImage> getImagesByWtID(int wtID);

}
