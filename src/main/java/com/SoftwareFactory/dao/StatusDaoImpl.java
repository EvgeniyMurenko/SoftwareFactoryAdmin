package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.Status;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("statusDao")
public class StatusDaoImpl implements StatusDao {

    private static final Logger logger = LoggerFactory.getLogger(StatusDaoImpl.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    @Override
    public Long create(Status status) {
        Session session = sessionFactory.getCurrentSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(status);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return id;
    }


    @Override
    public Status read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Status status = null;
        try {
            status = (Status) session.get(Status.class, id);
            logger.error("Case read successfully, Case=" + status);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
        } finally {
            session.close();
        }
        return status;
    }

    @Override
    public void update(Status status) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(status);
            session.getTransaction().commit();
            logger.error("Case update successfully, Case=" + status);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(Status status) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(status);
            session.getTransaction().commit();
            logger.info("Case deleted successfully, Case details=" + status);
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            logger.error("Transaction failed");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Status> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = null;
        List<Status> listP = null;
        try {
            query = session.createQuery("from Status");
            listP = query.list();
            logger.info("Case find successfully, Case details=" + listP);
        } finally {
            session.close();
        }
        return listP;
    }
}
