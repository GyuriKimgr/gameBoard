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
	private WtpostDao wtpostDao;
	
	@Override
	public void insertWtpost(Wtpost vo) {
		String date = wtpostDao.getWtDate();
		Integer wtID = wtpostDao.getWtID();
		vo.setWtDate(date);
		vo.setWtID(wtID);
		wtpostDao.insertWtpost(vo);
	}
	
	@Override
	public int getWtID() {
		return wtpostDao.getWtID();
	}
	@Override
	public String getWtDate() {
		return wtpostDao.getWtDate();
	}
	@Override
	public List<Wtpost> getWtpostList(Wtpost vo) {
		return wtpostDao.getWtpostList(vo);
	}

	@Override
	public List<Wtpost> searchWtpost(Wtpost vo) {
		String searchCondition = vo.getSearchCondition();
		String searchKeyword = vo.getSearchKeyword();
		return wtpostDao.searchWtpost(vo);
	}
}
