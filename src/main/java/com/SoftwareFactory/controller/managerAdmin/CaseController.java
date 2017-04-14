package com.SoftwareFactory.controller.managerAdmin;

import com.SoftwareFactory.constant.MainPathEnum;
import com.SoftwareFactory.constant.MessageEnum;
import com.SoftwareFactory.model.*;
import com.SoftwareFactory.service.*;
import com.SoftwareFactory.util.SaveFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/cases")
@SessionAttributes("roles")
public class CaseController {

    @Autowired
    UserService userService;

    @Autowired
    ManagerInfoService managerInfoService;

    @Autowired
    MessageService messageService;

    @Autowired
    CaseService caseService;

    @Autowired
    ProjectService projectService;

    @Autowired
    MailService mailService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    GoogleCloudKeyService googleCloudKeyService;

    @Autowired
    StaffInfoService staffInfoService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getManagerCabinetCase() {

        ModelAndView managerAdminCabinetCase = new ModelAndView("managerAdminViews/casesList");
        List<Case> caseArrayList = caseService.getAllCases();
        managerAdminCabinetCase.addObject("cases", caseArrayList);

        return managerAdminCabinetCase;
    }

    @RequestMapping(value = "/{caseId}", method = RequestMethod.GET)
    public ModelAndView getCaseToShow(@PathVariable Long caseId) {
        ModelAndView managerAdminCaseRespond = new ModelAndView("managerAdminViews/caseRespond");

        Case aCase = caseService.getCaseById(caseId);

        managerAdminCaseRespond.addObject("case", aCase);

        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(aCase.getUserManagerId());

        System.out.println("======managerInfo " + managerInfo);

        managerAdminCaseRespond.addObject("managerInfo", managerInfo);

        return managerAdminCaseRespond;
    }

    @RequestMapping(value = "/{id}/print_answer", method = RequestMethod.POST)
    public ModelAndView casePrintMessageAnswer(@PathVariable Long id, @RequestParam("message") String messageText,
                                               @RequestParam("appointmentTime") String appointmentTime,
                                               @RequestParam("file[]") MultipartFile[] files, HttpSession httpSession) {

        // GET
        Case aCase = caseService.getCaseById(id);
        int userId = (Integer) httpSession.getAttribute("UserId");
        User currentUser = userService.findById(userId);
        aCase.setEmergency(false);

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
        messageService.addNewMessage(message);

        // SAVE MESSAGE TO CASE
        Set<Message> messages = aCase.getMessages();
        messages.add(message);
        aCase.setMessages(messages);

        //SAVE FILE
        if (!files[0].isEmpty()) {
            String pathToSaveFile = "/case/" + aCase.getProject().getId() + "/" + aCase.getId() + "/" + message.getId();
            SaveFile sf = new SaveFile(pathToSaveFile, files);
            sf.saveFile();
            message.setMessagePath(MainPathEnum.mainPath + pathToSaveFile);
            messageService.updateMessage(message);
        }

        caseService.updateCase(aCase);

        mailService.sendEmailAfterEstimateRespond(aCase.getProject().getCustomerInfo().getEmail(), message.getMessageText());

        List<StaffInfo> staffInfoList = staffInfoService.getAllStaffInfo();
        for (StaffInfo staffInfo : staffInfoList){
            List<String> keys = new ArrayList<>(googleCloudKeyService.findAllKeysByStaff(staffInfo.getId()));
            if (keys.size()>0){
                notificationService.pushNotificationToGCM(keys, message.getMessageText(),aCase.getProjectTitle());
            }
        }

        return new ModelAndView("redirect:/cases/" + id);
    }

    @RequestMapping(value = "/{projectId}/createNewProject", method = RequestMethod.POST)
    public ModelAndView createProjectFromEstimate(@PathVariable Long projectId,
                                                  @RequestParam("project_name") String projectName) {
        ModelAndView managerAdminCaseRespond = new ModelAndView("redirect:/cases/");

        Project projectEstimate = projectService.getProjectById(projectId);

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
        projectService.updateProject(newProject);



        return managerAdminCaseRespond;
    }
}
