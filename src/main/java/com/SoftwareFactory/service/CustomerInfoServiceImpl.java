package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.CustomerInfoDaoImpl;
import com.SoftwareFactory.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("customerInfoService")
public class CustomerInfoServiceImpl {
    private CustomerInfoDaoImpl customerInfoDao;

    @Autowired(required=true)
    public void setCustomerInfoDao(CustomerInfoDaoImpl customerInfoDao) {
        if (customerInfoDao == null) {
            System.out.print("customer info");
        }
        this.customerInfoDao = customerInfoDao;
    }


    @Transactional
    public void addNewCustomerInfo(CustomerInfo customerInfo) {
        customerInfoDao.create(customerInfo);
    }


    @Transactional(readOnly=true)
    public List<CustomerInfo> getAllCustomersInfo() {
        return customerInfoDao.findAll();
    }


    @Transactional
    public void updateCustomerInfo(CustomerInfo customerInfo) {
        customerInfoDao.update(customerInfo);
    }


    @Transactional
    public void deleteCustomerInfo(CustomerInfo customerInfo) {
        customerInfoDao.delete(customerInfo);
    }

}


