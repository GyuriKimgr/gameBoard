package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.Wtpost;
import com.gameboard.biz.post.WtpostDao;
import com.gameboard.biz.post.WtpostService;

@Service("WtpostService")
public class WtpostServiceImpl implements WtpostService{
	@Autowired
	private WtpostDao WtpostDao;
	@Override
	public void insertWtpost(Wtpost vo) {
		WtpostDao.insertWtpost(vo);
	}
	@Override
	public int getWtID() {
		// TODO Auto-generated method stub
		return WtpostDao.getWtID();
	}
	@Override
	public List<Wtpost> getWtpostList(Wtpost vo) {
		// TODO Auto-generated method stub
		return WtpostDao.getWtpostList(vo);
	}
	
}
