package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.Message;

import java.util.List;


public interface MessageDao {

    Long create(Message message);

    Message read(Long id);

    void update(Message message);

    void delete(Message message);

    List<Message> findAll();

}
