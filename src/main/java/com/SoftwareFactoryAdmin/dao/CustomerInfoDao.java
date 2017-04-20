package com.SoftwareFactoryAdmin.dao;

import com.SoftwareFactoryAdmin.model.CustomerInfo;

import java.util.List;


public interface CustomerInfoDao {
    Long create(CustomerInfo customerInfo);
    CustomerInfo read(Long id);
    void update(CustomerInfo customerInfo);
    void delete(CustomerInfo customerInfo);
    List<CustomerInfo> findAll();

}
