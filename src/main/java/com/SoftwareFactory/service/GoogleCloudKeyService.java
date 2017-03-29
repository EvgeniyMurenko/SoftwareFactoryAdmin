package com.SoftwareFactory.service;

import com.SoftwareFactory.model.GoogleCloudKey;

import java.util.List;

public interface GoogleCloudKeyService {

    void addGoogleCloudKey(GoogleCloudKey googleCloudKey);
    void updateGoogleCloudKey(GoogleCloudKey googleCloudKey);
    void deleteGoogleCloudKey(GoogleCloudKey googleCloudKey);
    List<GoogleCloudKey> getAllGoogleCloudKey();
    GoogleCloudKey getGoogleCloudKeyById(Long id);
}
