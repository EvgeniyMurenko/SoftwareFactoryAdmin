
package com.SoftwareFactoryAdmin.controller;



import com.SoftwareFactoryAdmin.constant.GlobalEnum;

import com.SoftwareFactoryAdmin.util.AppMethods;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
@SessionAttributes("roles")
public class TestController {

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public ModelAndView test(@RequestParam("file") MultipartFile[] imageFiles) {

        System.out.print("test" + imageFiles[0].getOriginalFilename());
        ModelAndView settingsView = new ModelAndView("settings");

        return settingsView;
    }


    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ModelAndView test1() {

        System.out.println("on start");
        ModelAndView settingsView = new ModelAndView("404");


        System.out.print(AppMethods.translate("имя" ,"en"));



        return settingsView;
    }

}

