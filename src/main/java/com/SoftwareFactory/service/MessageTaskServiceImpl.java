package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.MessageTaskDao;
import com.SoftwareFactory.model.MessageTask;
import com.SoftwareFactory.model.StaffInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("messageTaskService")
public class MessageTaskServiceImpl implements MessageTaskService {

    private MessageTaskDao messageTaskDao;

    @Autowired(required = true)
    public void setMessageTaskDao(MessageTaskDao messageTaskDao) {
        this.messageTaskDao = messageTaskDao;
    }

    @Override
    @Transactional
    public void addMessageTask(MessageTask messageTask) {
        messageTaskDao.create(messageTask);
    }

    @Override
    @Transactional
    public void updateMessageTask(MessageTask messageTask) {
        messageTaskDao.update(messageTask);
    }

    @Override
    @Transactional
    public void deleteMessageTask(MessageTask messageTask) {
        messageTaskDao.delete(messageTask);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MessageTask> getAllMessageTask() {
        return messageTaskDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MessageTask> getAllMessageTaskByStaff(Long staffInfo) {
        return messageTaskDao.findAllMessageTaskByStaff(staffInfo);
    }

    @Override
    @Transactional
    public MessageTask getMessageTask(Long id) {
        return messageTaskDao.read(id);
    }
}
