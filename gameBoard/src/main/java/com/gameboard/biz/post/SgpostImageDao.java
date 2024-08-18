package com.gameboard.biz.post;

import java.util.List;

public interface SgpostImageDao {
	public void insertPostImage(SgpostImage sgpostImage);
	public List<SgpostImage> getImagesBySgID(int sgID);
}
