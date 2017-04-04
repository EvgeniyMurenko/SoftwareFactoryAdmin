package com.SoftwareFactory.service;


import com.SoftwareFactory.model.Case;
import com.SoftwareFactory.model.Notice;

import java.util.List;

public interface NoticeService {
    void addNewNotice(Notice notice);
    void updateNotice(Notice notice);
    void deleteNotice(Notice notice);
    Notice getNoticeById(Long id);
    List<Notice> getAllNotices();
}
