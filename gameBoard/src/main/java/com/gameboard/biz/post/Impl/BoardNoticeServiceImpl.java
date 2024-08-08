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
	    	System.out.println("보오드타입 : " + boardType);
	        return noticeDao.getNotices(boardType);
	    }
	}