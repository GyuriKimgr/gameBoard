package com.gameboard.biz.post;

import java.util.List;

public interface FNoticeService {
    public List<FNotice> getNotices(String boardType);
    public FNotice getNoticeByTitle(String noticeTitle);
    public void updateNoticeViews(String noticeTitle);
    
    
}