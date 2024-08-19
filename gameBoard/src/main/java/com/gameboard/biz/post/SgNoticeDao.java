package com.gameboard.biz.post;

import java.util.List;

public interface SgNoticeDao {
    public List<SgNotice> getNotices(String boardType);
    public SgNotice getNoticeByTitle(String noticeTitle);
    public void updateNoticeViews(String noticeTitle);
}