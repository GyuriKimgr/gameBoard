package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.ModImage;
import com.gameboard.biz.post.ModImageDao;
import com.gameboard.biz.post.ModImageService;

@Service("ModImageService")
public class ModImageServiceImpl implements ModImageService {

	@Autowired
	private ModImageDao modImageDao;

	@Override
	public void insertPostImage(ModImage modImage) {
		modImageDao.insertPostImage(modImage);
	}

	@Override
	public List<ModImage> getImagesByMID(int mID) {
		return modImageDao.getImagesByMID(mID);
	}

}