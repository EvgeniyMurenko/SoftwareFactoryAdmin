package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.Case;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("caseDao")
public class CaseDaoImpl implements CaseDao {

    private static final Logger logger = LoggerFactory.getLogger(CaseDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @Override
    public Long create(Case aCase) {
        Session session = sessionFactory.getCurrentSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(aCase);
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
    public Case read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Case aCase = null;
        try {
            aCase = (Case) session.get(Case.class, id);
            logger.error("Case read successfully, Case=" + aCase);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
        } finally {
            session.close();
        }
        return aCase;
    }

    @Override
    public void update(Case aCase) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(aCase);
            session.getTransaction().commit();
            logger.error("Case update successfully, Case=" + aCase);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(Case aCase) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(aCase);
            session.getTransaction().commit();
            logger.info("Case deleted successfully, Case details=" + aCase);
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            logger.error("Transaction failed");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Case> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = null;
        List<Case> listP = null;
        try {
            query = session.createQuery("from Case");
            listP = query.list();
            logger.info("Case find successfully, Case details=" + listP);
        } finally {
            session.close();
        }

        return listP;
    }

}
