package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.CustomerInfoDaoImpl;
import com.SoftwareFactory.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adm on 1/27/2017.
 */
@Service("customerInfoService")
public class CustomerInfoService implements AbstractService <CustomerInfo> {

    private CustomerInfoDaoImpl customerInfoDao;

    @Autowired(required=true)
    public CustomerInfoService(CustomerInfoDaoImpl customerInfoDao) {
        this.customerInfoDao = customerInfoDao;
    }

    @Override
    @Transactional
    public void addNew(CustomerInfo object) {
        customerInfoDao.create(object);
    }

    @Override
    @Transactional
    public void update(CustomerInfo object) {
        customerInfoDao.update(object);
    }

    @Override
    @Transactional
    public void delete(CustomerInfo object) {
        customerInfoDao.delete(object);
    }

    @Override
    @Transactional(readOnly=true)
    public List<CustomerInfo> getAll() {
        return customerInfoDao.findAll();
    }
}
