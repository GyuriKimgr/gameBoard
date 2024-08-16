package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.object.MappingCommAreaOperation;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.ModComment;
import com.gameboard.biz.post.ModCommentDao;
import com.gameboard.biz.post.ModCommentService;

@Service
public class ModCommentServiceImpl implements ModCommentService {

	@Autowired
	private ModCommentDao mcommentDao;
	@Override
	public void addModComment(ModComment comment) {
		mcommentDao.insertModComment(comment);
	}

	@Override
	public List<ModComment> getModCommentsByPostId(int mID) {
		return mcommentDao.selectModCommentByPostId(mID);
	}

	@Override
	public void deleteModComment(int mCommentID) {
		mcommentDao.deleteModComment(mCommentID);
	}

	@Override
	public void deleteModAllComment(int mID) {
		mcommentDao.deleteModAllComment(mID);
	}

	@Override
	public ModComment getModCommentById(int mCommentID) {
		return mcommentDao.selectModCommentById(mCommentID);
	}

	@Override
	public int countModCommentsByPostId(int mID) {
		return mcommentDao.countModCommentByPostId(mID);
	}

}
