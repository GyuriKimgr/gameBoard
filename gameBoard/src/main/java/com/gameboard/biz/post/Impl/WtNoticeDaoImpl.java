package com.gameboard.biz.post.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.WtNotice;
import com.gameboard.biz.post.WtNoticeDao;

@Repository
public class WtNoticeDaoImpl implements WtNoticeDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	
	@Override
	public List<WtNotice> getNotices(String boardType) {
		return mybatis.selectList("WtNoticeDao.selectNotices", boardType);
	}

	@Override
    public WtNotice getNoticeByTitle(String noticeTitle) {
        return mybatis.selectOne("WtNoticeDao.selectNoticeByTitle", noticeTitle);
    }
	
	@Override
	public void updateNoticeViews(String noticeTitle) {
		mybatis.update("WtNoticeDao.updateNoticeViews", noticeTitle);
	}
	
}
