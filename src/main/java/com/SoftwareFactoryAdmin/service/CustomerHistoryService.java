package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.CustomerHistory;

import java.util.List;

public interface CustomerHistoryService {

    void addNewCustomerHistory(CustomerHistory customerHistory);

    void updateCustomerHistory(CustomerHistory customerHistory);

    void deleteCustomerHistory(CustomerHistory customerHistory);

    List<CustomerHistory> getAllCustomerHistorys();

    CustomerHistory getCustomerHistoryById(Long id);

}
