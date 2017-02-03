package com.SoftwareFactory.service;

import com.SoftwareFactory.model.Project;

import java.util.List;

/**
 * Created by adm on 1/30/2017.  f
 */
public interface ProjectService {
    void addNewProject(Project project);
    void updateProject(Project project);
    void deleteProject(Project project);
    List<Project> getAllProjects();
    Project getProjectById(Long id);
}
