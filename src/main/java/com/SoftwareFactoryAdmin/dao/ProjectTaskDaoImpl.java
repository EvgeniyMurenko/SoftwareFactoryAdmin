package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.ProjectTask;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("projectTaskDao")
public class ProjectTaskDaoImpl implements ProjectTaskDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(ProjectTask projectTask) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(projectTask);
        return id;
    }

    @Override
    public ProjectTask read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        ProjectTask projectTask = (ProjectTask) session.get(ProjectTask.class, id);
        return projectTask;
    }

    @Override
    public void update(ProjectTask projectTask) {
        Session session = sessionFactory.getCurrentSession();
        session.update(projectTask);
    }

    @Override
    public void delete(ProjectTask projectTask) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(projectTask);
    }

    @Override
    public List<ProjectTask> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ProjectTask");
        return query.list();
    }
}
