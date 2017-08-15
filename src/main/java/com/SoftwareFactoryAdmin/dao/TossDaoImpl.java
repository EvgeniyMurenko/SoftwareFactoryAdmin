package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.Toss;
import com.SoftwareFactoryAdmin.model.TossTask;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tossDao")
public class TossDaoImpl implements TossDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(Toss toss) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(toss);
        return id;
    }



    @Override
    public Toss read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct toss " +
                                            "from Toss toss " +
                                            "left join fetch toss.managerInfoEngaged mie " +
                                            "left join fetch toss.tossTasks tt " +
                                            "left join fetch tt.managerInfoOpened " +
                                            "left join fetch tt.tossTaskMessages tm " +
                                            "left join fetch tt.tossTaskLinks " +
                                            "left join fetch tm.managerInfo " +
                                            "where toss.id =:id ")
                                            .setParameter("id" , id);
        return (Toss) query.uniqueResult();
    }

    @Override
    public void update(Toss toss) {
        Session session = sessionFactory.getCurrentSession();
        session.update(toss);
    }

    @Override
    public void delete(Toss toss) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(toss);
    }

    @Override
    public List<Toss> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Toss");
        return query.list();
    }

    @Override
    public List<Toss> findTossBelongToManager(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct toss " +
                                            "from Toss toss " +
                                            "left join fetch toss.tossTasks tt " +
                                            "left join fetch toss.managerInfoEngaged mie " +
                                            "where tt.managerInfoOpened.id =:id " +
                                            "or mie.id =:id ")
                                            .setParameter("id" , id);
        return query.list();
    }

    @Override
    public List<Toss> findTossBelongToManagerByStatus(Long id, String status) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct toss " +
                                            "from Toss toss " +
                                            "left join fetch toss.tossTasks tt " +
                                            "join toss.managerInfoEngaged mie " +
                                            "where toss.status like :tossStatus " +
                                            "and tt.managerInfoOpened.id =:id " +
                                            "or mie.id =:id " )
                                            .setParameter("id" , id)
                                            .setParameter("tossStatus" , "%"+status+"%");
        return query.list();
    }


}

