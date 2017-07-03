package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.CustomerInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("customerInfoDao")
public class CustomerInfoDaoImpl implements CustomerInfoDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(CustomerInfo customerInfo) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(customerInfo);
        return id;
    }

    @Override
    public CustomerInfo read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        CustomerInfo customerInfo = (CustomerInfo) session.get(CustomerInfo.class, id);
        return customerInfo;
    }

    @Override
    public void update(CustomerInfo customerInfo) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customerInfo);
    }

    @Override
    public void delete(CustomerInfo customerInfo) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customerInfo);
    }

    @Override
    public List<CustomerInfo> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("from CustomerInfo");
        return query.list();
    }

    @Override
    public List<CustomerInfo> findAllWhereUserIsNotDelete(){
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("select distinct customerInfo from CustomerInfo customerInfo left join fetch customerInfo.user  u where u.isDelete =:state").setBoolean("state", Boolean.FALSE);
        return query.list();
    }
}
