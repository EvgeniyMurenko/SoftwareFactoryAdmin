package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.FileMessageDao;
import com.SoftwareFactory.model.FileMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adm on 2/16/2017.
 */
public class FileMessageServiceImpl implements FileMessageService {

    private FileMessageDao fileMessageDao;

    @Autowired(required=true)
    public void setCaseDao(FileMessageDao fileMessageDao) {
        this.fileMessageDao = fileMessageDao;
    }

    @Override
    @Transactional
    public void addNewFileMessage(FileMessage fileMessage) {
        fileMessageDao.create(fileMessage);
    }

    @Override
    @Transactional
    public void updateFileMessage(FileMessage fileMessage) {
        fileMessageDao.update(fileMessage);
    }

    @Override
    @Transactional
    public void deleteFileMessage(FileMessage fileMessage) {
        fileMessageDao.delete(fileMessage);
    }

    @Override
    @Transactional(readOnly=true)
    public List<FileMessage> getAllFileMessage() {
        return fileMessageDao.findAll();
    }

    @Override
    @Transactional
    public FileMessage getFileMessageById(Long id) {
        return fileMessageDao.read(id);
    }
}
