package com.gameboard.biz.post;

import java.util.List;

public interface ModImageDao {
	public void insertPostImage(ModImage modImage);
	public List<ModImage> getImagesByMID(int mID);
	public void deleteModAllImage(int mID);
}
