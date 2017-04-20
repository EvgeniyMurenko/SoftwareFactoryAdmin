package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.ManagerInfoPermission;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("managerInfoPermissionDao")
public class ManagerInfoPermissionDaoImpl extends AbstractDao<Integer, ManagerInfoPermission> implements ManagerInfoPermissionDao {


    @SuppressWarnings("unchecked")
    public ManagerInfoPermission findById(int id) {
        return getByKey(id);
    }

    @Override
    public List<ManagerInfoPermission> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("type"));
        return (List<ManagerInfoPermission>) crit.list();
    }

    @Override
    public ManagerInfoPermission findByPermission(String permission) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("permission", permission));
        return (ManagerInfoPermission) crit.uniqueResult();
    }


}
