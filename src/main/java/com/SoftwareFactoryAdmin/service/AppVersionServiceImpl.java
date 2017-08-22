package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.AppVersionDao;
import com.SoftwareFactoryAdmin.dao.NoticeDao;
import com.SoftwareFactoryAdmin.model.AppVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService {

    private AppVersionDao appVersionDao;

    @Autowired(required = true)
    public void setAppVersionDao(AppVersionDao appVersionDao) {
        this.appVersionDao = appVersionDao;
    }


    @Override
    @Transactional
    public void addNewAppVersion(AppVersion appVersion) {
        appVersionDao.create(appVersion);
    }

    @Override
    @Transactional
    public void updateAppVersion(AppVersion appVersion) {
        appVersionDao.update(appVersion);
    }

    @Override
    @Transactional
    public void deleteAppVersion(AppVersion appVersion) {
        appVersionDao.delete(appVersion);
    }

    @Override
    @Transactional
    public AppVersion getAppVersionById(Long id) {
        return appVersionDao.read(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppVersion> getAllAppVersion() {
        return appVersionDao.findAll();
    }
}
