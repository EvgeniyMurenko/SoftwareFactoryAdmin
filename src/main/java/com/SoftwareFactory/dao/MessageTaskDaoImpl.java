package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.MessageTask;
import com.SoftwareFactory.model.StaffInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("messageTaskDao")
public class MessageTaskDaoImpl implements MessageTaskDao {

    private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Long create(MessageTask messageTask) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(messageTask);
        return id;
    }

    @Override
    public MessageTask read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        MessageTask messageTask = (MessageTask) session.get(MessageTask.class, id);
        return messageTask;
    }

    @Override
    public void update(MessageTask messageTask) {
        Session session = sessionFactory.getCurrentSession();
        session.update(messageTask);
        logger.error("MessageTask update successfully, messageTask=" + messageTask);
    }

    @Override
    public void delete(MessageTask messageTask) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(messageTask);
        logger.info("MessageTask deleted successfully, messageTask details=" + messageTask);
    }

    @Override
    public List<MessageTask> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from MessageTask");
        return query.list();
    }

    @Override
    public List<MessageTask> findAllMessageTaskByStaff(Long staffInfo) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("select distinct messageTask From MessageTask messageTask where messageTask.staffInfo.id = :staffInfo");
        query.setParameter("staffInfo", staffInfo);

        return query.list();
    }


}
