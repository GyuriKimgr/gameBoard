package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.Fpost;
import com.gameboard.biz.post.FpostDao;
import com.gameboard.biz.post.FpostService;

@Service("FpostService")
public class FpostServiceImpl implements FpostService {
	@Autowired
	private FpostDao fpostDao;
	
	@Override
	public void insertFpost(Fpost vo) {
		String date = fpostDao.getFDate();
		Integer sgID = fpostDao.getFID();
		vo.setfDate(date);
		vo.setfID(sgID);
		fpostDao.insertFpost(vo);
	}

	@Override
	public int getFID() {
		return fpostDao.getFID();
	}

	@Override
	public String getFDate() {
		return fpostDao.getFDate(); 
	}

	@Override
	public List<Fpost> getFpostList(Fpost vo) {
		return fpostDao.getFpostList(vo);
	}
}
