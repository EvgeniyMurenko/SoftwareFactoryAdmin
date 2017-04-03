package com.SoftwareFactory.controller;

import com.SoftwareFactory.comparator.EstimateByDateComparator;
import com.SoftwareFactory.constant.MainPathEnum;
import com.SoftwareFactory.constant.MessageEnum;
import com.SoftwareFactory.constant.ProjectEnum;
import com.SoftwareFactory.constant.StatusEnum;
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
import java.util.*;

@Controller
@RequestMapping("/staff-cabinet")
@SessionAttributes("roles")
public class ManagerAdminController {

    @Autowired
    UserService userService;

    @Autowired
    EstimateService estimateService;

    @Autowired
    ManagerInfoService managerInfoService;

    @Autowired
    MessageService messageService;

    @Autowired
    ProjectService projectService;

    @Autowired
    MailService mailService;

    @Autowired
    CaseService caseService;

    @Autowired
    StaffInfoService staffInfoService;

    @Autowired
    MessageTaskService messageTaskService;

    @RequestMapping(value = "/estimate", method = RequestMethod.GET)
    public ModelAndView getManagerCabinetEstimate(HttpSession httpSession) {

        ModelAndView adminCabinetEstimate = new ModelAndView("managerAdminViews/estimatesList");
        List<Estimate> estimates = estimateService.getAllEstimates();

        if (httpSession != null && "ADMIN".equals(httpSession.getAttribute("UserRole"))) {
            adminCabinetEstimate.addObject("managerAdminName", "ADMIN");
        } else if (httpSession != null && "MANAGER".equals(httpSession.getAttribute("UserRole"))) {
            Long userId = new Long((Integer) httpSession.getAttribute("UserId"));
            adminCabinetEstimate.addObject("managerAdminName", managerInfoService.getManagerInfoById(userId).getName());
        } else {
            adminCabinetEstimate.addObject("managerAdminName", "NOT NAME");
        }

        // SORT BY DATE
        EstimateByDateComparator estimateByDateComparator = new EstimateByDateComparator();
        Collections.sort(estimates, estimateByDateComparator);

        adminCabinetEstimate.addObject("estimates", estimates);

        return adminCabinetEstimate;

    }

    @RequestMapping(value = "/estimate-respond/{estimateId}", method = RequestMethod.GET)
    public ModelAndView getManagerEstimateRespond(@PathVariable Long estimateId) {

        ModelAndView estimateRespond = new ModelAndView("managerAdminViews/estimateRespond");
        Estimate estimate = estimateService.getEstimateById(estimateId);
        CustomerInfo customerInfo = estimate.getCustomerInfo();

        estimateRespond.addObject("estimate", estimate);

        estimateRespond.addObject("customerInfo", customerInfo);


        return estimateRespond;
    }

    @RequestMapping(value = "/set-respond/{estimateId}", method = RequestMethod.POST)
    public ModelAndView setRespond(@PathVariable Long estimateId, @RequestParam(value = "message") String message, HttpSession httpSession) {

        Estimate estimate = estimateService.getEstimateById(estimateId);
        CustomerInfo customerInfo = estimate.getCustomerInfo();

        int managerId = (Integer) httpSession.getAttribute("UserId");
        User manager = userService.findById(managerId);

        int customerId = customerInfo.getId().intValue();
        User customer = userService.findById(customerId);

        Set<Project> projectSet = customerInfo.getProjects();
        Iterator<Project> projectIterator = projectSet.iterator();
        while (projectIterator.hasNext()) {
            Project project = projectIterator.next();
            if (project.getProjectName().equals("#$ESTIMATE")) {

                //CREATE CASE ESTIMATION
                Set<Message> emptyMessageSet = new HashSet<Message>();

                Case aCase = new Case();
                aCase.setProject(project);
                aCase.setCreationDate(estimate.getDateRequest());
                aCase.setStatus(StatusEnum.OPEN.toString());
                aCase.setLanguage("kr");
                aCase.setProjectTitle("Estimation");
                aCase.setUserManagerId((long) manager.getId());
                aCase.setMessages(emptyMessageSet);

                Set<Case> cases = project.getCases();
                cases.add(aCase);
                project.setCases(cases);
                projectService.updateProject(project);

                //CREATE MESSAGES FROM CUSTOMER AND MANAGER

                //CUSTOMER
                Message messageFromCustomer = new Message();
                messageFromCustomer.setUser(customer);
                messageFromCustomer.setaCase(aCase);
                messageFromCustomer.setMessageTime(estimate.getDateRequest());
                messageFromCustomer.setMessageText(estimate.getEstimateRequest());
                messageFromCustomer.setMessagePath(estimate.getEstimatePath());
                messageFromCustomer.setIsRead(MessageEnum.READ.toString());
                messageService.addNewMessage(messageFromCustomer);

                //MANAGER
                Message messageFromManager = new Message();
                messageFromManager.setaCase(aCase);
                messageFromManager.setMessageTime(new java.util.Date());
                messageFromManager.setMessageText(message);
                messageFromManager.setMessagePath(null);
                messageFromManager.setIsRead(MessageEnum.READ.toString());
                messageFromManager.setUser(manager);
                messageService.addNewMessage(messageFromManager);


                //ADD TO SET AND SET TO CASE AND UPDATE

                Set<Message> messageSet = aCase.getMessages();

                messageSet.add(messageFromCustomer);
                messageSet.add(messageFromManager);

                aCase.setMessages(messageSet);

                caseService.updateCase(aCase);

                //SET ESTIMATE RESPOND
                estimate.setRespond(true);
                estimateService.updateEstimate(estimate);
            }
        }

        mailService.sendEmailAfterEstimateRespond(customerInfo.getEmail(), message);

        return new ModelAndView("redirect:/staff-cabinet/estimate");
    }

    @RequestMapping(value = "/cases", method = RequestMethod.GET)
    public ModelAndView getManagerCabinetCase() {

        ModelAndView managerAdminCabinetCase = new ModelAndView("managerAdminViews/casesList");
        List<Case> caseArrayList = caseService.getAllCases();
        managerAdminCabinetCase.addObject("cases", caseArrayList);

        return managerAdminCabinetCase;
    }

    @RequestMapping(value = "/case/{caseId}", method = RequestMethod.GET)
    public ModelAndView getCaseToShow(@PathVariable Long caseId) {
        ModelAndView managerAdminCaseRespond = new ModelAndView("managerAdminViews/caseRespond");

        Case aCase = caseService.getCaseById(caseId);

        managerAdminCaseRespond.addObject("case", aCase);

        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(aCase.getUserManagerId());

        System.out.println("======managerInfo " + managerInfo);

        managerAdminCaseRespond.addObject("managerInfo", managerInfo);

        return managerAdminCaseRespond;
    }

    @RequestMapping(value = "/case/{id}/print_answer", method = RequestMethod.POST)
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
            String pathToSaveFile = "case/" + aCase.getProject().getId() + "/" + aCase.getId() + "/" + message.getId();
            SaveFile sf = new SaveFile(pathToSaveFile, files);
            sf.saveFile();
            message.setMessagePath(MainPathEnum.mainPath + pathToSaveFile);
            messageService.updateMessage(message);
        }

        caseService.updateCase(aCase);

        return new ModelAndView("redirect:/staff-cabinet/case/" + id);
    }

    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public ModelAndView getCabinetStaff() {

        ModelAndView managerAdminCabinetStaffList = new ModelAndView("managerAdminViews/staffList");
        List<StaffInfo> StaffInfoList = staffInfoService.getAllStaffInfo();
        managerAdminCabinetStaffList.addObject("StaffInfoList", StaffInfoList);

        return managerAdminCabinetStaffList;
    }

    @RequestMapping(value = "/addNewStaff", method = RequestMethod.GET)
    public ModelAndView addNewStaff() {
        ModelAndView staffEdit = new ModelAndView("managerAdminViews/staffEdit");

        staffEdit.addObject("isNew", true);
        return staffEdit;
    }

    @RequestMapping(value = "/staffEdit/{staffId}", method = RequestMethod.GET)
    public ModelAndView managerEdit(@PathVariable int staffId) {
        ModelAndView staffEdit = new ModelAndView("managerAdminViews/staffEdit");
        User user = userService.findById(staffId);
        StaffInfo staffInfo = staffInfoService.getStaffInfo((long) staffId);

        staffEdit.addObject("user", user);
        staffEdit.addObject("staffInfo", staffInfo);
        staffEdit.addObject("isNew", false);

        return staffEdit;
    }

    @RequestMapping(value = "/saveStaff", method = RequestMethod.POST)
    public ModelAndView saveManager(@RequestParam(value = "id") String id,
                                    @RequestParam("name") String name,
                                    @RequestParam("login") String login,
                                    @RequestParam("email") String email,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("password") String password,
                                    @RequestParam("confirm_password") String confirmPassword) {

        User userStaff;

        if (id.equals("")) {
            userStaff = new User();
            userStaff.setSsoId(login);
            if (password.equals(confirmPassword)) {
                userStaff.setPassword(password);
            }

            UserProfile userProfile = new UserProfile();

            userProfile.setType(UserProfileType.STAFF.toString());
            userProfile.setId(4);

            Set<UserProfile> userProfiles = new HashSet<>();
            userProfiles.add(userProfile);

            userStaff.setUserProfiles(userProfiles);

            userService.saveUser(userStaff);

            StaffInfo staffInfo = new StaffInfo();
            staffInfo.setUser((long) userStaff.getId());
            staffInfo.setName(name);
            staffInfo.setEmail(email);
            staffInfo.setPhone(phone);
            staffInfo.setBirthday(new Date());

            Set<MessageTask> messageTasks = new HashSet<>();
            Set<GoogleCloudKey> googleCloudKeys = new HashSet<>();

            staffInfo.setMessageTasks(messageTasks);
            staffInfo.setGoogleCloudKeys(googleCloudKeys);

            staffInfoService.addStaffInfo(staffInfo);

        } else {
            userStaff = userService.findById(Integer.valueOf(id));
            userStaff.setSsoId(login);
            if (password.equals(confirmPassword)) {
                userStaff.setPassword(password);
            }
            userService.updateUser(userStaff);
            StaffInfo staffInfo = staffInfoService.getStaffInfo(Long.valueOf(id));
            staffInfo.setName(name);
            staffInfo.setEmail(email);
            staffInfo.setPhone(phone);
            staffInfoService.updateStaffInfo(staffInfo);


        }

        return new ModelAndView("redirect:/staff-cabinet/staffEdit/" + userStaff.getId());
    }

    @RequestMapping(value = "/staffDelete/{staffId}", method = RequestMethod.GET)
    public ModelAndView staffDelete(@PathVariable Long staffId) {
        System.out.println("=======delete ");

        //User manager = userService.findById(staffId);
        //userService.deleteUserBySSO(manager.getSsoId());

        StaffInfo staffInfo = staffInfoService.getStaffInfo((long) staffId);
        //staffInfoService.deleteStaffInfo(staffInfo);

        List<MessageTask> messageTaskList = messageTaskService.getAllMessageTaskByStaff(staffId);

        System.out.println("=======delete " + messageTaskList.size());

        return new ModelAndView("redirect:/staff-cabinet/staff");
    }

    @RequestMapping(value = "/task/{staffId}", method = RequestMethod.GET)
    public ModelAndView modelAndViewStaffTask(@PathVariable Long staffId) {

        ModelAndView modelAndViewStaffTask = new ModelAndView("managerAdminViews/staffTasks");

        StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);

        List<MessageTask> messageTaskList = messageTaskService.getAllMessageTaskByStaff(staffId);

        modelAndViewStaffTask.addObject("staffInfo", staffInfo);
        modelAndViewStaffTask.addObject("messageTaskList", messageTaskList);

        return modelAndViewStaffTask;
    }

    @RequestMapping(value = "/addTaskToStaff/{staffId}", method = RequestMethod.POST)
    public ModelAndView addTaskToStaff(@PathVariable Long staffId,
                                       @RequestParam("title") String title,
                                       @RequestParam("task") String task,
                                       HttpSession httpSession) {

        StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
        long userId = (Integer) httpSession.getAttribute("UserId");

        MessageTask messageTask = new MessageTask();
        messageTask.setStaffInfo(staffInfo);
        messageTask.setTitle(title);
        messageTask.setMessageText(task);
        messageTask.setDate(new Date());
        messageTask.setUserId(userId);
        messageTask.setApprove(new Boolean(false));

        messageTaskService.addMessageTask(messageTask);

        return new ModelAndView("redirect:/staff-cabinet/task/" + staffId);
    }
}
