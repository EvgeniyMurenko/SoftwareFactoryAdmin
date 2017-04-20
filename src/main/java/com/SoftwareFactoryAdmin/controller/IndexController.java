package com.SoftwareFactoryAdmin.controller;


import com.SoftwareFactoryAdmin.service.EstimateService;
import com.SoftwareFactoryAdmin.service.UserProfileService;
import com.SoftwareFactoryAdmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("roles")
public class IndexController {


    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    EstimateService estimateService;


    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;


    @RequestMapping(value = {"/" , "/main"}, method = RequestMethod.GET )
    public ModelAndView loginPage() {


        if (isCurrentAuthenticationAnonymous()) {
            ModelAndView mainPage = new ModelAndView("index");
            return mainPage;
        } else {

            ModelAndView modelAndView = new ModelAndView("redirect:/list/");
            return modelAndView;
        }
    }

    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }


    @RequestMapping(value = "/session_expired", method = RequestMethod.POST)
    public ModelAndView sessionExpired( ){
        ModelAndView modelAndView = new ModelAndView("redirect:/main");

        modelAndView.addObject("isSessionExpired" , new Boolean(true));

        return modelAndView;
    }


}
