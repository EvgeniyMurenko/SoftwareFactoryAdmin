package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.GoogleCloudKeyDao;
import com.SoftwareFactoryAdmin.model.GoogleCloudKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("googleCloudKeyService")
public class GoogleCloudKeyServiceImpl implements GoogleCloudKeyService {

    private GoogleCloudKeyDao googleCloudKeyDao;

    @Autowired(required = true)
    public void setGoogleCloudKeyDao(GoogleCloudKeyDao googleCloudKeyDao) {
        this.googleCloudKeyDao = googleCloudKeyDao;
    }


    @Override
    public void addGoogleCloudKey(GoogleCloudKey googleCloudKey) {
        googleCloudKeyDao.create(googleCloudKey);
    }

    @Override
    public void updateGoogleCloudKey(GoogleCloudKey googleCloudKey) {
        googleCloudKeyDao.update(googleCloudKey);
    }

    @Override
    public void deleteGoogleCloudKey(GoogleCloudKey googleCloudKey) {
        googleCloudKeyDao.delete(googleCloudKey);
    }

    @Override
    public List<GoogleCloudKey> getAllGoogleCloudKey() {
        return googleCloudKeyDao.findAll();
    }

    @Override
    public GoogleCloudKey getGoogleCloudKeyById(Long id) {
        return googleCloudKeyDao.read(id);
    }

    @Override
    public List<String> getAllStringKeys() {
        return googleCloudKeyDao.getAllStringKeys();
    }

    @Override
    public List<String> findAllKeysByUser(Long userID) {
        return googleCloudKeyDao.findAllKeysByUser(userID);
    }


    @Override
    public List<String> findAllManagersKeys() {
        return googleCloudKeyDao.findAllKeysByUserType("MANAGER");
    }

    @Override
    public List<String> findAllStaffKeys() {
        return googleCloudKeyDao.findAllKeysByUserType("STAFF");
    }

    @Override
    public List<String> findAllKeysByUserIds(List<Long> ids) {
        return googleCloudKeyDao.findAllKeysByUserIds(ids);
    }

    @Override
    public List<String> findAllManagerWithOutOne(Long idManager) {
        return googleCloudKeyDao.findAllManagerWithOutOne(idManager);
    }

}
