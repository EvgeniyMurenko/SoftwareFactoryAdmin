package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.model.Project;

import java.util.List;


public interface ProjectService {

    void addNewProject(Project project);

    void updateProject(Project project);

    void deleteProject(Project project);

    List<Project> getAllProjects();

    Project getProjectById(Long id);

    List<Project> findAllWhereUserIsNotDelete();

}
