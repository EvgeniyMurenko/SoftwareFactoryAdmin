package com.SoftwareFactory.dao;


import com.SoftwareFactory.model.Project;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("projectDao")
public class ProjectDaoImpl implements AbstractDomainDao {

    private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    @Override
    public Long create(Object domain) {
        Project project = (Project) domain;
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(project);
        logger.error("Project saved successfully, Project="+project);
        return id;
    }

    @Override
    public Project read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Project project = (Project) session.get(Project.class, id);
        logger.error("Project read successfully, Project="+project);
        return project;
    }

    @Override
    public void update(Object domain) {
        Project project = (Project) domain;
        Session session = sessionFactory.getCurrentSession();
        session.update(project);
        logger.error("Project update successfully, Project="+project);
    }

    @Override
    public void delete(Object domain) {
        Project project = (Project) domain;
        Session session = sessionFactory.getCurrentSession();
        session.delete(project);
        logger.info("Project deleted successfully, Project details="+project);
    }

    @Override
    public List<Project> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Project");
        return query.list();
    }

}
