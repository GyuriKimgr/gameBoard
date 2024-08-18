package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.FNotice;
import com.gameboard.biz.post.FNoticeDao;

@Repository
public class FNoticeDaoImpl implements FNoticeDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	
	@Override
	public List<FNotice> getNotices(String boardType) {
		return mybatis.selectList("FNoticeDao.selectNotices", boardType);
	}

	@Override
    public FNotice getNoticeByTitle(String noticeTitle) {
        return mybatis.selectOne("FNoticeDao.selectNoticeByTitle", noticeTitle);
    }
	
	@Override
	public void updateNoticeViews(String noticeTitle) {
		mybatis.update("FNoticeDao.updateNoticeViews", noticeTitle);
	}
	
}
