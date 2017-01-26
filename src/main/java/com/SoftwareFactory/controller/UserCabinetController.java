package com.SoftwareFactory.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;


@Controller
@SessionAttributes("roles")
public class UserCabinetController {


/*shdfjshd5fgtsdgjk*/

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public ModelAndView cabinet(Locale locale , HttpSession httpSession) {

        System.out.print("cabinet");


        System.out.print(httpSession.getAttribute("UserId"));
        System.out.print(httpSession.getAttribute("UserRole"));




        return new ModelAndView("personalArea");
    }







}
