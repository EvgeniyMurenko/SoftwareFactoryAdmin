package com.SoftwareFactoryAdmin.controller;


import com.SoftwareFactoryAdmin.comparator.CaseByDateComporator;
import com.SoftwareFactoryAdmin.constant.MessageEnum;
import com.SoftwareFactoryAdmin.model.*;
import com.SoftwareFactoryAdmin.service.*;
import com.SoftwareFactoryAdmin.util.AppMethods;
import com.SoftwareFactoryAdmin.util.SaveFile;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/cases")
@SessionAttributes("roles")
public class CaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private CaseService caseService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MailService mailService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getManagerCabinetCase(HttpSession session) {

        if (session.getAttribute("managerInfo") == null){
            return new ModelAndView("redirect:/main/");
        }

        ModelAndView managerAdminCabinetCase = new ModelAndView("casesList");
        List<Case> caseArrayList = caseService.findAllWhereUserIsNotDelete();


        System.out.println("========================================");
        System.out.println(caseArrayList);
        System.out.println("========================================");

        Collections.sort(caseArrayList, new CaseByDateComporator());
        System.out.println(caseArrayList);
        System.out.println("========================================");

        managerAdminCabinetCase.addObject("cases", caseArrayList);

        return managerAdminCabinetCase;
    }

    @RequestMapping(value = "/{caseId}", method = RequestMethod.GET)
    public ModelAndView getCaseToShow(@PathVariable Long caseId) {
        ModelAndView managerAdminCaseRespond = new ModelAndView("caseRespond");

        Case aCase = caseService.getCaseById(caseId);
        managerAdminCaseRespond.addObject("case", aCase);

        return managerAdminCaseRespond;
    }

    @RequestMapping(value = "/print-answer", method = RequestMethod.POST)
    public ModelAndView casePrintMessageAnswer(@RequestParam("id") Long id, @RequestParam("message") String messageText,
                                               @RequestParam("appointmentTime") String appointmentTime,
                                               @RequestParam("file[]") MultipartFile[] files, HttpSession httpSession) {

        System.out.println("IDDD"  + id);

        // GET
        Case aCase = caseService.getCaseById(id);
        Long userId = (Long) httpSession.getAttribute("UserId");
        User currentUser = userService.findById(userId);
        aCase.setEmergency(false);

        User customer = userService.findById(aCase.getProject().getCustomerInfo().getId());

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = formatter.parse(appointmentTime + ":00");
            aCase.setAppointmentTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // CREATE MESSAGE
        Message message = new Message();
        message.setaCase(aCase);

        message.setUser(currentUser);
        message.setMessageTime(new java.util.Date());
        message.setMessageText(messageText);
        message.setIsRead(MessageEnum.NOTREAD.toString());
        message.setMessageLinks(new HashSet<>());
        messageService.addNewMessage(message);

        // SAVE MESSAGE TO CASE
        Set<Message> messages = aCase.getMessages();
        messages.add(message);
        aCase.setMessages(messages);

        //SAVE FILE
        SaveFile saveFile = new SaveFile(files);
        saveFile.saveMessageFilesToMessage(message);
        messageService.updateMessage(message);


        caseService.updateCase(aCase);

        String registrationLink = "www.sofac.kr";
        mailService.sendEmailAfterEstimateRespond(aCase.getProject().getCustomerInfo().getEmail(), message, customer, registrationLink, aCase.getProject().getCustomerInfo().isFullCreated());

        return new ModelAndView("redirect:/cases/" + id);
    }

    @RequestMapping(value = "/{projectId}/createNewProject", method = RequestMethod.POST)
    public ModelAndView createProjectFromEstimate(@PathVariable Long projectId,
                                                  @RequestParam("project_name") String projectName) {
        ModelAndView managerAdminCaseRespond = new ModelAndView("redirect:/cases/");

 /*       Project projectEstimate = projectService.getProjectById(projectId);

        Project newProject = projectEstimate;
        newProject.setProjectName(projectName);
        newProject.setCreateDate(new Date());

        projectService.addNewProject(newProject);

        Set<Case> caseSet = projectEstimate.getCases();
        if (caseSet.size()>0){
            for (Case aCase : caseSet){
                aCase.setProject(newProject);
            }
        }

        newProject.setCases(caseSet);
        projectService.updateProject(newProject);*/


        return managerAdminCaseRespond;
    }

    @ResponseBody
    @RequestMapping(value = "/get-messate-to-translate", method = RequestMethod.GET)
    public String getTranslateComment(@RequestParam("messageId") Long messageId) throws Exception {
        JSONObject myJsonObj = new JSONObject();

        Message message = messageService.getMessageById(messageId);


        StringBuilder stringBuilderMessageId = new StringBuilder();
        stringBuilderMessageId.append("<input type=\"hidden\" name=\"messageId\" value=\""+message.getId()+"\">");

        myJsonObj.append("stringBuilderMessageId", stringBuilderMessageId);
        myJsonObj.append("textToTranslate", message.getMessageText());

        return myJsonObj.toString();
    }

    @RequestMapping(value = "/save-message-translate", method = RequestMethod.POST)
    public ModelAndView savePostTranslate(@RequestParam("messageId") Long messageId,
                                          @RequestParam("translateText") String translateText) {

        Message message = messageService.getMessageById(messageId);

        if (translateText != null && !"".equals(translateText)) {
            message.setMessageTranslateText(translateText);
            messageService.updateMessage(message);
        }

        return new ModelAndView("redirect:/cases/"+message.getaCase().getId()+"/");
    }
}
