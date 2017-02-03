package com.SoftwareFactory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class PagesController {

    @RequestMapping(value = { "/guide" }, method = RequestMethod.GET)
    public ModelAndView guide() {

        ModelAndView modelAndView = new ModelAndView("guide");
        return modelAndView;
    }

    @RequestMapping(value = { "/aboutSofac" }, method = RequestMethod.GET)
    public ModelAndView aboutSofac() {

        ModelAndView modelAndView = new ModelAndView("aboutSofac");
        return modelAndView;
    }



}
