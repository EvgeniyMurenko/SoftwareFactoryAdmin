package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.AppVersion;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("appVersionDao")
public class AppVersionDaoImpl implements AppVersionDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(AppVersion appVersion) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(appVersion);
        return id;
    }

    @Override
    public AppVersion read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        AppVersion notice = (AppVersion) session.get(AppVersion.class, id);
        return notice;
    }

    @Override
    public void update(AppVersion appVersion) {
        Session session = sessionFactory.getCurrentSession();
        session.update(appVersion);
    }

    @Override
    public void delete(AppVersion appVersion) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(appVersion);
    }

    @Override
    public List<AppVersion> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(" from AppVersion");
        return query.list();
    }
}
