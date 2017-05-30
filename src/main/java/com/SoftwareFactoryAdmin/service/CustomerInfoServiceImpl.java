package com.SoftwareFactoryAdmin.service;

import com.SoftwareFactoryAdmin.dao.CustomerInfoDao;
import com.SoftwareFactoryAdmin.model.CustomerHistory;
import com.SoftwareFactoryAdmin.model.CustomerInfo;

import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


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
    public CustomerInfo getCustomerInfoById(Long id) {
        CustomerInfo customerInfo = customerInfoDao.read(id);
        return customerInfo;
    }

    @Override
    @Transactional
    public void updateCustomerInfoWithParameters(Long id, User user, ManagerInfo managerInfo, String password,
                                              String directorsName, String company, String directorsEmail,
                                              String directorsPhone, String companyType, String address,
                                              String website, String name, String email, String phone, String accountType) {


        StringBuilder historyChanges = new StringBuilder();
        historyChanges.append("Customer update : <br><br>");

        CustomerInfo customerInfo = customerInfoDao.read(id);

        if (!customerInfo.getDirectorsName().equals(directorsName)) {
            historyChanges.append("directors name changed from - " + customerInfo.getDirectorsName() + " to  " + directorsName + "<br>");
            customerInfo.setDirectorsName(directorsName);
        }
        if (!customerInfo.getCompany().equals(company)) {
            historyChanges.append("company changed from - " + customerInfo.getCompany() + " to  " + company + "<br>");
            customerInfo.setCompany(company);
        }
        if (!customerInfo.getDirectorsEmail().equals(directorsEmail)) {
            historyChanges.append("directors email changed from - " + customerInfo.getDirectorsEmail() + " to  " + directorsEmail + "<br>");
            customerInfo.setDirectorsEmail(directorsEmail);
        }
        if (!customerInfo.getDirectorsPhone().equals(directorsPhone)) {
            historyChanges.append("directors phone changed from - " + customerInfo.getDirectorsPhone() + " to  " + directorsPhone + "<br>");
            customerInfo.setDirectorsPhone(directorsPhone);
        }
        if (!customerInfo.getCompanyType().equals(companyType)) {
            historyChanges.append("company type changed from - " + customerInfo.getCompanyType() + " to  " + companyType + "<br>");
            customerInfo.setCompanyType(companyType);
        }
        if (!customerInfo.getAddress().equals(address)) {
            historyChanges.append("address changed from - " + customerInfo.getAddress() + " to  " + address + "<br>");
            customerInfo.setAddress(address);
        }
        if (!customerInfo.getWebsite().equals(website)) {
            historyChanges.append("website changed from - " + customerInfo.getWebsite() + " to  " + website + "<br>");
            customerInfo.setWebsite(website);
        }
        if (!customerInfo.getName().equals(name)) {
            historyChanges.append("name changed from - " + customerInfo.getName() + " to  " + name + "<br>");
            customerInfo.setName(name);
        }
        if (!customerInfo.getEmail().equals(email)) {
            historyChanges.append("email changed from - " + customerInfo.getEmail() + " to  " + email + "<br>");
            customerInfo.setEmail(email);
        }
        if (!customerInfo.getPhone().equals(phone)) {
            historyChanges.append("phone changed from - " + customerInfo.getPhone() + " to  " + phone + "<br>");
            customerInfo.setPhone(phone);
        }
        if (!user.getPassword().equals(password)) {
            user.setPassword(password);
            customerInfo.setUser(user);
        }
        if (accountType.equals("standard")) {
            customerInfo.setStandardAccount(true);
        } else {
            customerInfo.setStandardAccount(false);
        }
        List<CustomerHistory> customerHistories = customerInfo.getCustomerHistories();
        customerHistories.add(new CustomerHistory(historyChanges.toString(), new Date(), customerInfo, managerInfo.getName(), managerInfo.getId()));

        customerInfoDao.update(customerInfo);
    }

}

