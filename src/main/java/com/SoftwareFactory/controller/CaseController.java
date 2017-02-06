package com.SoftwareFactory.controller;


import com.SoftwareFactory.constant.MessageEnum;
import com.SoftwareFactory.constant.StatusEnum;
import com.SoftwareFactory.model.*;
import com.SoftwareFactory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@Controller
@SessionAttributes("roles")
public class CaseController {

    @Autowired
    CustomerInfoService customerInfoService;

    @RequestMapping(value = "/newCase", method = RequestMethod.GET)
    public ModelAndView newCase(HttpSession httpSession ) {
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


    @Autowired
    CaseService caseService;

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/createCase", method = RequestMethod.POST)
    public ModelAndView createCase(HttpSession httpSession, @ModelAttribute("projectName") String projectName,
                                   @ModelAttribute("caseName") String caseName,
                                   @ModelAttribute("message") String message,
                                   @ModelAttribute("file[]") String[] file){


        System.out.println("=========CREATE CASE=========");
        System.out.println("Case selector " + projectName);
        System.out.println("Case name " + caseName);
        System.out.println("Case message " + message + " /n =============================");



        Long userId = new Long((Integer)httpSession.getAttribute("UserId"));
        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(userId);

        Set<Project> projects = customerInfo.getProjects();


        Project project = null;
        if (projects != null){
            Iterator<Project> itr = projects.iterator();
            while (itr.hasNext()) {

                project = itr.next();

                if(project.getProjectName().equals(projectName)){
                    break;
                }
            }

        }



        System.out.println ("STEP1");

        Case newCase = new Case();

        System.out.println ("STEP1");

        newCase.setProject(project);

        newCase.setProjectTitle(caseName);
        System.out.println ("STEP2");

        newCase.setStatus(StatusEnum.OPEN.toString());
        System.out.println ("STEP3");
        Date date = new Date(2017, 02, 06);
        newCase.setCreationDate(date);
        newCase.setUserManagerId(22L);
        System.out.println ("STEP4");

        Set<Case> caseSet = project.getCases();
        caseSet.add(newCase);


        project.setCases(caseSet);

        projectService.updateProject(project);



        System.out.println ("STEP5");
        Case caseCreated = caseService.getCaseById(newCase.getId());
        System.out.println ("STEP6");

        Set<Message> messages = caseCreated.getMessages();
        System.out.println ("STEP7");
        Message msg = new Message();
        System.out.println ("STEP8");
        msg.setaCase(caseCreated);
        System.out.println ("STEP9");
        User us = userService.findById(userId.intValue());
        msg.setUser(us);
        msg.setMessageTime(date);
        msg.setMessageText(message);
        msg.setIsRead(MessageEnum.NOTREAD.toString());
        System.out.println ("STEP10");
        messages.add(msg);
        messageService.addNewMessage(msg);
        System.out.println ("STEP11");
        caseCreated.setMessages(messages);

        System.out.println ("STEP12");

            caseService.updateCase(caseCreated);
            System.out.println("STEP13");

        //caseSet.add(newCase);
        //project.setCases(caseSet);
        System.out.println("================= END!!!!");



        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        return modelAndView;
    }
}

