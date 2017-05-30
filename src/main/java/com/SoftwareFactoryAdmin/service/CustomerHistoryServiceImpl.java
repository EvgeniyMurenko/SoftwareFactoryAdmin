package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.CustomerHistoryDao;
import com.SoftwareFactoryAdmin.model.CustomerHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("customerHistoryService")
public class CustomerHistoryServiceImpl implements CustomerHistoryService {

    private CustomerHistoryDao customerHistoryDao;

    @Autowired(required = true)
    public void setCustomerHistoryDao(CustomerHistoryDao customerHistoryDao) {
        this.customerHistoryDao = customerHistoryDao;
    }

    @Override
    public void addNewCustomerHistory(CustomerHistory customerHistory) {
        customerHistoryDao.create(customerHistory);
    }

    @Override
    public void updateCustomerHistory(CustomerHistory customerHistory) {
        customerHistoryDao.update(customerHistory);
    }

    @Override
    public void deleteCustomerHistory(CustomerHistory customerHistory) {
        customerHistoryDao.delete(customerHistory);
    }

    @Override
    public List<CustomerHistory> getAllCustomerHistorys() {
        return customerHistoryDao.findAll();
    }

    @Override
    public CustomerHistory getCustomerHistoryById(Long id) {
        return customerHistoryDao.read(id);
    }


}
