/*
package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.constant.StatusEnum;
import com.SoftwareFactoryAdmin.model.*;
import com.SoftwareFactoryAdmin.service.GoogleCloudKeyService;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import com.SoftwareFactoryAdmin.service.PushNotificationService;
import com.SoftwareFactoryAdmin.service.TossService;
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
    private TossService tossService;

    @Autowired
    private ManagerInfoService managerInfoService;

    @Autowired
    private GoogleCloudKeyService googleCloudKeyService;

    @Autowired
    private PushNotificationService pushNotificationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView tossList(HttpSession httpSession) {

        ModelAndView tossList = new ModelAndView("tossList");

        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        List<Toss> tosses = tossService.findAllTossBelongToManager(managerInfo.getId());

        tossList.addObject("toss", tosses);

        return tossList;
    }


    ////
    @RequestMapping(value = "/select/{status}", method = RequestMethod.GET)
    public ModelAndView tossSelect(@PathVariable String status,
                                   HttpSession httpSession) {

        ModelAndView tossList = new ModelAndView("tossList");

        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        List<Toss> tosses = new ArrayList<>();

        if (status.equals("new-request")) {
            tosses = tossService.findAllTossBelongToManagerByStatus(managerInfo.getId(), StatusEnum.NEW_REQUEST.toString());
        } else if (status.equals("processing")) {
            tosses = tossService.findAllTossBelongToManagerByStatus(managerInfo.getId(), StatusEnum.PROCESSING.toString());
        } else if (status.equals("pause")) {
            tosses = tossService.findAllTossBelongToManagerByStatus(managerInfo.getId(), StatusEnum.PAUSE.toString());
        } else if (status.equals("finish")) {
            tosses = tossService.findAllTossBelongToManagerByStatus(managerInfo.getId(), StatusEnum.FINISH.toString());
        }

        tossList.addObject("toss", tosses);

        return tossList;
    }



    @RequestMapping(value = "/open-task", method = RequestMethod.GET)
    public ModelAndView tossOpenTask(HttpSession httpSession) {

        ModelAndView tossOpen = new ModelAndView("tossOpenTask");

        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        List<ManagerInfo> managerInfos = managerInfoService.getAllManagerInfosExceptOneManager(managerInfo.getId());

        tossOpen.addObject("managerInfos", managerInfos);

        return tossOpen;

    }

    @RequestMapping(value = "/open", method = RequestMethod.POST)
    public ModelAndView tossOpen(@RequestParam("title") String title,
                                 @RequestParam("text") String text,
                                 @RequestParam(value = "is_now_checkbox", defaultValue = "false") Boolean isNow,
                                 @RequestParam("end_date") String endDate,
                                 @RequestParam("persons") ArrayList<String> persons,
                                 HttpSession httpSession) {

       */
/* ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        Set<ManagerInfo> recipientPersons = managerInfoService.findMultiplyManagerInfoById(persons);

        Date endTossDate = new Date();
        if (!isNow) endTossDate = AppMethods.getDateFromString(endDate);

        TossTask tossTask = new TossTask(managerInfo, recipientPersons, StatusEnum.NEW_REQUEST.toString(), title, text, new Date(), endTossDate, isNow, new HashSet<>());

        tossService.addNewTossTask(tossTask);

        sendTossPush(tossTask, "Toss : " + title, text);*//*


        return new ModelAndView("redirect:/toss/");
    }

    @RequestMapping(value = "/toss-conversation/{id}", method = RequestMethod.GET)
    public ModelAndView tossConversation(@PathVariable Long id) {

        ModelAndView tossConversation = new ModelAndView("tossConversation");

        TossTask tossTask = tossService.getTossTaskById(id);

        tossConversation.addObject("tossTask", tossTask);

        return tossConversation;
    }

    @RequestMapping(value = "/answer-message", method = RequestMethod.POST)
    public ModelAndView tossAnswerMessage(@RequestParam("id") Long id,
                                          @RequestParam("status") String status,
                                          @RequestParam("answer") String answer,
                                          HttpSession httpSession) {

       */
/* ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        TossTask tossTask = tossService.getTossTaskById(id);

        tossTask.setStatus(status);

        TossTaskMessage tossTaskMessage = new TossTaskMessage(managerInfo, tossTask, answer, new Date(), status);

        Set<TossTaskMessage> tossTaskMessages = tossTask.getTossTaskMessages();

        tossTaskMessages.add(tossTaskMessage);

        tossService.updateTossTask(tossTask);

        sendTossPush(tossTask, "Toss : " + tossTask.getTitle(), answer);*//*


        return new ModelAndView("redirect:/toss/toss-conversation/" + id, "isNewAnswer", "true");
    }

    private void sendTossPush(TossTask tossTask, String title, String messageText) {
        */
/*Set<ManagerInfo> managerInfos = tossTask.getManagerInfoEngaged();

        List<Long> managersID = new ArrayList<>();
        for (ManagerInfo manager : managerInfos) {
            managersID.add(manager.getId());
        }
        managersID.add(tossTask.getManagerInfoOpened().getId());

        List<String> googleCloudKeys = googleCloudKeyService.findAllKeysByUserIds(managersID);

        pushNotificationService.pushNotificationToGCM(googleCloudKeys, messageText, title, AppRequestEnum.TOSS_PUSH_TYPE.toString());
*//*

    }

}

*/
