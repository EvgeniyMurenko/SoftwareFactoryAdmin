package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.ProjectDaoImpl;
import com.SoftwareFactory.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adm on 1/27/2017.
 */
@Service("projectService")
public class ProjectServiceImpl implements AbstractService<Project> {

    private ProjectDaoImpl projectDao;

    @Autowired(required=true)
    public ProjectServiceImpl(ProjectDaoImpl projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    @Transactional
    public void addNew(Project object) {
        projectDao.create(object);
    }

    @Override
    @Transactional
    public void update(Project object) {
        projectDao.update(object);
    }

    @Override
    @Transactional
    public void delete(Project object) {
        projectDao.delete(object);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Project> getAll() {
        return projectDao.findAll();
    }
}
