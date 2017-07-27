package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.comparator.CaseByDateComporator;
import com.SoftwareFactoryAdmin.comparator.EstimateByDateComparator;
import com.SoftwareFactoryAdmin.model.Case;
import com.SoftwareFactoryAdmin.model.Estimate;
import com.SoftwareFactoryAdmin.service.CaseService;
import com.SoftwareFactoryAdmin.service.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/dashboard")
@SessionAttributes("roles")
public class DashboardController {

    @Autowired
    private EstimateService estimateService;

    @Autowired
    private CaseService caseService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView dashboardView(HttpSession session) {

        if (session.getAttribute("managerInfo") == null){
            return new ModelAndView("redirect:/main/");
        }

        ModelAndView dashboardView = new ModelAndView("dashboard");

        List<Estimate> estimateList = estimateService.getAllEstimates();
        List<Case> caseList = caseService.findLimitThreeCase();

        Collections.sort(estimateList, new EstimateByDateComparator());
        Collections.sort(caseList, new CaseByDateComporator());

        dashboardView.addObject("estimateList", estimateList);
        dashboardView.addObject("caseList", caseList);

        return dashboardView;
    }

}
