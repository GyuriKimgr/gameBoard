package com.gameboard.biz.post.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.Wtpost;
import com.gameboard.biz.post.WtpostDao;

@Repository
public class WtpostDaoImpl implements WtpostDao{
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insertWtpost(Wtpost vo) {
		mybatis.insert("WtpostDao.insertWtpost", vo);
	}
}