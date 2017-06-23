package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.GoogleCloudKey;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("googleCloudKeyDao")
public class GoogleCloudKeyDaoImpl implements GoogleCloudKeyDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(GoogleCloudKey googleCloudKey) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(googleCloudKey);
        return id;
    }

    @Override
    public GoogleCloudKey read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        GoogleCloudKey googleCloudKey = (GoogleCloudKey) session.get(GoogleCloudKey.class, id);
        return googleCloudKey;
    }

    @Override
    public void update(GoogleCloudKey googleCloudKey) {
        Session session = sessionFactory.getCurrentSession();
        session.update(googleCloudKey);
    }

    @Override
    public void delete(GoogleCloudKey googleCloudKey) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(googleCloudKey);
    }

    @Override
    public List<GoogleCloudKey> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from GoogleCloudKey");
        return query.list();
    }

    @Override
    public List<String> getAllStringKeys() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct googleCloudKeys.key from GoogleCloudKey googleCloudKeys");
        return query.list();
    }

    @Override
    public List<String> findAllKeysByUser(Long userID) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct googleCloudKeys.key from GoogleCloudKey googleCloudKeys where googleCloudKeys.user.id = :userID");
        query.setParameter("userID", userID);
        return query.list();
    }


    @Override
    public List<String> findAllKeysByUserType(String userType) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct googleCloudKeys.key from GoogleCloudKey googleCloudKeys inner join googleCloudKeys.user.userProfiles up where up.type like :type");
        query.setParameter("type", userType);
        return query.list();
    }

}
