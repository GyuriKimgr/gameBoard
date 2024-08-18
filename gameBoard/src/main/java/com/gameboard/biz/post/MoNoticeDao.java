package com.gameboard.biz.post;

import java.util.List;

public interface MoNoticeDao {
    public List<MoNotice> getNotices(String boardType);
    public MoNotice getNoticeByTitle(String noticeTitle);
    public void updateNoticeViews(String noticeTitle);
}