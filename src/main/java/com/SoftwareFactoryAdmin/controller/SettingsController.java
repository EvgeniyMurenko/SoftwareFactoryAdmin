package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.model.ManagerInfo;
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
@RequestMapping("/settings")
@SessionAttributes("roles")
public class SettingsController {

    @Autowired
    ManagerInfoService managerInfoService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getManagerCabinetCase() {

        ModelAndView settingsView = new ModelAndView("settings");

        return settingsView;
    }

    @RequestMapping(value = "/saveSettings", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView infoSettings(HttpSession httpSession,
                              @RequestParam("name") String name,
                              @RequestParam("phone") String phone,
                              @RequestParam("email") String email,
                              @RequestParam("birthday") String birthday,
                              @RequestParam("newPassword") String newPassword,
                              @RequestParam("confirmNewPassword") String confirmNewPassword) {

        Long managerId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

        if (!"".equals(newPassword) && !"".equals(confirmNewPassword) && newPassword.equals(confirmNewPassword)){
            User managerUser = userService.findById(managerId);
            managerUser.setPassword(newPassword);
            userService.updateUser(managerUser);
        }

        managerInfo.setName(name);
        managerInfo.setPhone(phone);
        managerInfo.setEmail(email);
        Date birthdayManager = AppMethods.getDateFromString(birthday);
        managerInfo.setBirthday(birthdayManager);

        managerInfoService.updateManagerInfo(managerInfo);

        httpSession.setAttribute("managerInfo", managerInfo);

        return new ModelAndView("redirect:/settings/");
    }

}
