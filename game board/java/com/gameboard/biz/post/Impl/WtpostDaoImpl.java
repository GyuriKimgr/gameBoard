package com.gameboard.biz.post.Impl;

import java.util.List;

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
		String wtDate = vo.getWtDate();
		Integer wtID = vo.getWtID();
		System.out.println("wtID°ª:" + wtID);
		mybatis.insert("WtpostDao.insertWtpost", vo);
	}
	
	@Override
	public int getWtID() {
		Integer n = mybatis.selectOne("WtpostDao.getWtID");
		System.out.println("wtID°ª:" + n);
		return mybatis.selectOne("WtpostDao.getWtID");
	}
	
	@Override
	public String getWtDate() {
		String na = mybatis.selectOne("WtpostDao.getWtDate");
		System.out.println("wtDate:" + na);
		return mybatis.selectOne("WtpostDao.getWtDate");
	}
	
	@Override
	public List<Wtpost> getWtpostList(Wtpost vo){
		return mybatis.selectList("WtpostDao.getWtpostList", vo);
	}

	@Override
	public List<Wtpost> searchWtpost(Wtpost vo) {
		return mybatis.selectList("WtpostDao.searchWtpost", vo);
	}

	@Override
	public Wtpost getWtpostById(int wtID) {
		return mybatis.selectOne("WtpostDao.getWtpost", wtID);
	}

	@Override
	public void deleteWtpost(int wtID) {
		mybatis.delete("WtpostDao.deleteWtpost", wtID);
	}

	@Override
	public void updateWtpost(Wtpost vo) {
		 mybatis.delete("WtpostDao.updateWtpost", vo);
	}
}