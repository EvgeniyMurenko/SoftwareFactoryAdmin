package com.SoftwareFactoryAdmin.dao;


import com.SoftwareFactoryAdmin.model.CustomerHistory;

import java.util.List;

public interface CustomerHistoryDao {

    Long create(CustomerHistory customerHistory);

    CustomerHistory read(Long id);

    void update(CustomerHistory customerHistory);

    void delete(CustomerHistory customerHistory);

    List<CustomerHistory> findAll();

}
