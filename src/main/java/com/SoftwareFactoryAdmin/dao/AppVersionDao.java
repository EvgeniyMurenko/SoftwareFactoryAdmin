package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.AppVersion;

import java.util.List;


public interface AppVersionDao {

    Long create(AppVersion appVersion);

    AppVersion read(Long id);

    void update(AppVersion appVersion);

    void delete(AppVersion appVersion);

    List<AppVersion> findAll();
}
