
package com.SoftwareFactoryAdmin.service;


import com.SoftwareFactoryAdmin.model.CustomerInfo;
import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("customerInfoService")
public interface CustomerInfoService {

    void addNewCustomerInfo(CustomerInfo customerInfo);

    void updateCustomerInfo(CustomerInfo customerInfo);

    void deleteCustomerInfo(CustomerInfo customerInfo);

    List<CustomerInfo> getAllCustomerInfos();

    CustomerInfo getCustomerInfoById(Long id);

    void updateCustomerInfoWithParameters(Long id, User user, ManagerInfo managerInfo, String password,
                                          String directorsName, String company, String directorsEmail,
                                          String directorsPhone, String companyType, String address,
                                          String website, String name, String email, String phone, String accountType);
}
