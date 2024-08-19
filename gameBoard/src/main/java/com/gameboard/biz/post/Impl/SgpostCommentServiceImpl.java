package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.SgpostComment;
import com.gameboard.biz.post.SgpostCommentDao;
import com.gameboard.biz.post.SgpostCommentService;

@Service
public class SgpostCommentServiceImpl implements SgpostCommentService {

	@Autowired
	private SgpostCommentDao sgCommentDao;
	
	@Override
	public void addSgComment(SgpostComment sgComment) {
		sgCommentDao.insertSgComment(sgComment);
	}

	@Override
	public List<SgpostComment> getSgCommentsByPostId(int sgID) {
		return sgCommentDao.selectSgCommentsByPostId(sgID);
	}

	@Override
	public void deleteSgComment(int sgCommentID) {
		sgCommentDao.deleteSgComment(sgCommentID);
	}

	@Override
	public void deleteSgAllComment(int sgID) {
		sgCommentDao.deleteSgAllComment(sgID);
	}

	@Override
	public SgpostComment getSgCommentById(int sgCommentID) {
		return sgCommentDao.selectSgCommentById(sgCommentID);
	}

	@Override
	public int countSgCommentsByPostId(int sgID) {
		return sgCommentDao.countSgCommentsByPostId(sgID);
	}

}
