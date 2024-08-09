package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.MoNotice;
import com.gameboard.biz.post.MoNoticeDao;

@Repository
public class MoNoticeDaoImpl implements MoNoticeDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<MoNotice> getNotices(String boardType) {
		return mybatis.selectList("MoNoticeDao.selectNotices", boardType);
	}

	@Override
	public MoNotice getNoticeByTitle(String noticeTitle) {
		return mybatis.selectOne("MoNoticeDao.selectNoticeByTitle", noticeTitle);
	}

	@Override
	public void updateNoticeViews(String noticeTitle) {
		mybatis.update("MoNoticeDao.updateNoticeViews", noticeTitle);
	}

}
