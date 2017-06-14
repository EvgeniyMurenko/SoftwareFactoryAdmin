package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.TaskMessageDao;
import com.SoftwareFactoryAdmin.model.TaskMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("taskMessageService")
public class TaskMessageServiceImpl implements  TaskMessageService {

    private TaskMessageDao taskMessageDao;

    @Autowired(required = true)
    public void seTaskMessageDao(TaskMessageDao taskMessageDao) {
        this.taskMessageDao = taskMessageDao;
    }

    @Override
    public void addNewTaskMessage(TaskMessage taskMessage) {
        taskMessageDao.create(taskMessage);
    }

    @Override
    public void updateTaskMessage(TaskMessage taskMessage) {
        taskMessageDao.update(taskMessage);
    }

    @Override
    public void deleteTaskMessage(TaskMessage taskMessage) {
        taskMessageDao.delete(taskMessage);
    }

    @Override
    public List<TaskMessage> getAllTaskMessages() {
        return taskMessageDao.findAll();
    }

    @Override
    public TaskMessage getTaskMessageById(Long id) {
        return taskMessageDao.read(id);
    }
}
