package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.FileMessage;

import java.util.List;

/**
 * Created by adm on 2/16/2017.
 */
public interface FileMessageDao {
    Long create(FileMessage fileMessage);
    FileMessage read(Long id);
    void update(FileMessage fileMessage);
    void delete(FileMessage fileMessage);
    List<FileMessage> findAll();
}
