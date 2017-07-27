package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.model.Permission;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/permission")
@SessionAttributes("roles")
public class PermissionController {

    @Autowired
    private ManagerInfoService managerInfoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView permissionList(HttpSession session) {

        if (session.getAttribute("managerInfo") == null){
            return new ModelAndView("redirect:/main/");
        }

        ModelAndView modelAndView = new ModelAndView("managerPermissionList");

        modelAndView.addObject("managersList", managerInfoService.getAllWithPermission());

        return modelAndView;
    }


    @RequestMapping(value = "/change-permission", method = RequestMethod.POST)
    public ModelAndView changePermission(@RequestParam(value = "id") Long id,
                                         @RequestParam(value = "estimate_permission", required = false) boolean estimatePermission,
                                         @RequestParam(value = "case_permission", required = false) boolean casePermission,
                                         @RequestParam(value = "customer_permission", required = false) boolean customerPermission,
                                         @RequestParam(value = "projects_permission", required = false) boolean projectsPermission,
                                         @RequestParam(value = "staff_permission", required = false) boolean staffPermission,
                                         @RequestParam(value = "notice_permission", required = false) boolean noticePermission,
                                         @RequestParam(value = "permission_mm", required = false) boolean permissionManagement,
                                         @RequestParam(value = "translate_permission", required = false) boolean translatePermission) {

        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(id);

        Permission permission = managerInfo.getManagerInfoPermissions();
        permission.setEstimatePermission(estimatePermission);
        permission.setCasePermission(casePermission);
        permission.setCustomerPermission(customerPermission);
        permission.setProjectsPermission(projectsPermission);
        permission.setStaffPermission(staffPermission);
        permission.setNoticePermission(noticePermission);
        permission.setPermissionManagement(permissionManagement);
        permission.setTranslatePermission(translatePermission);

        managerInfo.setManagerInfoPermissions(permission);

        managerInfoService.updateManagerInfo(managerInfo);

        return new ModelAndView("redirect:/permission/", "isSuccess", "true");
    }


}
