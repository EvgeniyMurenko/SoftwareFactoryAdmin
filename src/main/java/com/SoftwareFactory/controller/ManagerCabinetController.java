package com.SoftwareFactory.controller;

import com.SoftwareFactory.comparator.EstimateByDateComparator;
import com.SoftwareFactory.constant.MessageEnum;
import com.SoftwareFactory.constant.StatusEnum;
import com.SoftwareFactory.model.*;
import com.SoftwareFactory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.sql.Date;
import java.util.*;

@Controller
@RequestMapping("/manager-cabinet")
@SessionAttributes("roles")
public class ManagerCabinetController {


    @Autowired
    EstimateService estimateService;

    @RequestMapping(value = "/estimate", method = RequestMethod.GET)
    public ModelAndView getManagerCabinetEstimate(HttpSession httpSession) {

        System.out.println("manager cabinet");
        Long userId = new Long((Integer) httpSession.getAttribute("UserId"));

        ModelAndView managerCabinetEstimate = new ModelAndView("managerCabinetEstimate");


        List<Estimate> estimates = estimateService.getAllEstimates();



        // SORT BY DATE
        EstimateByDateComparator estimateByDateComparator = new EstimateByDateComparator();
        Collections.sort(estimates, estimateByDateComparator);

        //PUT OBJECTS TO MODEL

        managerCabinetEstimate.addObject("estimates" , estimates);



        return managerCabinetEstimate;
    }

    @RequestMapping(value = "/estimate-respond/{estimateId}", method = RequestMethod.GET)
    public ModelAndView getManagerEstimateRespond(@PathVariable Long estimateId) {

        ModelAndView estimateRespond = new ModelAndView("managerEstimateRespond");
        Estimate estimate = estimateService.getEstimateById(estimateId);
        CustomerInfo customerInfo = estimate.getCustomerInfo();

        estimateRespond.addObject("estimate" , estimate);
        estimateRespond.addObject("customerInfo", customerInfo);


        return estimateRespond;
    }

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @Autowired
    ProjectService projectService;

    @Autowired
    MailService mailService;

    @RequestMapping(value = "/set-respond/{estimateId}" , method = RequestMethod.POST)
    public ModelAndView setRespond(@PathVariable Long estimateId , @RequestParam (value = "message") String message , HttpSession httpSession){

        Estimate estimate = estimateService.getEstimateById(estimateId);
        CustomerInfo customerInfo = estimate.getCustomerInfo();

        int managerId = (Integer) httpSession.getAttribute("UserId");
        User manager = userService.findById(managerId);
        int customerId = customerInfo.getId().intValue();
        User customer = userService.findById(customerId);


        Set<Project> projectSet = customerInfo.getProjects();
        Iterator<Project> projectIterator= projectSet.iterator();
        while(projectIterator.hasNext()){
            Project project = projectIterator.next();
            if (project.getProjectName().equals("#$ESTIMATE")){

                //CREATE CASE ESTIMATION
                Set<Message> emptyMessageSet = new HashSet<Message>();

                Case aCase = new Case();
                aCase.setProject(project);
                aCase.setCreationDate(estimate.getDateRequest());
                aCase.setStatus(StatusEnum.OPEN.toString());
                aCase.setLanguage("kr");
                aCase.setProjectTitle("Estimation");
                aCase.setUserManagerId((long) managerId);
                aCase.setMessages(emptyMessageSet);

                Set<Case> cases = project.getCases();
                cases.add(aCase);
                project.setCases(cases);
                projectService.updateProject(project);

                //CREATE MESSAGES FROM CUSTOMER AND MANAGER

                //CUSTOMER
                Message messageFromCustomer = new Message();
                messageFromCustomer.setUser(customer);
                messageFromCustomer.setaCase(aCase);
                messageFromCustomer.setMessageTime(estimate.getDateRequest());
                messageFromCustomer.setMessageText(estimate.getEstimateRequest());
                messageFromCustomer.setMessagePath(estimate.getEstimatePath());
                messageFromCustomer.setIsRead(MessageEnum.READ.toString());
                messageService.addNewMessage(messageFromCustomer);

                //MANAGER
                Message messageFromManager = new Message();
                messageFromManager.setaCase(aCase);
                messageFromManager.setMessageTime(new java.util.Date());
                messageFromManager.setMessageText(message);
                messageFromManager.setMessagePath(null);
                messageFromManager.setIsRead(MessageEnum.READ.toString());
                messageFromManager.setUser(manager);
                messageService.addNewMessage(messageFromManager);


                //ADD TO SET AND SET TO CASE AND UPDATE

                Set<Message> messageSet = aCase.getMessages();

                messageSet.add(messageFromCustomer);
                messageSet.add(messageFromManager);

                aCase.setMessages(messageSet);

                caseService.updateCase(aCase);

                //SET ESTIMATE RESPOND
                estimate.setRespond(true);
                estimateService.updateEstimate(estimate);
            }
        }

        mailService.sendEmailAfterEstimateRespond(customerInfo.getEmail() , message);

        return new ModelAndView("redirect:/manager-cabinet/estimate");
    }

    @Autowired
    CaseService caseService;

    @RequestMapping(value = "/case/{id}/{name}/{companyName}", method = RequestMethod.GET)
    public ModelAndView getManagerCabinetCase(@PathVariable Long id ,@PathVariable String name ,@PathVariable String companyName) {

        ModelAndView managerCabinetCase = new ModelAndView("managerCabinetCase");

        //GET ALL CASES SORTED BY DATE
        if (id.toString().equals("0") & name.equals("0") & companyName.equals("0")){
            ArrayList<Case> caseArrayList = (ArrayList<Case>) caseService.getAllCases();
            managerCabinetCase.addObject("cases" , caseArrayList);
        } /*else if (!id.equals(0)) {

        } else (){

        }*/





        return managerCabinetCase;
    }




}
