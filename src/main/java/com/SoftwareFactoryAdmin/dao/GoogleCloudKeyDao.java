package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.GoogleCloudKey;

import java.util.List;


public interface GoogleCloudKeyDao {

    Long create(GoogleCloudKey googleCloudKey);

    GoogleCloudKey read(Long id);

    void update(GoogleCloudKey googleCloudKey);

    void delete(GoogleCloudKey googleCloudKey);

    List<GoogleCloudKey> findAll();

    List<String> getAllStringKeys();

    List<String> findAllKeysByUser(Long userID);

    List<String> findAllKeysByUserType(String userType);

    List<String> findAllKeysByUserIds(List<Long> ids);


    List<String> findAllManagerWithOutOne(Long userID);

}
