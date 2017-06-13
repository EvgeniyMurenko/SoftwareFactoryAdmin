package com.SoftwareFactoryAdmin.dao;


import com.SoftwareFactoryAdmin.model.ProjectTask;

import java.util.List;


public interface ProjectTaskDao {

    Long create(ProjectTask projectTask);

    ProjectTask read(Long id);

    void update(ProjectTask projectTask);

    void delete(ProjectTask projectTask);

    List<ProjectTask> findAll();

}
