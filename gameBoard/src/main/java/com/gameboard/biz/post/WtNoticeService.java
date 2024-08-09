package com.gameboard.biz.post;

import java.util.List;

public interface WtNoticeService {
    public List<WtNotice> getNotices(String boardType);
    public WtNotice getNoticeByTitle(String noticeTitle);
    public void updateNoticeViews(String noticeTitle);
    
    
}