package com.SoftwareFactoryAdmin.controller;


import com.SoftwareFactoryAdmin.model.CustomerInfo;
import com.SoftwareFactoryAdmin.model.User;
import com.SoftwareFactoryAdmin.service.CustomerInfoService;
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

import java.util.Date;
import java.util.List;


@Controller
@SessionAttributes("roles")
public class IndexController {


    @Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;


    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public ModelAndView loginPage() {

        if (isCurrentAuthenticationAnonymous()) {
            ModelAndView mainPage = new ModelAndView("signin");
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
    public ModelAndView sessionExpired() {
        ModelAndView modelAndView = new ModelAndView("redirect:/main");

        modelAndView.addObject("isSessionExpired", new Boolean(true));

        return modelAndView;
    }


}
