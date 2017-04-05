package com.SoftwareFactory.controller.customer;

import com.SoftwareFactory.model.CustomerInfo;
import com.SoftwareFactory.model.User;
import com.SoftwareFactory.service.CustomerInfoService;
import com.SoftwareFactory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("roles")
public class SettingController {

    @Autowired
    UserService userService;

    @Autowired
    CustomerInfoService customerInfoService;

    @RequestMapping(value = "/customerSettings/", method = RequestMethod.GET)
    public ModelAndView customerSettings(HttpSession httpSession) {

        long userId = (Integer) httpSession.getAttribute("UserId");

        ModelAndView customerSettings = new ModelAndView("customerAdminView/customerSettings");

        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(userId);
        User user = userService.findById((int) userId);

        customerSettings.addObject("user", user);
        customerSettings.addObject("customerInfo", customerInfo);

        return customerSettings;
    }

    @RequestMapping(value = "/infoSettings", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView infoSettings(HttpSession httpSession, @RequestParam("name") String recipientName, @RequestParam("email") String recipientMail,
                              @RequestParam("phone") String phone, @RequestParam("companyName") String companyName,
                              @RequestParam("companySite") String companySite) {

        long userId = (Integer) httpSession.getAttribute("UserId");
        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(userId);

        customerInfo.setName(recipientName);
        customerInfo.setEmail(recipientMail);
        customerInfo.setPhone(phone);
        customerInfo.setCompany(companyName);
        customerInfo.setWebsite(companySite);

        customerInfoService.updateCustomerInfo(customerInfo);

        return new ModelAndView("redirect:/cabinet/customerSettings/");
    }

    @RequestMapping(value = "/passwordSettings", method = RequestMethod.POST)
    public @ResponseBody ModelAndView infoSettings(HttpSession httpSession,
                                                   @RequestParam("newPassword") String newPassword,
                                                   @RequestParam("confirmNewPassword") String confirmNewPassword) {

        int userId = (Integer) httpSession.getAttribute("UserId");
        User user = userService.findById(userId);
        if(newPassword.equals(confirmNewPassword) ){
            user.setPassword(newPassword);
            userService.updateUser(user);
        }

        return new ModelAndView("redirect:/cabinet/customerSettings/");
    }
}
