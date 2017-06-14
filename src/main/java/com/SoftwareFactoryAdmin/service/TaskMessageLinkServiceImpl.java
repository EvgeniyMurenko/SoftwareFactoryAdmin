package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.TaskMessageLinkDao;
import com.SoftwareFactoryAdmin.model.TaskMessageLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("taskMessageLinkService")
public class TaskMessageLinkServiceImpl implements TaskMessageLinkService {

    private TaskMessageLinkDao taskMessageLinkDao;

    @Autowired(required = true)
    public void setStaffInfoDao(TaskMessageLinkDao taskMessageLinkDao) {
        this.taskMessageLinkDao = taskMessageLinkDao;
    }

    @Override
    public void addNewTaskMessageLink(TaskMessageLink taskMessageLink) {
        taskMessageLinkDao.create(taskMessageLink);
    }

    @Override
    public void updateTaskMessageLink(TaskMessageLink taskMessageLink) {
        taskMessageLinkDao.update(taskMessageLink);
    }

    @Override
    public void deleteTaskMessageLink(TaskMessageLink taskMessageLink) {
        taskMessageLinkDao.delete(taskMessageLink);
    }

    @Override
    public List<TaskMessageLink> getAllTaskMessageLinks() {
        return taskMessageLinkDao.findAll();
    }

    @Override
    public TaskMessageLink getTaskMessageLinkById(Long id) {
        return taskMessageLinkDao.read(id);
    }

}
