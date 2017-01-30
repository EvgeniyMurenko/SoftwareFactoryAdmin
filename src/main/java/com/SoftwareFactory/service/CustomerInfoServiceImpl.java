package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.CustomerInfoDao;
import com.SoftwareFactory.dao.CustomerInfoDaoImpl;
import com.SoftwareFactory.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("customerInfoService")
public class CustomerInfoServiceImpl implements CustomerInfoService {

    private CustomerInfoDao customerInfoDao;

    @Autowired(required = true)
    public void setCaseDao(CustomerInfoDao customerInfoDao) {
        this.customerInfoDao = customerInfoDao;
    }


    @Override
    public void addNewCase(CustomerInfo customerInfo) {
        customerInfoDao.create(customerInfo);
    }

    @Override
    public void updateCase(CustomerInfo customerInfo) {
        customerInfoDao.update(customerInfo);
    }

    @Override
    public void deleteCase(CustomerInfo customerInfo) {
        customerInfoDao.delete(customerInfo);
    }

    @Override
    public List<CustomerInfo> getAllcustomerInfos() {
        return customerInfoDao.findAll();
    }
}


