package com.SoftwareFactory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class PagesController {

    @RequestMapping(value = { "/aboutUs" }, method = RequestMethod.GET)
    public ModelAndView aboutSofac() {
        ModelAndView modelAndView = new ModelAndView("aboutUs");
        return modelAndView;
    }

    @RequestMapping(value = { "/guide" }, method = RequestMethod.GET)
    public ModelAndView guide() {
        ModelAndView modelAndView = new ModelAndView("guide");
        return modelAndView;
    }

    @RequestMapping(value = { "/gxm" }, method = RequestMethod.GET)
    public ModelAndView gxm() {
        ModelAndView modelAndView = new ModelAndView("gxm");
        return modelAndView;
    }

    @RequestMapping(value = { "/portfolio" }, method = RequestMethod.GET)
    public ModelAndView portfolio() {
        ModelAndView modelAndView = new ModelAndView("portfolio");
        return modelAndView;
    }

    @RequestMapping(value = { "/whatIsSofac" }, method = RequestMethod.GET)
    public ModelAndView whatIsSofac() {
        ModelAndView modelAndView = new ModelAndView("whatIsSofac");
        return modelAndView;
    }



}
