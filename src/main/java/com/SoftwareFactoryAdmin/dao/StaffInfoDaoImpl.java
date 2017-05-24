package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.StaffInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("staffInfoDao")
public class StaffInfoDaoImpl implements StaffInfoDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(StaffInfo staffInfo) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(staffInfo);
        return id;
    }

    @Override
    public StaffInfo read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        StaffInfo staffInfo = (StaffInfo) session.get(StaffInfo.class, id);
        return staffInfo;
    }

    @Override
    public void update(StaffInfo staffInfo) {
        Session session = sessionFactory.getCurrentSession();
        session.update(staffInfo);
    }

    @Override
    public void delete(StaffInfo staffInfo) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(staffInfo);
    }

    @Override
    public List<StaffInfo> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from StaffInfo");
        return query.list();
    }
}