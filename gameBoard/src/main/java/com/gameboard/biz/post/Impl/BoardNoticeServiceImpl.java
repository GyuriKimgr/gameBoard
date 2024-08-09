package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameboard.biz.post.BoardNotice;
import com.gameboard.biz.post.BoardNoticeDao;
import com.gameboard.biz.post.BoardNoticeService;

@Service("BoardNoticeService")
public class BoardNoticeServiceImpl implements BoardNoticeService {
	@Autowired
	private BoardNoticeDao noticeDao;

	@Override
	public List<BoardNotice> getNotices(String boardType) {
		return noticeDao.getNotices(boardType);
	}
	@Override
    public BoardNotice getNoticeById(String noticeID) {
        // DAO를 통해 공지사항을 조회
        return noticeDao.getNoticeById(noticeID);
    }
}