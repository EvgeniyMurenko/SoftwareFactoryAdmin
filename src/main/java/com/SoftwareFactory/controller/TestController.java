
package com.SoftwareFactory.controller;

import com.SoftwareFactory.dao.CustomerInfoDaoImpl;
import com.SoftwareFactory.dao.EstimateDao;
import com.SoftwareFactory.dao.StatusDaoImpl;
import com.SoftwareFactory.dao.UserProfileDao;
import com.SoftwareFactory.model.*;
import com.SoftwareFactory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;


@Controller
@SessionAttributes("roles")
public class TestController {

/*
@Autowired
CustomerInfoServiceImpl customerInfoService;*/

@Autowired
CaseService caseService;

/*@Autowired
MessageService messageService;*/




    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test() {

        System.out.println("test");
/*        customerInfoService.addNewCustomerInfo(new CustomerInfo(new Long(2) , "test" , "test" , "test" ,"test"));*/
        System.out.println("test1");
        List<Case> cases= caseService.getAllCases();
        System.out.println("test2");
        Set <Message> messages = cases.get(1).getMessages();
        System.out.println("test3");

        if (messages ==null){
            System.out.println("messages null");
        }

        Iterator<Message> iterator = messages.iterator();

        System.out.println("test4");

        while(iterator.hasNext()) {
            Message message = iterator.next();
            System.out.println(message.getMessageText());
        }




        /*System.out.println("test1");
        List<CustomerInfo> customerInfos = customerInfoService.getAllCustomersInfo();
        System.out.println("test2");
        Set <Project> projects = customerInfos.get(0).getProjects();
        System.out.println("test2");

        if (projects ==null){
            System.out.println("projects null");
        }


        Iterator<Project> iterator = projects.iterator();

        System.out.println("test3");

        while(iterator.hasNext()) {
            Project project = iterator.next();
         *//*   if(setElement==2) {
                iterator.remove();
            }*//*
        }


      *//*  for (int i =0; i < customerInfos.size();i++){
            CustomerInfo customerInfo = customerInfos.get(i);
            System.out.println(customerInfo);
        }*/



            ModelAndView modelAndView = new ModelAndView("redirect:/");
            return modelAndView;

    }

    @Autowired
    CaseService estimateService;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ModelAndView test1() {
        List<Case> estimate = estimateService.getAllCases();
        System.out.println(estimate.get(1));
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }
}

