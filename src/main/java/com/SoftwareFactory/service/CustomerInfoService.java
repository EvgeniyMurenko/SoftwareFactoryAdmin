
package com.SoftwareFactory.service;

import com.SoftwareFactory.dao.CustomerInfoDaoImpl;
import com.SoftwareFactory.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service("customerInfoService")
public interface CustomerInfoService {

    void addNewCase(CustomerInfo customerInfo);
    void updateCase(CustomerInfo customerInfo);
    void deleteCase(CustomerInfo customerInfo);
    List<CustomerInfo> getAllcustomerInfos();
}

