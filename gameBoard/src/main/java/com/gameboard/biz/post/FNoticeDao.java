package com.gameboard.biz.post;

import java.util.List;

public interface FNoticeDao {
    public List<FNotice> getNotices(String boardType);
    public FNotice getNoticeByTitle(String noticeTitle);
    public void updateNoticeViews(String noticeTitle);
}