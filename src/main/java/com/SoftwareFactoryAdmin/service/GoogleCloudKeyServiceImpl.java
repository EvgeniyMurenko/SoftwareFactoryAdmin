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
    public List<String> getAllStringKeys(){
        return googleCloudKeyDao.getAllStringKeys();
    }

    @Override
    public List<String> findAllKeysByStaff(Long staffInfo){
        return googleCloudKeyDao.findAllKeysByStaff(staffInfo);
    }

    @Override
    public List<String> findAllManagersKeys() {
        return googleCloudKeyDao.findAllManagersKeys();
    }

}
