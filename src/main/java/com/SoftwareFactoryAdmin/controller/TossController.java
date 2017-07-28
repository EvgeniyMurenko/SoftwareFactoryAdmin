package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.model.TossTask;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import com.SoftwareFactoryAdmin.service.TossTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/toss")
@SessionAttributes("roles")
public class TossController {

    @Autowired
    private TossTaskService tossTaskService;

    @Autowired
    private ManagerInfoService managerInfoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView toDoList(HttpSession httpSession) {

        ModelAndView toDoList = new ModelAndView("tossList");

        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        List<TossTask> tossTasks = tossTaskService.findAllTossTasksBelongToManager(managerInfo.getId());

        return toDoList;
    }


    @RequestMapping(value = "/open-task", method = RequestMethod.GET)
    public ModelAndView toDoOpenTask(HttpSession httpSession) {

        ModelAndView toDoOpen = new ModelAndView("tossOpenTask");

        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        List<ManagerInfo> managerInfos = managerInfoService.getAllManagerInfosExceptOneManager(managerInfo.getId());


        toDoOpen.addObject("managerInfos", managerInfos);


        return toDoOpen;

    }

    @RequestMapping(value = "/open", method = RequestMethod.POST)
    public ModelAndView toDoOpen(@RequestParam("title") String title,
                                 @RequestParam("text") String text,
                                 @RequestParam("persons") ArrayList<String> persons,
                                 HttpSession httpSession) {

        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        Set<ManagerInfo> recipientPersons = managerInfoService.findMultiplyManagerInfoById(persons);

        /*TossTask toDoTask = new TossTask(managerInfo, null ,false, recipientPersons , StatusEnum.NEW_REQUEST.toString() , title , text , new Date() , new HashSet<>());

        tossTaskService.addNewToDoTask(toDoTask);*/

        return new ModelAndView("redirect:/to-do/");
    }

    @RequestMapping(value = "/to-do-conversation/{id}", method = RequestMethod.POST)
    public ModelAndView toDoConversation(@PathVariable Long id,
                                         HttpSession httpSession) {

        ModelAndView toDoConversation = new ModelAndView("tossConversation");

        TossTask tossTask = tossTaskService.getTossTaskById(id);

        toDoConversation.addObject(tossTask);

        return toDoConversation;
    }


}

