package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.model.GoogleCloudKey;

import java.util.List;

public interface GoogleCloudKeyService {

    void addGoogleCloudKey(GoogleCloudKey googleCloudKey);

    void updateGoogleCloudKey(GoogleCloudKey googleCloudKey);

    void deleteGoogleCloudKey(GoogleCloudKey googleCloudKey);

    List<GoogleCloudKey> getAllGoogleCloudKey();

    GoogleCloudKey getGoogleCloudKeyById(Long id);

    List<String> getAllStringKeys();

    List<String> findAllKeysByUser(Long userID);

    List<String> findAllManagersKeys();

    List<String> findAllStaffKeys();

    List<String> findAllManagerWithOutOne(Long idManager);

}
