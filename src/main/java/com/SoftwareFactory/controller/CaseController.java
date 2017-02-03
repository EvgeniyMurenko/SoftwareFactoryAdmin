package com.SoftwareFactory.controller;


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

    @RequestMapping(value = "/createCase", method = RequestMethod.POST)
    public ModelAndView createCase(HttpSession httpSession, @ModelAttribute("projectName") String projectName,
                                   @ModelAttribute("caseName") String caseName,
                                   @ModelAttribute("message") String message,
                                   @ModelAttribute("file[]") String[] file){


        System.out.println("=========CREATE CASE=========");
        System.out.println("Case selector " + projectName);
        System.out.println("Case name " + caseName);
        System.out.println("Case message " + message);

      /*  for(int i = 0; i < file.length; i++){
            System.out.println("Case files " + file[i]);
        }*/

        System.out.println("=============================");

        Long userId = new Long((Integer)httpSession.getAttribute("UserId"));
        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(userId);

        Set<Project> projects = customerInfo.getProjects();
        Long idProject = -1l;
        if (projects != null){
            Iterator<Project> itr = projects.iterator();
            while (itr.hasNext()) {
                Project project = itr.next();
                if(project.getProjectName().equals(projectName)){
                    System.out.println("=========FOUND SUCSES");
                    //Set<Case> caseSet = project.getCases();
            System.out.println ("STEP1");
                    Case newCase = new Case();
                    System.out.println ("STEP1");
                    newCase.setProject(project);
                    newCase.setProjectTitle(caseName);
                    System.out.println ("STEP2");
                    Status status = new Status();
                    status.setId(2l);
                    status.setStatusType("open");
                    newCase.setStatus(status);
                    System.out.println ("STEP3");
                    Date date = new Date(201, 02, 03);
                    newCase.setCreationDate(date);
                    System.out.println ("STEP4");
                    caseService.addNewCase(newCase);

                    System.out.println ("STEP5");
                    Case caseCreated = caseService.getCaseById(newCase.getId());
                    System.out.println ("STEP6");

                    Set<Message> messages = new HashSet<>();
                    System.out.println ("STEP7");
                    Message msg = new Message();
                    System.out.println ("STEP8");
                    msg.setaCase(caseCreated);
                    System.out.println ("STEP9");
                    User us = userService.findById(userId.intValue());
                    msg.setUser(us);
                    msg.setMessageTime(date);
                    msg.setMessageText(message);
                    System.out.println ("STEP10");
                    messages.add(msg);
                    System.out.println ("STEP11");
                    caseCreated.setMessages(messages);

                    System.out.println ("STEP12");
                    caseService.updateCase(caseCreated);

                    //caseSet.add(newCase);
                    //project.setCases(caseSet);
                    System.out.println("================= END!!!!");
                }
            }

        }


        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        return null;
    }
}

