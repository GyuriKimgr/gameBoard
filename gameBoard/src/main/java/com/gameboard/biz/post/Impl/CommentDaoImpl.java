package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.Comment;
import com.gameboard.biz.post.CommentDao;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    private static final String NAMESPACE = "CommentDao";

    @Override
    public void insertComment(Comment comment) {

		System.out.println("CommentDaoImpl");
		System.out.println(NAMESPACE + ".insertComment" + comment);
    	mybatis.insert(NAMESPACE + ".insertComment", comment);
    }

    @Override
    public List<Comment> selectCommentsByPostId(int wtID) {
    	System.out.println("insert comment2");
        return mybatis.selectList(NAMESPACE + ".selectCommentsByPostId", wtID);
    }
    
    @Override
    public void deleteComment(int commentID) {
        mybatis.delete(NAMESPACE + ".deleteComment", commentID);
    }
}