package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.model.AppVersion;
import java.util.List;


public interface AppVersionService {

    void addNewAppVersion(AppVersion appVersion);

    void updateAppVersion(AppVersion appVersion);

    void deleteAppVersion(AppVersion appVersion);

    AppVersion getAppVersionById(Long id);

    List<AppVersion> getAllAppVersion();
}
