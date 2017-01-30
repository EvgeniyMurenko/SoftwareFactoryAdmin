package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.CustomerInfo;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("customerInfoDao")
public class CustomerInfoDaoImpl implements CustomerInfoDao {

    private static final Logger logger = LoggerFactory.getLogger(CustomerInfoDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    @Override
    public Long create(CustomerInfo customerInfo) {
        Session session = sessionFactory.getCurrentSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(customerInfo);
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
    public CustomerInfo read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        CustomerInfo customerInfo = null;
        try {
            customerInfo = (CustomerInfo) session.get(CustomerInfo.class, id);
            logger.error("Case read successfully, Case=" + customerInfo);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
        } finally {
            session.close();
        }
        return customerInfo;
    }

    @Override
    public void update(CustomerInfo customerInfo) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(customerInfo);
            session.getTransaction().commit();
            logger.error("Case update successfully, Case=" + customerInfo);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(CustomerInfo customerInfo) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(customerInfo);
            session.getTransaction().commit();
            logger.info("Case deleted successfully, Case details=" + customerInfo);
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            logger.error("Transaction failed");
        } finally {
            session.close();
        }
    }

    @Override
    public List<CustomerInfo> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = null;
        List<CustomerInfo> listP = null;
        try {
            query = session.createQuery("from CustomerInfo");
            listP = query.list();
            logger.info("Case find successfully, Case details=" + listP);
        } finally {
            session.close();
        }
        return listP;
    }
}
