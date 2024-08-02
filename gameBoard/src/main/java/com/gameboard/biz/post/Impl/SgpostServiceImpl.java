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

	@Override
	public List<Sgpost> searchSgpost(Sgpost vo) {
		String searchCondition = vo.getSearchCondition();
		String searchKeyword = vo.getSearchKeyword();
		return sgpostDao.searchSgpost(vo);
	}

	@Override
	public Sgpost getSgpostById(int sgID) {
		return sgpostDao.getSgpostById(sgID);
	}

	@Override
	public void deleteSgpost(int sgID) {
		sgpostDao.deleteSgpost(sgID);
	}

	@Override
	public void updateSgpost(Sgpost vo) {
		sgpostDao.updateSgpost(vo);
	}
	@Override
	public Sgpost getNextSgpost(int sgID) {
		return sgpostDao.getNextSgpost(sgID);
	}
	@Override
	public Sgpost getPrevSgpost(int sgID) {
		return sgpostDao.getPrevSgpost(sgID);
	}

	@Override
	public void updateSgpostViews(int sgID) {
		sgpostDao.updateSgpostViews(sgID);

	}
	@Override
	public List<Sgpost> getRecentSgPosts(int limit){
		return sgpostDao.getRecentSgposts(limit);
	}

}
