package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.Mod;
import com.gameboard.biz.post.ModDao;
import com.gameboard.biz.post.ModService;
import com.gameboard.biz.post.Sgpost;

@Service("ModService")
public class ModServiceImpl implements ModService {
	@Autowired
	private ModDao modDao;

	@Override
	public void insertMod(Mod vo) {
		String date = modDao.getMDate();
		Integer mID = modDao.getMID();
		vo.setmDate(date);
		vo.setmID(mID);
		modDao.insertMod(vo);
	}

	@Override
	public int getMID() {
		return modDao.getMID();
	}

	@Override
	public String getMDate() {
		return modDao.getMDate();
	}

	@Override
	public List<Mod> getModList(Mod vo) {
		return modDao.getModList(vo);
	}

	@Override
	public List<Mod> searchMod(Mod vo) {
		String searchCondition = vo.getSearchCondition();
		String searchKeyword = vo.getSearchKeyword();
		return modDao.searchMod(vo);
	}

	@Override
	public Mod getModById(int mID) {
		return modDao.getModById(mID);
	}

	@Override
	public void deleteMod(int mID) {
		modDao.deleteMod(mID);
	}

	@Override
	public void updateMod(Mod vo) {
		modDao.updateMod(vo);
	}

	@Override
	public Mod getNextMod(int mID) {
		return modDao.getNextMod(mID);
	}

	@Override
	public Mod getPrevMod(int mID) {
		return modDao.getPrevMod(mID);
	}

	@Override
	public void updateModViews(int mID) {
		modDao.updateModViews(mID);

	}
	@Override
	public List<Mod> getRecentMdPosts(int limit){
		return modDao.getRecentMdposts(limit);
	}

}
