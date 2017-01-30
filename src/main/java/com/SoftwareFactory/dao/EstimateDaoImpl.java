package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.Estimate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("estimateDao")
public class EstimateDaoImpl implements EstimateDao {

    static final Logger logger = LoggerFactory.getLogger(EstimateDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;

    }


    @Override
    public Long create(Estimate estimate) {
        Session session = sessionFactory.getCurrentSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(estimate);
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
    public Estimate read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Estimate estimate = null;
        try {
            estimate = (Estimate) session.get(Estimate.class, id);
            logger.error("Case read successfully, Case=" + estimate);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
        } finally {
            session.close();
        }
        return estimate;
    }

    @Override
    public void update(Estimate estimate) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(estimate);
            session.getTransaction().commit();
            logger.error("Case update successfully, Case=" + estimate);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(Estimate estimate) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(estimate);
            session.getTransaction().commit();
            logger.info("Case deleted successfully, Case details=" + estimate);
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            logger.error("Transaction failed");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Estimate> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = null;
        List<Estimate> listP = null;
        try {
            query = session.createQuery("from Estimate");
            listP = query.list();
            logger.info("Case find successfully, Case details=" + listP);
        } finally {
            session.close();
        }
        return listP;
    }
}
