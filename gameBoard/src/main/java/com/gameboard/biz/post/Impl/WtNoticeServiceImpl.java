package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.WtNotice;
import com.gameboard.biz.post.WtNoticeDao;
import com.gameboard.biz.post.WtNoticeService;

@Service("WtNoticeService")
public class WtNoticeServiceImpl implements WtNoticeService {
	@Autowired
	private WtNoticeDao noticeDao;

	@Override
	public List<WtNotice> getNotices(String boardType) {
		return noticeDao.getNotices(boardType);
	}
	@Override
    public WtNotice getNoticeByTitle(String noticeTitle) {
        return noticeDao.getNoticeByTitle(noticeTitle);
    }
	
	@Override
	public void updateNoticeViews(String noticeTitle) {
		noticeDao.updateNoticeViews(noticeTitle);

	}
}