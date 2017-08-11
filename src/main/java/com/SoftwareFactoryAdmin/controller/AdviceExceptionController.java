package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.PrintWriter;
import java.io.StringWriter;


@ControllerAdvice
@RequestMapping("/error")
public class AdviceExceptionController {


    @Autowired
    MailService mailService;

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAll(Exception ex){

        System.out.println("error");

        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();

        mailService.sendBugExceptionToEmail(exceptionAsString);



        ModelAndView exceptionView;
        if (NoHandlerFoundException.class.isInstance(ex)){
            exceptionView =new  ModelAndView("redirect:/error/404");
        } else {
            exceptionView = new ModelAndView("404");
            exceptionView.addObject("number" , ex);
            exceptionView.addObject("error" ,ex.getMessage());
        }
        return exceptionView;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle(Exception ex) {
        return "redirect:/error/404";
    }

    @RequestMapping(value = {"/404"}, method = RequestMethod.GET)
    public ModelAndView NotFoundPage() {
        return new ModelAndView("404");
    }
}
