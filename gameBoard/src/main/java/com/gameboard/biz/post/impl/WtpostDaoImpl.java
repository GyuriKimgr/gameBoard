package com.gameboard.biz.post.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.WtpostDao;

@Repository
public class WtpostDaoImpl implements WtpostDao{
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insertWtpost(wtID vo) {
		mybatis.insert("WtpostDao.insertWtpost", vo);
	}
}