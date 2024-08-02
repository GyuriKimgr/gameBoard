package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.Mod;
import com.gameboard.biz.post.ModDao;
import com.gameboard.biz.post.Sgpost;
import com.gameboard.biz.post.Wtpost;

@Repository
public class ModDaoImpl implements ModDao {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insertMod(Mod vo) {
		String mDate = vo.getmDate();
		Integer mID = vo.getmID();
		mybatis.insert("ModDao.insertMod", vo);
	}

	@Override
	public int getMID() {
		Integer o = mybatis.selectOne("ModDao.getMID");
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

	@Override
	public List<Mod> searchMod(Mod vo) {
		return mybatis.selectList("ModDao.searchMod", vo);
	}

	@Override
	public Mod getModById(int mID) {
		return mybatis.selectOne("ModDao.getMod", mID);
	}

	@Override
	public void deleteMod(int mID) {
		mybatis.delete("ModDao.deleteMod", mID);
	}

	@Override
	public void updateMod(Mod vo) {
		mybatis.delete("ModDao.updateMod", vo);
	}
	@Override
	public Mod getNextMod(int mID) {
		return mybatis.selectOne("ModDao.getNextMod", mID);
	}

	@Override
	public Mod getPrevMod(int mID) {
		return mybatis.selectOne("ModDao.getPrevMod", mID);
	}

	@Override
	public void updateModViews(int mID) {
		mybatis.update("ModDao.updateModViews", mID);
	}
	@Override
	public List<Mod> getRecentMdposts(int limit){
		List<Mod> posts = mybatis.selectList("ModDao.getRecentMdposts", limit);
		 System.out.println("Recent posts fetched: " + posts);
		return mybatis.selectList("ModDao.getRecentMdposts", limit);
	}
}