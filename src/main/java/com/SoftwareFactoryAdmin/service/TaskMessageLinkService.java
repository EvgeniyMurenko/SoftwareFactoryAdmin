package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.TaskMessageLink;

import java.util.List;


public interface TaskMessageLinkService {

    void addNewTaskMessageLink(TaskMessageLink taskMessageLink);

    void updateTaskMessageLink(TaskMessageLink taskMessageLink);

    void deleteTaskMessageLink(TaskMessageLink taskMessageLink);

    List<TaskMessageLink> getAllTaskMessageLinks();

    TaskMessageLink getTaskMessageLinkById(Long id);

}
