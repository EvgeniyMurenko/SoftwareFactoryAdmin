package com.SoftwareFactoryAdmin.dao;


import com.SoftwareFactoryAdmin.model.CustomerHistory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerHistoryDao")
public class CustomerHistoryDaoImpl implements CustomerHistoryDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(CustomerHistory customerHistory) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(customerHistory);
        return id;
    }

    @Override
    public CustomerHistory read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        CustomerHistory customerHistory = (CustomerHistory) session.get(CustomerHistory.class, id);
        return customerHistory;
    }

    @Override
    public void update(CustomerHistory customerHistory) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customerHistory);
    }

    @Override
    public void delete(CustomerHistory customerHistory) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customerHistory);
    }

    @Override
    public List<CustomerHistory> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerHistory");
        return query.list();
    }


}
