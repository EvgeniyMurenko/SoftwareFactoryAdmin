package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.constant.AppRequestEnum;
import com.SoftwareFactoryAdmin.constant.StatusEnum;
import com.SoftwareFactoryAdmin.model.*;
import com.SoftwareFactoryAdmin.service.*;
import com.SoftwareFactoryAdmin.util.AppMethods;
import com.SoftwareFactoryAdmin.util.SaveFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    private TossTaskService tossTaskService;

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
                                 @RequestParam("file[]") MultipartFile [] multipartFiles,
                                 HttpSession httpSession) {


        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        Set<ManagerInfo> recipientPersons = managerInfoService.findMultiplyManagerInfoById(persons);
        String managers = getManagerEngagedAsString(recipientPersons);

        Date endTossDate = new Date();
        if (!isNow) endTossDate = AppMethods.getDateFromString(endDate);

        Toss toss = new Toss(managerInfo.getName(), recipientPersons, new HashSet<>(), StatusEnum.NEW_REQUEST.toString(), title, new Date(), endTossDate, isNow);

        tossService.addNewToss(toss);

        TossTask tossTask = new TossTask(managerInfo, managers, toss, StatusEnum.NEW_REQUEST.toString(), text, new Date(), new HashSet<>(),new HashSet<>());

        Set<TossTask> tossTasks = toss.getTossTasks();

        tossTasks.add(tossTask);

        toss.setTossTasks(tossTasks);

        tossService.updateToss(toss);

        SaveFile saveFile = new SaveFile(multipartFiles);
        saveFile.saveToTossTaskFiles(tossTask);

        tossTaskService.updateTossTask(tossTask);

        sendTossPush(toss, "Toss : " + title, text);

        return new ModelAndView("redirect:/toss/toss-conversation/" + toss.getId(),"isNewAnswer", "true" );
    }

    @RequestMapping(value = "/toss-conversation/{id}", method = RequestMethod.GET)
    public ModelAndView tossConversation(@PathVariable Long id,
                                         HttpSession httpSession) {

        ManagerInfo user = (ManagerInfo) httpSession.getAttribute("managerInfo");

        ModelAndView tossConversation = new ModelAndView("tossConversation");

        Toss toss = tossService.getTossById(id);

        Set<ManagerInfo> managerInfos = toss.getManagerInfoEngaged();

        List<Long> ids = new ArrayList<>();
        for (ManagerInfo managerInfo : managerInfos){
            ids.add(managerInfo.getId());
        }
        ids.add(user.getId());

        List<ManagerInfo> managerInfosToSelect = managerInfoService.getAllManagerInfofExceptManagers(ids);

        tossConversation.addObject("toss", toss);
        tossConversation.addObject("managers" , managerInfosToSelect);


        return tossConversation;
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public ModelAndView tossOpen(@RequestParam("toss_task_id") Long tossTaskId,
                                 @RequestParam("toss_id") Long tossId,
                                 @RequestParam("comment") String comment,
                                 HttpSession httpSession) {

        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        TossTask tossTask = tossTaskService.getTossTaskById(tossTaskId);

        Set<TossTaskMessage> tossTaskMessages = tossTask.getTossTaskMessages();

        tossTaskMessages.add(new TossTaskMessage(managerInfo, tossTask, comment, new Date()));

        tossTaskService.updateTossTask(tossTask);

        sendTossPush(tossTask.getToss(), "Toss comment : " + tossTask.getToss().getTitle(), comment);

        return new ModelAndView("redirect:/toss/toss-conversation/" + tossId, "isNewAnswer", "true");
    }

    @RequestMapping(value = "/send-another-toss", method = RequestMethod.POST)
    public ModelAndView tossAnswerMessage(@RequestParam("id") Long id,
                                          @RequestParam("status") String status,
                                          @RequestParam("persons") ArrayList<String> persons,
                                          @RequestParam("answer") String answer,
                                          @RequestParam("file[]") MultipartFile [] multipartFiles,
                                          HttpSession httpSession) {

        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        Toss toss = tossService.getTossById(id);

        toss.setStatus(status);

        Set<ManagerInfo> recipientPersons = managerInfoService.findMultiplyManagerInfoById(persons);

        String managers = getManagerEngagedAsString(recipientPersons);

        TossTask tossTask = new TossTask(managerInfo, managers ,toss, status, answer, new Date(),new HashSet<>(), new HashSet<>());

        SaveFile saveFile = new SaveFile(multipartFiles);
        saveFile.saveToTossTaskFiles(tossTask);

        Set<TossTask> tossTasks = toss.getTossTasks();

        tossTasks.add(tossTask);

        toss.setTossTasks(tossTasks);

        Set<ManagerInfo> managerInfos = toss.getManagerInfoEngaged();

        managerInfos.addAll(recipientPersons);

        toss.setManagerInfoEngaged(managerInfos);

        tossService.updateToss(toss);

        sendTossPush(toss, "Toss : " + toss.getTitle(), answer);

        return new ModelAndView("redirect:/toss/toss-conversation/" + id, "isNewAnswer", "true");

    }

    private void sendTossPush(Toss toss, String title, String messageText) {

        Set<ManagerInfo> managerInfos = toss.getManagerInfoEngaged();

        List<Long> managersID = new ArrayList<>();
        for (ManagerInfo manager : managerInfos) {
            managersID.add(manager.getId());
        }
        /*managersID.add(toss.getManagerInfoOpened().getId());*/

        List<String> googleCloudKeys = googleCloudKeyService.findAllKeysByUserIds(managersID);

        pushNotificationService.pushNotificationToGCM(googleCloudKeys, messageText, title, AppRequestEnum.TOSS_PUSH_TYPE.toString());


    }

    private String getManagerEngagedAsString ( Set<ManagerInfo> recipientPersons){

        StringBuilder personsStringBuilder = new StringBuilder();

        Iterator<ManagerInfo> managerInfoIterator = recipientPersons.iterator();

        while (managerInfoIterator.hasNext()) {
            personsStringBuilder.append(managerInfoIterator.next().getName());
            if (managerInfoIterator.hasNext()) personsStringBuilder.append(" , ");
        }
        return personsStringBuilder.toString();

    }

}
