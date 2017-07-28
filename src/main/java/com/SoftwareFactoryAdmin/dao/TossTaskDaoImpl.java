package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.TossTask;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tossTaskDao")
public class TossTaskDaoImpl implements TossTaskDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(TossTask tossTask) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(tossTask);
        return id;
    }

    @Override
    public TossTask read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        TossTask tossTask = (TossTask) session.get(TossTask.class, id);
        return tossTask;
    }

    @Override
    public void update(TossTask tossTask) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tossTask);
    }

    @Override
    public void delete(TossTask tossTask) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(tossTask);
    }

    @Override
    public List<TossTask> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from TossTask");
        return query.list();
    }

    @Override
    public List<TossTask> findTossTasksBelongToManager(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct tossTask " +
                                            "from TossTask tossTask " +
                                            "join tossTask.managerInfoEngaged mie " +
                                            "where tossTask.managerInfoOpened.id =:id " +
                                            "or mie.id =:id ")
                                            .setParameter("id" , id);
        return query.list();
    }


}

