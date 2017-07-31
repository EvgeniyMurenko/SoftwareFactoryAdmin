package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.ManagerInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.OneToMany;
import java.util.List;


@Repository("managerInfoDao")
public class ManagerInfoDaoImpl implements ManagerInfoDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @Override
    public Long create(ManagerInfo managerInfo) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(managerInfo);
        return id;
    }

    @Override
    public ManagerInfo read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        ManagerInfo managerInfo = (ManagerInfo) session.get(ManagerInfo.class, id);
        return managerInfo;
    }

    @Override
    public void update(ManagerInfo managerInfo) {
        Session session = sessionFactory.getCurrentSession();
        session.update(managerInfo);
    }

    @Override
    public void delete(ManagerInfo managerInfo) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(managerInfo);
    }

    @Override
    public List<ManagerInfo> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ManagerInfo");
        return query.list();
    }

    @Override
    public List<ManagerInfo> findAllWithPermissions(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct managerInfo from ManagerInfo managerInfo " +
                "left join fetch managerInfo.user " +
                "left join fetch managerInfo.managerInfoPermissions");
        return query.list();
    }

    @Override
    public List<ManagerInfo> findMultiManagerInfoById(List<Long> ids){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ManagerInfo mi where mi.id in (:ids)").setParameterList("ids", ids);
        return query.list();
    }

    @Override
    public List<ManagerInfo> getAllManagerInfosExceptOneManager(Long id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ManagerInfo mi where mi.id != :id").setParameter("id", id);
        return query.list();
    }

}

