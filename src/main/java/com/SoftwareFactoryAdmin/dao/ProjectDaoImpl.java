package com.SoftwareFactoryAdmin.dao;


import com.SoftwareFactoryAdmin.model.Project;
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

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @Override
    public Long create(Project project) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(project);
        return id;
    }

    @Override
    public Project read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct project from Project project " +
                "left join fetch project.projectTasks " +
                "left join fetch project.customerInfo " +
                "where project.id = :id");
        query.setParameter("id", id);
        return (Project) query.uniqueResult();
    }

    @Override
    public void update(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.update(project);
    }

    @Override
    public void delete(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(project);
    }

    @Override
    public List<Project> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Project");
        return query.list();
    }

    @Override
    public List<Project> findAllWhereUserIsNotDelete(){
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("select distinct project from Project project " +
                                            "left join fetch  project.managerInfo mi " +
                                            "left join fetch mi.managerInfoPermissions " +
                                            "left join fetch project.customerInfo ci " +
                                            "left join fetch ci.user u " +
                                            "where project.customerInfo.user.isDelete =:state").setBoolean("state", Boolean.FALSE);
        return query.list();

    }
}
