package com.SoftwareFactoryAdmin.dao;


import com.SoftwareFactoryAdmin.model.TaskMessageLink;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskMessageLinkDao")
public class TaskMessageLinkDaoImpl implements TaskMessageLinkDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(TaskMessageLink taskMessageLink) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(taskMessageLink);
        return id;
    }


    @Override
    public TaskMessageLink read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        TaskMessageLink taskMessageLink = (TaskMessageLink) session.get(TaskMessageLink.class, id);
        return taskMessageLink;
    }

    @Override
    public void update(TaskMessageLink taskMessageLink) {
        Session session = sessionFactory.getCurrentSession();
        session.update(taskMessageLink);
    }

    @Override
    public void delete(TaskMessageLink taskMessageLink) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(taskMessageLink);
    }

    @Override
    public List<TaskMessageLink> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from TaskMessageLink");
        return query.list();
    }
}

