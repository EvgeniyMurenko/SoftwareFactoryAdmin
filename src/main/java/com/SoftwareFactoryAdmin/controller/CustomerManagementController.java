package com.SoftwareFactoryAdmin.controller;


import com.SoftwareFactoryAdmin.model.Case;
import com.SoftwareFactoryAdmin.model.CustomerInfo;
import com.SoftwareFactoryAdmin.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/customer-mm")
@SessionAttributes("roles")
public class CustomerManagementController {

    @Autowired
    CustomerInfoService customerInfoService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getManagerCabinetCase() {

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

}
