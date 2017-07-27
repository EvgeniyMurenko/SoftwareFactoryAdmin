package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.model.User;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import com.SoftwareFactoryAdmin.service.UserService;
import com.SoftwareFactoryAdmin.util.AppMethods;
import com.SoftwareFactoryAdmin.util.SaveFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Locale;


@Controller
@RequestMapping("/settings")
@SessionAttributes("roles")
public class SettingsController {

    @Autowired
    private ManagerInfoService managerInfoService;

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getManagerSettings(HttpSession session) {

        if (session.getAttribute("managerInfo") == null){
            return new ModelAndView("redirect:/main/");
        }

        ModelAndView settingsView = new ModelAndView("settings");

        return settingsView;
    }

    @ResponseBody
    @RequestMapping(value = "/saveSettings", method = RequestMethod.POST)
    public ModelAndView saveSettings(HttpSession httpSession,
                              @RequestParam("name") String name,
                              @RequestParam("phone") String phone,
                              @RequestParam("email") String email,
                              @RequestParam("birthday") String birthday,
                              @RequestParam("newPassword") String newPassword,
                              @RequestParam("confirmNewPassword") String confirmNewPassword,
                              @RequestParam("file[]") MultipartFile[] avatarImage) {

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

        User user = managerInfo.getUser();
        //SAVE FILE
        SaveFile saveFile = new SaveFile(avatarImage);
        saveFile.saveAvatarToUser(user);
        userService.updateUser(user);


        httpSession.setAttribute("managerInfo", managerInfo);

        return new ModelAndView("redirect:/settings/");
    }


    @ResponseBody
    @RequestMapping(value = "/delete-avatar", method = RequestMethod.GET)
    public ModelAndView saveSettings(HttpSession httpSession){
        Long managerId = (Long) httpSession.getAttribute("UserId");

        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

        System.out.println("=============================/delete-avatar");

        User user = managerInfo.getUser();
        //SAVE FILE
        SaveFile.deleteAvatarFromUser(user);
        userService.updateUser(user);

        httpSession.setAttribute("managerInfo", managerInfo);

        return new ModelAndView("redirect:/settings/");
    }
}
