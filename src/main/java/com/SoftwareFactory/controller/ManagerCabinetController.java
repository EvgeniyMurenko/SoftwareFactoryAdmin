package com.SoftwareFactory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manager_cabinet")
@SessionAttributes("roles")
public class ManagerCabinetController {




    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getCustomerCabinet(HttpSession httpSession) {

        System.out.println("manager cabinet");


        Long userId = new Long((Integer) httpSession.getAttribute("UserId"));


        ModelAndView customerCabinet = new ModelAndView("customerCabinet");


        return customerCabinet;
    }




}
