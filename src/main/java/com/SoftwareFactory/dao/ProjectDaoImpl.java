package com.SoftwareFactory.dao;


import com.SoftwareFactory.model.Project;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("projectDao")
public class ProjectDaoImpl implements ProjectDao {

    private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @Override
    public Long create(Project project) {
        Session session = sessionFactory.getCurrentSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(project);
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
    public Project read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Project project = null;
        try {
            project = (Project) session.get(Project.class, id);
            logger.error("Case read successfully, Case=" + project);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
        } finally {
            session.close();
        }
        return project;
    }

    @Override
    public void update(Project project) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(project);
            session.getTransaction().commit();
            logger.error("Case update successfully, Case=" + project);
        } catch (HibernateException e) {
            logger.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(Project project) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(project);
            session.getTransaction().commit();
            logger.info("Case deleted successfully, Case details=" + project);
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            logger.error("Transaction failed");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Project> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = null;
        List<Project> listP = null;
        try {
            query = session.createQuery("from Project");
            listP = query.list();
            logger.info("Case find successfully, Case details=" + listP);
        } finally {
            session.close();
        }
        return listP;
    }
}
