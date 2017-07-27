package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.model.CustomerInfo;
import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/manager-mm")
@SessionAttributes("roles")
public class ManagerManagementController {

    @Autowired
    private ManagerInfoService managerInfoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView customerList(HttpSession session) {

        if (session.getAttribute("managerInfo") == null){
            return new ModelAndView("redirect:/main/");
        }

        ModelAndView managersList = new ModelAndView("managerPermissionList");

        List<ManagerInfo> managerInfoList = managerInfoService.getAllManagerInfos();

        managersList.addObject("managersList", managerInfoList);

        return  managersList;
    }







}
