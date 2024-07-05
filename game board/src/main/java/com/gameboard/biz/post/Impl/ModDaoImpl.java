package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.Mod;
import com.gameboard.biz.post.ModDao;

@Repository
public class ModDaoImpl implements ModDao {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insertMod(Mod vo) {
		String mDate = vo.getmDate();
		Integer mID = vo.getmID();
		System.out.println("mID°ª : " + mID);
		mybatis.insert("ModDao.insertMod", vo);
	}

	@Override
	public int getMID() {
		Integer o = mybatis.selectOne("ModDao.getMID");
		System.out.println("MID°ª:" + o);
		return mybatis.selectOne("ModDao.getMID");
	}

	@Override
	public String getMDate() {
		String oo = mybatis.selectOne("ModDao.getMDate");
		System.out.println("MDate:" + oo);
		return mybatis.selectOne("ModDao.getMDate");
	}

	@Override
	public List<Mod> getModList(Mod vo) {
		return mybatis.selectList("ModDao.getModList", vo);
	}
}