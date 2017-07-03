package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.ProjectDao;
import com.SoftwareFactoryAdmin.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;

    @Autowired(required=true)
    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public void addNewProject(Project project) {
        projectDao.create(project);
    }

    @Override
    public void updateProject(Project project) {
        projectDao.update(project);
    }

    @Override
    public void deleteProject(Project project) {
        projectDao.delete(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectDao.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectDao.read(id);
    }

    @Override
    public List<Project> findAllWhereUserIsNotDelete() {return projectDao.findAllWhereUserIsNotDelete();}
}
