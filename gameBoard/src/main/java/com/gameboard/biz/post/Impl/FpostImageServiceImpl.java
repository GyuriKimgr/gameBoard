package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.FpostImage;
import com.gameboard.biz.post.FpostImageDao;
import com.gameboard.biz.post.FpostImageService;

@Service("FpostImageService")
public class FpostImageServiceImpl implements FpostImageService {

	@Autowired
	private FpostImageDao fpostImageDao;

	@Override
	public void insertPostImage(FpostImage fpostImage) {
		fpostImageDao.insertPostImage(fpostImage);
	}

	@Override
	public List<FpostImage> getImagesByFID(int fID) {
		return fpostImageDao.getImagesByFID(fID);
	}

}
