package com.gameboard.biz.post;

import java.util.List;

public interface BoardNoticeService {
    public List<BoardNotice> getNotices(String boardType);
    public BoardNotice getNoticeById(String noticeID);
    
}