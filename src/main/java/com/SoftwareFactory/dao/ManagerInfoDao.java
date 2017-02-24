package com.SoftwareFactory.dao;


import com.SoftwareFactory.model.ManagerInfo;

import java.util.List;

public interface ManagerInfoDao {

    Long create(ManagerInfo managerInfo);

    ManagerInfo read(Long id);

    void update(ManagerInfo managerInfo);

    void delete(ManagerInfo managerInfo);

    List<ManagerInfo> findAll();
}
