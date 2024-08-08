package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.WtpostComment;
import com.gameboard.biz.post.WtpostCommentDao;

@Repository
public class WtpostCommentDaoImpl implements WtpostCommentDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    private static final String NAMESPACE = "WtpostCommentDao";

    @Override
    public void insertWtComment(WtpostComment comment) {

		System.out.println("WtCommentDaoImpl");
		System.out.println(NAMESPACE + ".insertWtComment" + comment);
		
    	mybatis.insert(NAMESPACE + ".insertWtComment", comment);
    }

    @Override
    public List<WtpostComment> selectWtCommentsByPostId(int wtID) {
        return mybatis.selectList(NAMESPACE + ".selectWtCommentsByPostId", wtID);
    }

    @Override
    public void deleteWtComment(int commentID) {
        mybatis.delete(NAMESPACE + ".deleteWtComment", commentID);
    }
    
    @Override
    public WtpostComment selectWtCommentById(int commentID) {
        System.out.println("select comment by ID");
        return mybatis.selectOne(NAMESPACE + ".selectWtCommentById", commentID);
    }
}