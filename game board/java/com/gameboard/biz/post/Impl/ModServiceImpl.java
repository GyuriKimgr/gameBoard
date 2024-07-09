package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.Mod;
import com.gameboard.biz.post.ModDao;
import com.gameboard.biz.post.ModService;

@Service("ModService")
public class ModServiceImpl implements ModService{
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

}
