package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.TaskMessage;

import java.util.List;


public interface TaskMessageDao {

    Long create(TaskMessage taskMessage);

    TaskMessage read(Long id);

    void update(TaskMessage taskMessage);

    void delete(TaskMessage taskMessage);

    List<TaskMessage> findAll();

}
