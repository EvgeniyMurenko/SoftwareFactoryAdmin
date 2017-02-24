package com.SoftwareFactory.service;


import com.SoftwareFactory.model.ManagerInfo;

import java.util.List;

public interface ManagerInfoService {

    void addNewManagerInfo(ManagerInfo managerInfo);

    void updateManagerInfo(ManagerInfo managerInfo);

    void deleteManagerInfo(ManagerInfo managerInfo);

    List<ManagerInfo> getAllManagerInfos();

    ManagerInfo getManagerInfoById(Long id);
}
