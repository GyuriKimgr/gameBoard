package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.SgpostImage;
import com.gameboard.biz.post.SgpostImageDao;
import com.gameboard.biz.post.SgpostImageService;

@Service("SgpostImageService")
public class SgpostImageServiceImpl implements SgpostImageService {

	@Autowired
	private SgpostImageDao sgpostImageDao;

	@Override
	public void insertPostImage(SgpostImage sgpostImage) {
		sgpostImageDao.insertPostImage(sgpostImage);
	}

	@Override
	public List<SgpostImage> getImagesBySgID(int sgID) {
		return sgpostImageDao.getImagesBySgID(sgID);
	}

}
