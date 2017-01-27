package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.Case;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("caseDao")
public class CaseDaoImpl implements AbstractDomainDao {

    private static final Logger logger = LoggerFactory.getLogger(CaseDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    @Override
    public Long create(Object domain) {
        Case aCase = (Case) domain;
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(aCase);
        logger.error("Case saved successfully, Case="+aCase);
        return id;
    }

    @Override
    public Case read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Case aCase = (Case) session.get(Case.class, id);
        logger.error("Case read successfully, Case="+aCase);
        return aCase;
    }

    @Override
    public void update(Object domain) {
        Case aCase = (Case) domain;
        Session session = sessionFactory.getCurrentSession();
        session.update(aCase);
        logger.error("Case update successfully, Case="+aCase);
    }

    @Override
    public void delete(Object domain) {
        Case aCase = (Case) domain;
        Session session = sessionFactory.getCurrentSession();
        session.delete(aCase);
        logger.info("Case deleted successfully, Case details="+aCase);
    }

    @Override
    public List<Case> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from s_cases");
        return query.list();
    }

}
