package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.SgNotice;
import com.gameboard.biz.post.SgNoticeDao;

@Repository
public class SgNoticeDaoImpl implements SgNoticeDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	
	@Override
	public List<SgNotice> getNotices(String boardType) {
		return mybatis.selectList("SgNoticeDao.selectNotices", boardType);
	}

	@Override
    public SgNotice getNoticeByTitle(String noticeTitle) {
        return mybatis.selectOne("SgNoticeDao.selectNoticeByTitle", noticeTitle);
    }
	
	@Override
	public void updateNoticeViews(String noticeTitle) {
		mybatis.update("SgNoticeDao.updateNoticeViews", noticeTitle);
	}
	
}
