package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.SgpostComment;
import com.gameboard.biz.post.SgpostCommentDao;

@Repository
public class SgpostCommentDaoImpl implements SgpostCommentDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	private static final String NAMESPACE = "SgpostCommentDao";
	
	@Override
	public void insertSgComment(SgpostComment sgComment) {
		mybatis.insert(NAMESPACE+".insertSgComment", sgComment);
	}

	@Override
	public List<SgpostComment> selectSgCommentsByPostId(int sgID) {
		return mybatis.selectList(NAMESPACE + ".selectSgCommentsByPostId", sgID);
	}

	@Override
	public void deleteSgComment(int sgCommentID) {
		mybatis.delete(NAMESPACE+".deleteSgComment", sgCommentID);
	}

	@Override
	public void deleteSgAllComment(int sgID) {
		mybatis.delete(NAMESPACE+".deleteSgAllComment", sgID);
	}

	@Override
	public SgpostComment selectSgCommentById(int sgCommentID) {
		return mybatis.selectOne(NAMESPACE+".selectSgCommentById", sgCommentID);
	}

	@Override
	public int countSgCommentsByPostId(int sgID) {
		return mybatis.selectOne(NAMESPACE+".countSgCommentsByPostId", sgID);
	}

}
