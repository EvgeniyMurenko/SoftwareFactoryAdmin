package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.comparator.CaseByDateComporator;
import com.SoftwareFactoryAdmin.comparator.CaseByStatusAndDateComparator;
import com.SoftwareFactoryAdmin.comparator.EstimateByDateComparator;
import com.SoftwareFactoryAdmin.model.Case;
import com.SoftwareFactoryAdmin.model.Estimate;
import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.service.CaseService;
import com.SoftwareFactoryAdmin.service.EstimateService;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import com.SoftwareFactoryAdmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/dashboard")
@SessionAttributes("roles")
public class DashboardController {

    @Autowired
    EstimateService estimateService;

    @Autowired
    CaseService caseService;

    @Autowired
    UserService userService;

    @Autowired
    ManagerInfoService managerInfoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView dashboardView( HttpSession httpSession) {

        Long managerId = (Long) httpSession.getAttribute("UserId");

        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

        ModelAndView dashboardView = new ModelAndView("dashboard");

        List<Estimate> estimateList = estimateService.getAllEstimates();
        List<Case> caseList = caseService.getAllCases();

        Collections.sort(estimateList, new EstimateByDateComparator());
        Collections.sort(caseList, new CaseByDateComporator());

        dashboardView.addObject("estimateList", estimateList);
        dashboardView.addObject("caseList", caseList);
        dashboardView.addObject("managerInfo", managerInfo);

        return dashboardView;
    }

}
