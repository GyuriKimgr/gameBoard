package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.ModImage;
import com.gameboard.biz.post.ModImageDao;

@Repository
public class ModImageDaoImpl implements ModImageDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insertPostImage(ModImage modImage) {
		mybatis.insert("ModDao.insertModImage", modImage);
	}

	@Override
	public List<ModImage> getImagesByMID(int mID) {
		return mybatis.selectList("ModDao.getImagesByMID", mID);
	}

	@Override
	public void deleteModAllImage(int mID) {
		mybatis.delete("ModDao.deleteModAllImage", mID);
	}

}
