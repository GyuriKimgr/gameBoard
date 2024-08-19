package com.gameboard.biz.post;

import java.util.List;

public interface SgpostImageService {
	public void insertPostImage(SgpostImage sgpostImage);
	public List<SgpostImage> getImagesBySgID(int sgID);
	public void deleteSgAllImage(int sgID);

}
