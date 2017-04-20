package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.ManagerInfoPermission;

import java.util.List;

public interface ManagerInfoPermissionService {

    ManagerInfoPermission findById(int id);

    ManagerInfoPermission findByPermission(String permission);

    List<ManagerInfoPermission> findAll();

}
