package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.MoNotice;
import com.gameboard.biz.post.MoNoticeDao;
import com.gameboard.biz.post.MoNoticeService;

@Service("MoNoticeService")
public class MoNoticeServiceImpl implements MoNoticeService {
	@Autowired
	private MoNoticeDao noticeDao;

	@Override
	public List<MoNotice> getNotices(String boardType) {
		return noticeDao.getNotices(boardType);
	}
	@Override
    public MoNotice getNoticeByTitle(String noticeTitle) {
        return noticeDao.getNoticeByTitle(noticeTitle);
    }
	
	@Override
	public void updateNoticeViews(String noticeTitle) {
		noticeDao.updateNoticeViews(noticeTitle);

	}
}