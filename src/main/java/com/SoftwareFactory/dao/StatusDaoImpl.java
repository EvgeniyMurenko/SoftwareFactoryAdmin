package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.Status;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("statusDao")
public class StatusDaoImpl implements AbstractDomainDao {

    private static final Logger logger = LoggerFactory.getLogger(StatusDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    @Override
    public Long create(Object domain) {
        Status status = (Status) domain;
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(status);
        logger.error("Status saved successfully, Status="+status);
        return id;
    }


    @Override
    public Status read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Status status = (Status) session.get(Status.class, id);
        logger.error("Status read successfully, Status="+status);
        return status;
    }

    @Override
    public void update(Object domain) {
        Status status = (Status) domain;
        Session session = sessionFactory.getCurrentSession();
        session.update(status);
        logger.error("Status update successfully, Status="+status);
    }

    @Override
    public void delete(Object domain) {
        Status status = (Status) domain;
        Session session = sessionFactory.getCurrentSession();
        session.delete(status);
        logger.info("Status deleted successfully, Status details="+status);
    }

    @Override
    public List<Status> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Status");
        return query.list();
    }
}
