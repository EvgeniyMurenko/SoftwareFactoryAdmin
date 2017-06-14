package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.TaskMessage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskMessageDao")
public class TaskMessageDaoImpl implements TaskMessageDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(TaskMessage taskMessage) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(taskMessage);
        return id;
    }

    @Override
    public TaskMessage read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        TaskMessage taskMessage = (TaskMessage) session.get(TaskMessage.class, id);
        return taskMessage;
    }

    @Override
    public void update(TaskMessage taskMessage) {
        Session session = sessionFactory.getCurrentSession();
        session.update(taskMessage);
    }

    @Override
    public void delete(TaskMessage taskMessage) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(taskMessage);
    }

    @Override
    public List<TaskMessage> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from TaskMessage");
        return query.list();
    }
}
