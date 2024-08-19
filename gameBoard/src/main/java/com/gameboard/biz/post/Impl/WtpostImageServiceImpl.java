package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.WtpostImage;
import com.gameboard.biz.post.WtpostImageDao;
import com.gameboard.biz.post.WtpostImageService;

@Service("WtpostImageService")
public class WtpostImageServiceImpl implements WtpostImageService {

	@Autowired
	private WtpostImageDao wtpostImageDao;

	@Override
	public void insertPostImage(WtpostImage wtpostImage) {
		wtpostImageDao.insertPostImage(wtpostImage);
	}

	@Override
	public List<WtpostImage> getImagesByWtID(int wtID) {
		return wtpostImageDao.getImagesByWtID(wtID);
	}

	@Override
	public void deleteWtAllImage(int wtID) {
		wtpostImageDao.deleteWtAllImage(wtID);
	}
}
