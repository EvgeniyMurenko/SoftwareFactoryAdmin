
package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.constant.AppRequestEnum;
import com.SoftwareFactoryAdmin.dto.base.ServerRequest;
import com.SoftwareFactoryAdmin.model.FxmPost;
import com.SoftwareFactoryAdmin.service.FxmPostService;
import com.SoftwareFactoryAdmin.util.AppMethods;
import com.SoftwareFactoryAdmin.util.SaveFile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
@SessionAttributes("roles")
public class TestController {



}
  /*  @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ModelAndView test1() {

        System.out.println("on start");
        ModelAndView settingsView = new ModelAndView("404");


        System.out.print(AppMethods.translate("имя" ,"en"));



        return settingsView;
    }
*/





