package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.StaffHistory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("staffHistoryDao")
public class StaffHistoryDaoIml implements StaffHistoryDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(StaffHistory staffHistory) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(staffHistory);
        return id;
    }

    @Override
    public StaffHistory read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        StaffHistory staffHistory = (StaffHistory) session.get(StaffHistory.class, id);
        return staffHistory;
    }

    @Override
    public void update(StaffHistory staffHistory) {
        Session session = sessionFactory.getCurrentSession();
        session.update(staffHistory);
    }

    @Override
    public void delete(StaffHistory staffHistory) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(staffHistory);
    }

    @Override
    public List<StaffHistory> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from StaffHistory");
        return query.list();
    }
}