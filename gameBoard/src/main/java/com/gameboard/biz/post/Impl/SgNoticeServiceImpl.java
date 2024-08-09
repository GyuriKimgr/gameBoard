package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.SgNotice;
import com.gameboard.biz.post.SgNoticeDao;
import com.gameboard.biz.post.SgNoticeService;

@Service("SgNoticeService")
public class SgNoticeServiceImpl implements SgNoticeService {
	@Autowired
	private SgNoticeDao noticeDao;

	@Override
	public List<SgNotice> getNotices(String boardType) {
		return noticeDao.getNotices(boardType);
	}
	@Override
    public SgNotice getNoticeByTitle(String noticeTitle) {
        return noticeDao.getNoticeByTitle(noticeTitle);
    }
	
	@Override
	public void updateNoticeViews(String noticeTitle) {
		noticeDao.updateNoticeViews(noticeTitle);

	}
}