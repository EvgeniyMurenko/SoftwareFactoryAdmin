package com.SoftwareFactory.controller;


import com.SoftwareFactory.comparator.ProjectByDateComparator;
import com.SoftwareFactory.constant.MessageEnum;
import com.SoftwareFactory.constant.StatusEnum;
import com.SoftwareFactory.model.*;
import com.SoftwareFactory.savefile.SaveFile;
import com.SoftwareFactory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;


@Controller
@SessionAttributes("roles")
public class CaseController {

    @Autowired
    CustomerInfoService customerInfoService;

    @RequestMapping(value = "/newCase", method = RequestMethod.GET)
    public ModelAndView newCase(HttpSession httpSession ) {

        ModelAndView customerCabinet = new ModelAndView("customerCase");
        addGeneralDataToMAVAndReturnProjects(customerCabinet , httpSession);



        /*Long userId = new Long((Integer)httpSession.getAttribute("UserId"));


        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(userId);*/
     /*   Set<Project> projects = customerInfo.getProjects();
        if (projects != null){
            System.out.println("add projects to casepage");
            customerCabinet.addObject("projects" , projects);
        }*/

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
    public ModelAndView createCase(HttpSession httpSession, @RequestParam("projectName") String projectName,
                                   @RequestParam("caseName") String caseName,
                                   @RequestParam("message") String message, @RequestParam("language") String language,
                                   @RequestParam("file[]") MultipartFile[] files){

        System.out.print(projectName + " " + " " + caseName + " " + message + " " + " " + language);

/*
        SaveFile sf = new SaveFile("C:"+File.separator+"test", files);
        sf.saveFile();*/
        //===================================================
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
        Case newCase = new Case();
        newCase.setProject(project);
        newCase.setProjectTitle(caseName);
        newCase.setStatus(StatusEnum.OPEN.toString());
        Date date = new Date();
        newCase.setCreationDate(date);
        newCase.setUserManagerId(0L);

        Set<Case> caseSet = project.getCases();
        caseSet.add(newCase);
        project.setCases(caseSet);
        projectService.updateProject(project);
        Case caseCreated = caseService.getCaseById(newCase.getId());
        Set<Message> messages = caseCreated.getMessages();
        Message msg = new Message();
        msg.setaCase(caseCreated);
        User us = userService.findById(userId.intValue());
        msg.setUser(us);
        msg.setMessageTime(date);
        msg.setMessageText(message);
       /* *//**//*msg.setMessageText(new StringConvector(message).convector());*/

        msg.setIsRead(MessageEnum.NOTREAD.toString());
        messages.add(msg);
        messageService.addNewMessage(msg);
        caseCreated.setMessages(messages);
        caseService.updateCase(caseCreated);

        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        return modelAndView;
    }

    private Set<Project>  addGeneralDataToMAVAndReturnProjects(ModelAndView modelAndView , HttpSession httpSession){

        Long userId = new Long((Integer) httpSession.getAttribute("UserId"));
        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(userId);

        String customerName = customerInfo.getName();

        Set<Project> projectsToShow = customerInfo.getProjects();

        List<Project> sortedProjectListToShow = new ArrayList<>(projectsToShow);
        Collections.sort(sortedProjectListToShow, new ProjectByDateComparator());

        //PUT OBJECTS TO MODEL
        modelAndView.addObject("customerName" , customerName);
        modelAndView.addObject("projects", sortedProjectListToShow);

        return projectsToShow;
    }

}


