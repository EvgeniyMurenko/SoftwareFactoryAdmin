
package com.SoftwareFactory.service;


import com.SoftwareFactory.model.Case;
import com.SoftwareFactory.model.CustomerInfo;
import com.SoftwareFactory.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service("customerInfoService")
public interface CustomerInfoService {

    void addNewCustomerInfo(CustomerInfo customerInfo);
    void updateCustomerInfo(CustomerInfo customerInfo);
    void deleteCustomerInfo(CustomerInfo customerInfo);
    List<CustomerInfo> getAllCustomerInfos();
    CustomerInfo getCustomerInfoById(Long id);


}
