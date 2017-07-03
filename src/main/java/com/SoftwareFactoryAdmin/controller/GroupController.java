package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import com.SoftwareFactoryAdmin.service.UserService;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/group")
@SessionAttributes("roles")
public class GroupController {

    @Autowired
    ManagerInfoService managerInfoService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getShowGroup() {

        ModelAndView settingsView = new ModelAndView("group");

        return settingsView;
    }


    @ResponseBody
    @RequestMapping(value = "/get-translate", method = RequestMethod.GET)
    public String getTranslateComment(@RequestParam("commentId") Long id) throws Exception {
        System.out.println("======================= " + id);

        JSONObject myJsonObj = new JSONObject();

        StringBuilder stringBuilderTranslate = new StringBuilder();

        stringBuilderTranslate.append("<div class=\"horizontal-line text-translate mt10\" >");
        stringBuilderTranslate.append(" У меня есть вопрос ... в пятницу я попросил Ольгу загрузить SFCAFE веб-сайт на первую страницу. <br>");
        stringBuilderTranslate.append("Я хочу знать почему ее там нет. <br>");
        stringBuilderTranslate.append("</div>");

        myJsonObj.append("translateComment", stringBuilderTranslate);

        return myJsonObj.toString();
    }





}
