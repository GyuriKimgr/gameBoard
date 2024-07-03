package com.gameboard.biz.post.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gameboard.biz.post.Wtpost;
import com.gameboard.biz.post.WtpostDao;
import com.gameboard.biz.post.WtpostService;

public class WtpostServiceImpl implements WtpostService{
	@Autowired
	private WtpostDao wtpostDao;
	
	@Override
	public void insertWtpost(Wtpost vo) {
		wtpostDao.insertWtpost(vo);
	}
	
}
