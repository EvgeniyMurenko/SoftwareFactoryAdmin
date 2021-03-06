package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.Case;
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

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(Case aCase) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(aCase);
        return id;
    }

    @Override
    public Case read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct aCase from Case aCase " +
                                            "left join fetch aCase.project pr " +
                                            "left join fetch pr.managerInfo mi " +
                                            "left join fetch mi.managerInfoPermissions " +
                                            "left join fetch mi.user " +
                                            "left join fetch pr.customerInfo ci " +
                                            "left join fetch ci.user " +
                                            "left join fetch aCase.messages message " +
                                            "left join fetch message.messageLinks " +
                                            "where aCase.id = :id");
        query.setParameter("id", id);
        return (Case) query.uniqueResult();
    }


    @Override
    public void update(Case aCase) {
        Session session = sessionFactory.getCurrentSession();
        session.update(aCase);
    }

    @Override
    public void delete(Case aCase) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(aCase);
    }

    @Override
    public List<Case> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(" from Case");
        return query.list();
    }

    @Override
    public List<Case> findByTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("From Case where projectTitle  like :projectTitle");
        query.setParameter("projectTitle", "%" + title + "%");
        return query.list();
    }

    @Override
    public List<Case> findByProjectName(String projectName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("From Case c where c.project.projectName like :projectName");
        query.setParameter("projectName", "%" + projectName + "%");
        return query.list();
    }

    @Override
    public List<Case> findCasesHundredLimit() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct aCase from Case aCase " +
                                            "order by aCase.creationDate desc ");
        query.setMaxResults(100);
        return query.list();
    }


    @Override
    public List<Case> findAllWhereUserIsNotDelete() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct aCase from Case aCase " +
                                            "left join fetch aCase.project p " +
                                            "left join fetch aCase.messages ms " +
                                            "left join fetch p.customerInfo ci " +
                                            "left  join  fetch  ci.user u " +
                                            "where u.isDelete =:state ").setBoolean("state", Boolean.FALSE);
        return query.list();

    }

    @Override
    public List<Case> findLimitThreeCase (){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct aCase from Case aCase " +
                                            "left join fetch aCase.messages " +
                                            "left join fetch aCase.project "+
                                            "order by date(aCase.creationDate) desc ");
        query.setMaxResults(3);
        return query.list();

    }

}
