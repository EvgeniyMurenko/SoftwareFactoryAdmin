package com.SoftwareFactory.controller;


import com.SoftwareFactory.model.Project;
import com.SoftwareFactory.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Set;


@Controller
@SessionAttributes("roles")
public class UserCabinetController {

    @Autowired
    CustomerInfoService customerInfoService;

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public ModelAndView cabinet(Locale locale , HttpSession httpSession) {

        System.out.print("cabinet");

      /*  Long userId = (Long) httpSession.getAttribute("UserId");

        Set<Project> projects = customerInfoService.getCustomerProjects(userId);



        System.out.print(httpSession.getAttribute("UserRole"));*/

        ModelAndView customerCabinet = new ModelAndView("personalArea");
       /* customerCabinet.addObject(projects);*/


        return customerCabinet;
    }







}
