package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.Message;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("messageDao")
public class MessageDaoImpl implements MessageDao {

    private static final Logger logger = LoggerFactory.getLogger(MessageDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    @Override
    public Long create(Message message) {
        Session session = sessionFactory.getCurrentSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(message);
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
    public Message read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Message message = null;
        try {
            message = (Message) session.get(Message.class, id);
            logger.error("Case read successfully, Case=" + message);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
        } finally {
            session.close();
        }
        return message;
    }

    @Override
    public void update(Message message) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(message);
            session.getTransaction().commit();
            logger.error("Case update successfully, Case=" + message);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(Message message) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(message);
            session.getTransaction().commit();
            logger.info("Case deleted successfully, Case details=" + message);
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            logger.error("Transaction failed");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Message> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = null;
        List<Message> listP = null;
        try {
            query = session.createQuery("from Message");
            listP = query.list();
            logger.info("Case find successfully, Case details=" + listP);
        } finally {
            session.close();
        }
        return listP;
    }
}
