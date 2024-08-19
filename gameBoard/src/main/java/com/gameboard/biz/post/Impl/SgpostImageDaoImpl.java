package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.SgpostImage;
import com.gameboard.biz.post.SgpostImageDao;

@Repository
public class SgpostImageDaoImpl implements SgpostImageDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insertPostImage(SgpostImage sgpostImage) {
		mybatis.insert("SgpostDao.insertSgPostImage", sgpostImage);
	}

	@Override
	public List<SgpostImage> getImagesBySgID(int sgID) {
		return mybatis.selectList("SgpostDao.getImagesBySgID", sgID);
	}
}