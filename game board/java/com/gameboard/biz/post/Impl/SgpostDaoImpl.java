package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.Sgpost;
import com.gameboard.biz.post.SgpostDao;

@Repository
public class SgpostDaoImpl implements SgpostDao{
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insertSgpost(Sgpost vo) {
		String sgDate = vo.getSgDate();
		Integer sgID = vo.getSgID();
		System.out.println("sgID°ª : " + sgID);
		mybatis.insert("SgpostDao.insertSgpost", vo);
	}

	@Override
	public int getSgID() {
		Integer s = mybatis.selectOne("SgpostDao.getSgID");
		System.out.println("stID°ª : " + s);
		return mybatis.selectOne("SgpostDao.getSgID");
	}

	@Override
	public String getSgDate() {
		String ss = mybatis.selectOne("SgpostDao.getSgDate");
		System.out.println("sgDate : " + ss);
		return mybatis.selectOne("SgpostDao.getSgDate");
	}

	@Override
	public List<Sgpost> getSgpostList(Sgpost vo) {
		return mybatis.selectList("SgpostDao.getSgpostList", vo);
	}

	@Override
	public List<Sgpost> searchSgpost(Sgpost vo) {
		return mybatis.selectList("SgpostDao.searchSgpost", vo);
	}

	@Override
	public Sgpost getSgpostById(int sgID) {
		return mybatis.selectOne("SgpostDao.getSgpost", sgID);
	}

	@Override
	public void deleteSgpost(int sgID) {
		mybatis.delete("SgpostDao.deleteSgpost", sgID);
	}

	@Override
	public void updateSgpost(Sgpost vo) {
		mybatis.delete("SgpostDao.updateSgpost", vo);
	}
	
}
