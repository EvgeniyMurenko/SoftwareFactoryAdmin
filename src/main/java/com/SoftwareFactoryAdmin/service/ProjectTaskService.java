package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.ProjectTask;

import java.util.List;

public interface ProjectTaskService {

    void addNewProjectTask(ProjectTask projectTask);

    void updateProjectTask(ProjectTask projectTask);

    void deleteProjectTask(ProjectTask projectTask);

    List<ProjectTask> getAllProjectTasks();

    ProjectTask getProjectTaskById(Long id);

}
