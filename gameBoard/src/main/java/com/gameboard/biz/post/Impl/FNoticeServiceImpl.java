package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.FNotice;
import com.gameboard.biz.post.FNoticeDao;
import com.gameboard.biz.post.FNoticeService;

@Service("FNoticeService")
public class FNoticeServiceImpl implements FNoticeService {
	@Autowired
	private FNoticeDao noticeDao;

	@Override
	public List<FNotice> getNotices(String boardType) {
		return noticeDao.getNotices(boardType);
	}
	@Override
    public FNotice getNoticeByTitle(String noticeTitle) {
        return noticeDao.getNoticeByTitle(noticeTitle);
    }
	
	@Override
	public void updateNoticeViews(String noticeTitle) {
		noticeDao.updateNoticeViews(noticeTitle);

	}
}