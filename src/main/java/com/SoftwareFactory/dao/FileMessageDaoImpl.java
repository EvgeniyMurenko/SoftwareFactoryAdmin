package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.FileMessage;
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
public class FileMessageDaoImpl implements FileMessageDao {

    private static final Logger logger = LoggerFactory.getLogger(CaseDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @Override
    public Long create(FileMessage fileMessage) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(fileMessage);
        return id;
    }

    @Override
    public FileMessage read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        FileMessage fileMessage = (FileMessage) session.get(FileMessage.class, id);
        return fileMessage;
    }

    @Override
    public void update(FileMessage fileMessage) {
        Session session = sessionFactory.getCurrentSession();
        session.update(fileMessage);
        logger.error("Case update successfully, fileMessage=" + fileMessage);
    }

    @Override
    public void delete(FileMessage fileMessage) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(fileMessage);
        logger.info("Case deleted successfully, fileMessage details=" + fileMessage);
    }

    @Override
    public List<FileMessage> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from FileMessage");
        return query.list();
    }
}
