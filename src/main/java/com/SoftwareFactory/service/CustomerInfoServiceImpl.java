package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.CustomerInfoDao;

import com.SoftwareFactory.model.Case;
import com.SoftwareFactory.model.CustomerInfo;
import com.SoftwareFactory.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Set;


@Service("customerInfoService")
public class CustomerInfoServiceImpl implements CustomerInfoService {

    private CustomerInfoDao customerInfoDao;

    @Autowired(required = true)
    public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
        this.customerInfoDao = customerInfoDao;
    }


    @Override
    @Transactional
    public void addNewCustomerInfo(CustomerInfo customerInfo) {
        customerInfoDao.create(customerInfo);
    }

    @Override
    @Transactional
    public void updateCustomerInfo(CustomerInfo customerInfo) {
        customerInfoDao.update(customerInfo);
    }

    @Override
    @Transactional
    public void deleteCustomerInfo(CustomerInfo customerInfo) {
        customerInfoDao.delete(customerInfo);
    }

    @Override
    @Transactional
    public List<CustomerInfo> getAllCustomerInfos() {
        return customerInfoDao.findAll();
    }

    @Override
    @Transactional
    public Set<Project> getCustomerProjects(Long id) {
        CustomerInfo customerInfo = customerInfoDao.read(id);
        Set<Project> projects = null;
        try {
            projects = customerInfo.getProjects();
        } catch (Exception e){
            e.printStackTrace();
        }
        return projects;
    }

}

