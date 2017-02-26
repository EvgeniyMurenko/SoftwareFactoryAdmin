package com.SoftwareFactory.controller;

import com.SoftwareFactory.comparator.EstimateByDateComparator;
import com.SoftwareFactory.model.Case;
import com.SoftwareFactory.model.Estimate;
import com.SoftwareFactory.service.CaseService;
import com.SoftwareFactory.service.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


        estimateRespond.addObject("estimate" , estimate);



        return estimateRespond;
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
        }





        return managerCabinetCase;
    }




}
