package com.SoftwareFactory.service;


import com.SoftwareFactory.model.MessageTask;
import com.SoftwareFactory.model.StaffInfo;

import java.util.List;

public interface MessageTaskService {

    void addMessageTask(MessageTask messageTask);
    void updateMessageTask(MessageTask messageTask);
    void deleteMessageTask(MessageTask messageTask);
    List<MessageTask> getAllMessageTask();
    List<MessageTask> getAllMessageTaskByStaff(Long staffInfo);
    MessageTask getMessageTask(Long id);
}
