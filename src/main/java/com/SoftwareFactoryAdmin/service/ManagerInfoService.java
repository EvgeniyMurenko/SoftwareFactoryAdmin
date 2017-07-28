package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.ManagerInfo;

import java.util.List;
import java.util.Set;

public interface ManagerInfoService {

    void addNewManagerInfo(ManagerInfo managerInfo);

    void updateManagerInfo(ManagerInfo managerInfo);

    void deleteManagerInfo(ManagerInfo managerInfo);

    List<ManagerInfo> getAllManagerInfos();

    ManagerInfo getManagerInfoById(Long id);

    List<ManagerInfo> getAllWithPermission();

    Set<ManagerInfo> findMultiplyManagerInfoById(List<String> ids);

    List<ManagerInfo> getAllManagerInfosExceptOneManager(Long id);
}
