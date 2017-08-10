package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.FxmPost;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fxmPostDao")
public class FxmPostDaoImpl implements FxmPostDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(FxmPost fxmPost) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(fxmPost);
        return id;
    }

    @Override
    public FxmPost read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct fxmPost from FxmPost fxmPost " +
                "left join fetch fxmPost.user " +
                "left join fetch fxmPost.fxmComments where fxmPost.id = :id").setParameter("id", id);
        return (FxmPost) query.uniqueResult();
    }

    @Override
    public void update(FxmPost fxmPost) {
        Session session = sessionFactory.getCurrentSession();
        session.update(fxmPost);
    }

    @Override
    public void delete(FxmPost fxmPost) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(fxmPost);
    }

    @Override
    public List<FxmPost> findAll(String member, String leader, String staff) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct fxmPost from FxmPost fxmPost "+ "left join fetch fxmPost.user "+"left join fetch fxmPost.fxmComments "+" where fxmPost.groupType = :member or fxmPost.groupType = :leader or fxmPost.groupType = :staff")
                .setParameter("member", member).setParameter("leader", leader).setParameter("staff", staff);
        return query.list();
    }
}
