package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.Sgpost;
import com.gameboard.biz.post.SgpostDao;
import com.gameboard.biz.post.SgpostService;

@Service("SgpostService")
public class SgpostServiceImpl implements SgpostService {
	@Autowired
	private SgpostDao sgpostDao;
	
	@Override
	public void insertSgpost(Sgpost vo) {
		String date = sgpostDao.getSgDate();
		Integer sgID = sgpostDao.getSgID();
		vo.setSgDate(date);
		vo.setSgID(sgID);
		sgpostDao.insertSgpost(vo);
	}

	@Override
	public int getSgID() {
		return sgpostDao.getSgID();
	}

	@Override
	public String getSgDate() {
		return sgpostDao.getSgDate(); 
	}

	@Override
	public List<Sgpost> getSgpostList(Sgpost vo) {
		return sgpostDao.getSgpostList(vo);
	}
}
