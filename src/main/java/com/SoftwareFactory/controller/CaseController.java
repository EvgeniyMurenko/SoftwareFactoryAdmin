package com.SoftwareFactory.controller;


import com.SoftwareFactory.model.CustomerInfo;
import com.SoftwareFactory.model.Project;
import com.SoftwareFactory.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;


@Controller
@SessionAttributes("roles")
public class CaseController {

    @Autowired
    CustomerInfoService customerInfoService;

    @RequestMapping(value = "/newCase", method = RequestMethod.GET)
    public ModelAndView newCase( HttpSession httpSession) {

        System.out.println("=========new Case=========");
        ModelAndView customerCabinet = new ModelAndView("newCase");
        Long userId = new Long((Integer)httpSession.getAttribute("UserId"));
        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(userId);
        Set<Project> projects = customerInfo.getProjects();
        if (projects != null){
            System.out.println("add projects to casepage");
            customerCabinet.addObject("projects" , projects);
        }
        System.out.print(httpSession.getAttribute("UserRole"));
        return customerCabinet;
    }

    @RequestMapping(value = "/addNewCase", method = RequestMethod.GET)
    public ModelAndView addNewCase( HttpSession httpSession) {
        ModelAndView customerCabinet = new ModelAndView("newCase");



        return customerCabinet;
    }
}

