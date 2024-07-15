package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.Fpost;
import com.gameboard.biz.post.FpostDao;
import com.gameboard.biz.post.FpostService;
import com.gameboard.biz.post.Mod;

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

	@Override
	public List<Fpost> searchFpost(Fpost vo) {
		String searchCondition = vo.getSearchCondition();
		String searchKeyword = vo.getSearchKeyword();
		return fpostDao.searchFpost(vo);
	}

	@Override
	public Fpost getFpostById(int fID) {
		return fpostDao.getFpostById(fID);
	}

	@Override
	public void deleteFpost(int fID) {
		fpostDao.deleteFpost(fID);
	}

	@Override
	public void updateFpost(Fpost vo) {
		fpostDao.updateFpost(vo);
	}
	
	@Override
	public Fpost getNextFpost(int fID) {
		return fpostDao.getNextFpost(fID);
	}

	@Override
	public Fpost getPrevFpost(int fID) {
		return fpostDao.getPrevFpost(fID);
	}

	@Override
	public void updateFpostViews(int fID) {
		fpostDao.updateFpostViews(fID);

	}
}
