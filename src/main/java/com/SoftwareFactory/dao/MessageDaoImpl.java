package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.Message;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("messageDao")
public class MessageDaoImpl implements AbstractDomainDao {

    private static final Logger logger = LoggerFactory.getLogger(MessageDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    @Override
    public Long create(Object domain) {
        Message message = (Message) domain;
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(message);
        logger.error("Message saved successfully, Message="+message);
        return id;
    }


    @Override
    public Message read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Message message = (Message) session.get(Message.class, id);
        logger.error("Message read successfully, Message="+message);
        return message;
    }

    @Override
    public void update(Object domain) {
        Message message = (Message) domain;
        Session session = sessionFactory.getCurrentSession();
        session.update(message);
        logger.error("Message update successfully, Message="+message);
    }

    @Override
    public void delete(Object domain) {
        Message message = (Message) domain;
        Session session = sessionFactory.getCurrentSession();
        session.delete(message);
        logger.info("Message deleted successfully, Message details="+message);
    }

    @Override
    public List<Message> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from s_messages");
        return query.list();
    }
}
