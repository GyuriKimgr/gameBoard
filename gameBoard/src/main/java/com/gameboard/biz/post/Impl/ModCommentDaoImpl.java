package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.ModComment;
import com.gameboard.biz.post.ModCommentDao;

@Repository
public class ModCommentDaoImpl implements ModCommentDao {
	
	@Autowired
    private SqlSessionTemplate mybatis;
	
	private static final String NAMESPACE = "ModpostCommentDao";

	@Override
	public void insertModComment(ModComment comment) {
		mybatis.insert(NAMESPACE+".insertModComment", comment);
	}

	@Override
	public List<ModComment> selectModCommentByPostId(int mID) {
		return mybatis.selectList(NAMESPACE+".selectModCommentsByPostId", mID);
	}

	@Override
	public void deleteModComment(int mCommentID) {
		mybatis.delete(NAMESPACE+".deleteModComment", mCommentID);
	}

	@Override
	public void deleteModAllComment(int mID) {
		mybatis.delete(NAMESPACE+".deleteModAllComment", mID);
	}

	@Override
	public ModComment selectModCommentById(int mCommentID) {
		return mybatis.selectOne(NAMESPACE +".selectModCommentById", mCommentID);
	}

	@Override
	public int countModCommentByPostId(int mID) {
		return mybatis.selectOne(NAMESPACE+".countModCommentsByPostId", mID);
	}

}
