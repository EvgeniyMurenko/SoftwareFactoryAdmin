package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.model.Permission;
import com.SoftwareFactoryAdmin.model.User;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import com.SoftwareFactoryAdmin.service.UserService;
import com.SoftwareFactoryAdmin.util.AppMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/permission")
@SessionAttributes("roles")
public class PermissionController {

    @Autowired
    private ManagerInfoService managerInfoService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView permissionList(HttpSession session) {

        if (session.getAttribute("managerInfo") == null) {
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


    @RequestMapping(value = "/create-manager", method = RequestMethod.GET)
    public ModelAndView createManager() {

        ModelAndView createManager = new ModelAndView("managerEdit");

        createManager.addObject("isNew", true);

        return createManager;
    }


    @RequestMapping(value = "/save-manager", method = RequestMethod.POST)
    public ModelAndView saveManager(@RequestParam("name") String name,
                                    @RequestParam("birth_date") String birthDate,
                                    @RequestParam("email") String email,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("password") String password,
                                    @RequestParam("confirm_password") String confirmPassword) {

        if (!password.equals(confirmPassword))
            return new ModelAndView("redirect:/permission/create-manager", "isPasswordError", "true");


        User userManager = userService.createManagerUser(password);

        ManagerInfo managerInfo = new ManagerInfo();
        managerInfo.setId(userManager.getId());
        managerInfo.setName(name);
        managerInfo.setBirthday(AppMethods.getDateFromString(birthDate));
        managerInfo.setEmail(email);
        managerInfo.setPhone(phone);

        managerInfoService.addNewManagerInfo(managerInfo);

        Permission permission = new Permission(managerInfo.getId(), managerInfo, false, false, false, false, false, false, false, false, false , false, false,false);

        managerInfo.setManagerInfoPermissions(permission);

        managerInfoService.updateManagerInfo(managerInfo);

        return new ModelAndView("redirect:/permission/edit-manager/" + managerInfo.getId(), "isCreateUpdateSuccess", "true");
    }


    @RequestMapping(value = "/edit-manager/{managerId}", method = RequestMethod.GET)
    public ModelAndView managerEdit(@PathVariable Long managerId) {

        ModelAndView managerEdit = new ModelAndView("managerEdit");

        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

        managerEdit.addObject("managerInfo", managerInfo);
        managerEdit.addObject("isNew", false);

        return managerEdit;
    }


    @RequestMapping(value = "/update-manager", method = RequestMethod.POST)
    public ModelAndView updateManager(@RequestParam(value = "id") Long id,
                                      @RequestParam("name") String name,
                                      @RequestParam("birth_date") String birthDate,
                                      @RequestParam("email") String email,
                                      @RequestParam("phone") String phone,
                                      @RequestParam("password") String password,
                                      @RequestParam("confirm_password") String confirmPassword) {

        if (!password.equals(confirmPassword))
            return new ModelAndView("redirect:/permission/edit-manager/" + id, "isPasswordError", "true");


        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(id);

        managerInfo.setName(name);
        managerInfo.setBirthday(AppMethods.getDateFromString(birthDate));
        managerInfo.setEmail(email);
        managerInfo.setPhone(phone);
        managerInfo.getUser().setPassword(password);

        managerInfoService.updateManagerInfo(managerInfo);

        return new ModelAndView("redirect:/permission/edit-manager/" + id, "isCreateUpdateSuccess", "true");
    }

}
