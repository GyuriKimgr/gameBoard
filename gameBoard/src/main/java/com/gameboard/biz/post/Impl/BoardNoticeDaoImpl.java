package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.BoardNotice;
import com.gameboard.biz.post.BoardNoticeDao;

@Repository
public class BoardNoticeDaoImpl implements BoardNoticeDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	private static final String NAMESPACE = "BoardNoticeDao";

	@Override
	public List<BoardNotice> getNotices(String boardType) {
		return mybatis.selectList(NAMESPACE + ".selectNotices", boardType);
	}

	@Override
    public BoardNotice getNoticeById(String noticeID) {
        return mybatis.selectOne(NAMESPACE + ".selectNoticeById", noticeID);
    }
	
}
