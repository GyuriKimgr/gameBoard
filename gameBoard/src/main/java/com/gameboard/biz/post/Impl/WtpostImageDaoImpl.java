package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.WtpostImage;
import com.gameboard.biz.post.WtpostImageDao;

@Repository
public class WtpostImageDaoImpl implements WtpostImageDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insertPostImage(WtpostImage wtpostImage) {
		mybatis.insert("WtpostDao.insertWtPostImage", wtpostImage);
	}

	@Override
	public List<WtpostImage> getImagesByWtID(int wtID) {
		return mybatis.selectList("WtpostDao.getImagesByWtID", wtID);
	}

}
