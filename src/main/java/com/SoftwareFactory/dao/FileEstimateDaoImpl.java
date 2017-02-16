package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.FileEstimate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by adm on 2/16/2017.
 */
public class FileEstimateDaoImpl implements FileEstimateDao {

    private static final Logger logger = LoggerFactory.getLogger(CaseDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Long create(FileEstimate fileEstimate) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(fileEstimate);
        return id;
    }

    @Override
    public FileEstimate read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        FileEstimate fileEstimate = (FileEstimate) session.get(FileEstimate.class, id);
        return fileEstimate;
    }

    @Override
    public void update(FileEstimate fileEstimate) {
        Session session = sessionFactory.getCurrentSession();
        session.update(fileEstimate);
        logger.error("Case update successfully, fileEstimate=" + fileEstimate);
    }

    @Override
    public void delete(FileEstimate fileEstimate) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(fileEstimate);
        logger.info("Case deleted successfully, fileEstimate details=" + fileEstimate);
    }

    @Override
    public List<FileEstimate> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from FileEstimate");
        return query.list();
    }
}
