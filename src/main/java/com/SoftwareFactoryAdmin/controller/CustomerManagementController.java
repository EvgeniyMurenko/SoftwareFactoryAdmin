package com.SoftwareFactoryAdmin.controller;


import com.SoftwareFactoryAdmin.constant.ProjectEnum;
import com.SoftwareFactoryAdmin.constant.StatusEnum;
import com.SoftwareFactoryAdmin.model.Case;
import com.SoftwareFactoryAdmin.model.CustomerInfo;
import com.SoftwareFactoryAdmin.model.Project;
import com.SoftwareFactoryAdmin.model.User;
import com.SoftwareFactoryAdmin.service.CustomerInfoService;
import com.SoftwareFactoryAdmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/customer-mm")
@SessionAttributes("roles")
public class CustomerManagementController {

    @Autowired
    CustomerInfoService customerInfoService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView customerList() {

        ModelAndView customersList = new ModelAndView("customersList");

        List<CustomerInfo> customerInfoList = customerInfoService.getAllCustomerInfos();

        customersList.addObject("customersList", customerInfoList);

        return  customersList;
    }


    @RequestMapping(value = "/add-customer", method = RequestMethod.GET)
    public ModelAndView addNotice() {

        ModelAndView addCustomer = new ModelAndView("customersEdit");

        addCustomer.addObject("isNew", true);

        return addCustomer;
    }


    @RequestMapping(value = "/edit-customer/{customerId}", method = RequestMethod.GET)
    public ModelAndView editCustomer(@PathVariable Long customerId) {

        ModelAndView editCustomer = new ModelAndView("customersEdit");

        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(customerId);

        editCustomer.addObject("isNew", false);
        editCustomer.addObject("customerInfo", customerInfo);

        return editCustomer;

    }


    @RequestMapping(value = "/delete-customer/{customerId}", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable Long customerId) {

        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(customerId);

        customerInfoService.deleteCustomerInfo(customerInfo);

        return new ModelAndView("redirect:/customer-mm/");
    }

    @Autowired
    UserService userService;

    @RequestMapping(value = "/save-new-customer", method = RequestMethod.POST)
    public ModelAndView saveNewCustomer(@RequestParam("name") String name,
                                      @RequestParam("email") String email,
                                      @RequestParam("phone") String phone,
                                      @RequestParam("company") String company,
                                      @RequestParam("site_link") String website,
                                      @RequestParam("password") String password,
                                      @RequestParam("confirm_password") String confirmPassword) {

        if (!password.equals(confirmPassword)) return new ModelAndView("redirect:/customer-mm/add-customer","isPasswordError" ,"true");


        User customerUser = userService.createCustomerUser(password);


        CustomerInfo customerInfo = new CustomerInfo(customerUser.getId() ,customerUser, name, company, phone, email, website , new HashSet<>() , true);
        customerInfo.setStandardAccount(true);

        customerInfoService.addNewCustomerInfo(customerInfo);


        CustomerInfo customerInfoCreated = customerInfoService.getCustomerInfoById(customerInfo.getId());

        //CREATE #$GENERAL PROJECT FOR CUSTOMER

        Project projectNormal = new Project(ProjectEnum.projectNameNormal.getDbValue(), new Date(), StatusEnum.OPEN.toString(), customerInfo, new HashSet<>(), "test");
        Project projectEstimate = new Project(ProjectEnum.projectNameEstimate.getDbValue(), new Date(), StatusEnum.OPEN.toString(), customerInfo, new HashSet<>(), "test");


        Set<Project> projectsToAdd = new HashSet<>();
        projectsToAdd.add(projectNormal);
        projectsToAdd.add(projectEstimate);
        customerInfoCreated.setProjects(projectsToAdd);


        customerInfoService.updateCustomerInfo(customerInfoCreated);


        return new ModelAndView("redirect:/customer-mm/edit-customer/" + customerInfoCreated.getId() , "isEditCreateSuccess" , "true");
    }

    @RequestMapping(value = "/update-customer", method = RequestMethod.POST)
    public ModelAndView updateCustomer(@RequestParam("id") Long id,
                                        @RequestParam("name") String name,
                                        @RequestParam("email") String email,
                                        @RequestParam("phone") String phone,
                                        @RequestParam("company") String company,
                                        @RequestParam("site_link") String website,
                                        @RequestParam("password") String password,
                                        @RequestParam("confirm_password") String confirmPassword,
                                        @RequestParam("accountType") String accountType) {


        if (!password.equals(confirmPassword)) return new ModelAndView("redirect:/customer-mm/edit-customer/"+id ,"isPasswordError" ,"true");

        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(id);

        customerInfo.setName(name);
        customerInfo.setEmail(email);
        customerInfo.setPhone(phone);
        customerInfo.setCompany(company);
        customerInfo.setWebsite(website);
        customerInfo.setFullCreated(true);

        if (accountType.equals("standard")){
            customerInfo.setStandardAccount(true);
        } else {
            customerInfo.setStandardAccount(false);
        }

        customerInfoService.updateCustomerInfo(customerInfo);

        User user = userService.findById(id);

        if (password !=null && confirmPassword !=null && !"".equals(password) && !"".equals(confirmPassword)) {
            System.out.println("set pass" + password);
            user.setPassword(password);
        }
        userService.updateUser(user);

        ModelAndView editCustomer = new ModelAndView("redirect:/customer-mm/edit-customer/" + id , "isEditCreateSuccess" , "true");

        return editCustomer;
    }
}
