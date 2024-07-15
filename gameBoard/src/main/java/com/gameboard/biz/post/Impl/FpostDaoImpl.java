package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.Fpost;
import com.gameboard.biz.post.FpostDao;
import com.gameboard.biz.post.Wtpost;

@Repository
public class FpostDaoImpl implements FpostDao {
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insertFpost(Fpost vo) {
		String fDate = vo.getfDate();
		Integer fID = vo.getfID();
		System.out.println("FfID°ª : " + fID);
		mybatis.insert("FpostDao.insertFpost", vo);
	}

	@Override
	public int getFID() {
		Integer f = mybatis.selectOne("FpostDao.getFID");
		System.out.println("fID°ª : " + f);
		return mybatis.selectOne("FpostDao.getFID");
	}

	@Override
	public String getFDate() {
		String ff = mybatis.selectOne("FpostDao.getFDate");
		System.out.println("fDate : " + ff);
		return mybatis.selectOne("FpostDao.getFDate");
	}

	@Override
	public List<Fpost> getFpostList(Fpost vo) {
		return mybatis.selectList("FpostDao.getFpostList", vo);
	}

	@Override
	public List<Fpost> searchFpost(Fpost vo) {
		return mybatis.selectList("FpostDao.searchFpost", vo);
	}

	@Override
	public Fpost getFpostById(int fID) {
		return mybatis.selectOne("FpostDao.getFpost", fID);
	}

	@Override
	public void deleteFpost(int fID) {
		mybatis.delete("FpostDao.deleteFpost", fID);
	}

	@Override
	public void updateFpost(Fpost vo) {
		mybatis.delete("FpostDao.updateFpost", vo);
	}
	@Override
	public Fpost getNextFpost(int fID) {
		return mybatis.selectOne("FpostDao.getNextFpost", fID);
	}

	@Override
	public Fpost getPrevFpost(int fID) {
		return mybatis.selectOne("FpostDao.getPrevFpost", fID);
	}

	@Override
	public void updateFpostViews(int fID) {
		mybatis.update("FpostDao.updateFpostViews", fID);
	}
}
