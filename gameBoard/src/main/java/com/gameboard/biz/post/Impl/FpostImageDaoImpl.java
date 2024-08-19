package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.FpostImage;
import com.gameboard.biz.post.FpostImageDao;

@Repository
public class FpostImageDaoImpl implements FpostImageDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insertPostImage(FpostImage fpostImage) {
		mybatis.insert("FpostDao.insertFPostImage", fpostImage);
	}

	@Override
	public List<FpostImage> getImagesByFID(int fID) {
		return mybatis.selectList("FpostDao.getImagesByFID", fID);
	}

}