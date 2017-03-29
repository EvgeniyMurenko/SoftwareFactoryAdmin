package com.SoftwareFactory.service;


import com.SoftwareFactory.model.MessageTask;

import java.util.List;

public interface MessageTaskService {

    void addMessageTask(MessageTask messageTask);
    void updateMessageTask(MessageTask messageTask);
    void deleteMessageTask(MessageTask messageTask);
    List<MessageTask> getAllMessageTask();
    MessageTask getMessageTask(Long id);
}
