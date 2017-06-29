package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/permission")
@SessionAttributes("roles")
public class PermissionController {

    @Autowired
    ManagerInfoService managerInfoService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView permissionList() {

        ModelAndView modelAndView = new ModelAndView("managerPermissionList");

        modelAndView.addObject("managersList" , managerInfoService.getAllWithPermission());

        return modelAndView;
    }





}
