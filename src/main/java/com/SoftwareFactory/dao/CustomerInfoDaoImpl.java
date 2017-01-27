package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.CustomerInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("customerInfoDao")
public class CustomerInfoDaoImpl implements AbstractDomainDao {

    private static final Logger logger = LoggerFactory.getLogger(CustomerInfoDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    @Override
    public Long create(Object domain) {
        CustomerInfo customerInfo = (CustomerInfo) domain;
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(customerInfo);
        logger.error("CustomerInfo saved successfully, CustomerInfo="+customerInfo);
        return id;
    }

    @Override
    public CustomerInfo read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        CustomerInfo customerInfo = (CustomerInfo) session.get(CustomerInfo.class, id);
        logger.error("CustomerInfo read successfully, CustomerInfo="+customerInfo);
        return customerInfo;
    }

    @Override
    public void update(Object domain) {
        CustomerInfo customerInfo = (CustomerInfo) domain;
        Session session = sessionFactory.getCurrentSession();
        session.update(customerInfo);
        logger.error("CustomerInfo update successfully, CustomerInfo="+customerInfo);
    }

    @Override
    public void delete(Object domain) {
        CustomerInfo customerInfo = (CustomerInfo) domain;
        Session session = sessionFactory.getCurrentSession();
        session.delete(customerInfo);
        logger.info("CustomerInfo deleted successfully, CustomerInfo details="+customerInfo);
    }

    @Override
    public List<CustomerInfo> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerInfo");
        return query.list();
    }

}
