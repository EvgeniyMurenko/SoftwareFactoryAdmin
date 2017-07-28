package com.SoftwareFactoryAdmin.dao;


import com.SoftwareFactoryAdmin.model.ManagerInfo;

import java.util.List;

public interface ManagerInfoDao {

    Long create(ManagerInfo managerInfo);

    ManagerInfo read(Long id);

    void update(ManagerInfo managerInfo);

    void delete(ManagerInfo managerInfo);

    List<ManagerInfo> findAll();

    List<ManagerInfo> findAllWithPermissions();

    List<ManagerInfo> findMultiManagerInfoById(List<Long> ids);

    List<ManagerInfo> getAllManagerInfosExceptOneManager(Long id);
}
