package com.gameboard.biz.post.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gameboard.biz.post.WtpostDao;
import com.gameboard.biz.post.WtpostService;

@Service("WtpostService")
public class WtpostServiceImpl implements WtpostService{
	@Autowired
	private WtpostDao WtpostDao;
	
	@Override
	public void insertWtpost(wtpost vo) {
		WtpostDao.insertWtpost(vo);
	}
	
}