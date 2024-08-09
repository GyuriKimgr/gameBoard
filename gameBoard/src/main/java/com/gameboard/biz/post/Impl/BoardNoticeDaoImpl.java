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

	
	@Override
	public List<BoardNotice> getNotices(String boardType) {
		return mybatis.selectList("BoardNoticeDao.selectNotices", boardType);
	}

	@Override
    public BoardNotice getNoticeByTitle(String noticeTitle) {
        return mybatis.selectOne("BoardNoticeDao.selectNoticeByTitle", noticeTitle);
    }
	
}
