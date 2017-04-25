package com.SoftwareFactoryAdmin.dao;


import com.SoftwareFactoryAdmin.model.NoticeLink;

import java.util.List;

public interface NoticeLinkDao {

     Long create(NoticeLink noticeLink);

     NoticeLink read(Long id);

     void update(NoticeLink noticeLink);

     void delete(NoticeLink noticeLink);

     List<NoticeLink> findAll();

}
