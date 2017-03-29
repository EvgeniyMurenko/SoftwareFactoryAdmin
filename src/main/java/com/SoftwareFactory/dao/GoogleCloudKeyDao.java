package com.SoftwareFactory.dao;

import com.SoftwareFactory.model.GoogleCloudKey;

import java.util.List;


public interface GoogleCloudKeyDao {
    Long create(GoogleCloudKey googleCloudKey);
    GoogleCloudKey read(Long id);
    void update(GoogleCloudKey googleCloudKey);
    void delete(GoogleCloudKey googleCloudKey);
    List<GoogleCloudKey> findAll();
}
