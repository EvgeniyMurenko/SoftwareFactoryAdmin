
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


    @Autowired
    CustomerInfoService customerInfoService;

    @Autowired
    CaseService caseService;

/*@Autowired
MessageService messageService;*/


    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test() {
        System.out.println("test");
        List<Case> cases = caseService.getAllCases();
        Case aCase = cases.get(0);
        Set<Message> messages = aCase.getMessages();
        System.out.println("messages" + messages);
        Status status = aCase.getStatus();
        System.out.println(status.getStatusType());
        if (messages == null) {
            System.out.println("messages null");
        }
        Iterator<Message> iterator = messages.iterator();

        while (iterator.hasNext()) {
            Message message = iterator.next();
            System.out.println(message.getMessageText());
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ModelAndView test1() {
        System.out.println("test1");
        List<CustomerInfo> customerInfos = customerInfoService.getAllCustomerInfos();
        CustomerInfo customerInfo = customerInfos.get(0);
        Set<Project> projects = customerInfo.getProjects();
        if (projects == null) {
            System.out.println("projects null");
        }
        Iterator<Project> iterator = projects.iterator();
        while (iterator.hasNext()) {
            Project project = iterator.next();
            System.out.println(project.getProjectName());
            System.out.println(project.getCustomerInfo().getUserId());
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public ModelAndView test2() {
        System.out.println("============test2");
        List<CustomerInfo> customerInfos = customerInfoService.getAllCustomerInfos();
        CustomerInfo customerInfo = customerInfos.get(1);
        System.out.println("======customerInfo name: "+customerInfo.getFirstName());
        System.out.println("====== cu");
        Set<Project> projects = customerInfo.getProjects();
        if (projects == null) {
            System.out.println("projects null");
        }
        Iterator<Project> iterator = projects.iterator();
        while (iterator.hasNext()) {
            Project project = iterator.next();
            System.out.println(project.getProjectName());
           // System.out.println(project.getCases().get);
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

}

