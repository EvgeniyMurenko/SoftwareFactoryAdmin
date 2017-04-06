package com.SoftwareFactory.controller.managerAdmin;

import com.SoftwareFactory.model.*;
import com.SoftwareFactory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/staff")
@SessionAttributes("roles")
public class StaffController {

    @Autowired
    UserService userService;


    @Autowired
    StaffInfoService staffInfoService;

    @Autowired
    MessageTaskService messageTaskService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    GoogleCloudKeyService googleCloudKeyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getCabinetStaff() {

        ModelAndView managerAdminCabinetStaffList = new ModelAndView("managerAdminViews/staffList");
        List<StaffInfo> StaffInfoList = staffInfoService.getAllStaffInfo();
        managerAdminCabinetStaffList.addObject("StaffInfoList", StaffInfoList);

        return managerAdminCabinetStaffList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView addNewStaff() {
        ModelAndView staffEdit = new ModelAndView("managerAdminViews/staffEdit");

        staffEdit.addObject("isNew", true);
        return staffEdit;
    }

    @RequestMapping(value = "/{staffId}/edit", method = RequestMethod.GET)
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

        return new ModelAndView("redirect:/staff/" + userStaff.getId()+"/edit");
    }

    @RequestMapping(value = "/staffDelete/{staffId}", method = RequestMethod.GET)
    public ModelAndView staffDelete(@PathVariable Long staffId) {

        StaffInfo staffInfo = staffInfoService.getStaffInfo((long) staffId);
        //List<MessageTaskDTO> messageTaskList = new ArrayList<>(staffInfo.getMessageTaskDTOS());
        //List<GoogleCloudKey> googleCloudKeyList = new ArrayList<>(staffInfo.getGoogleCloudKeys());

        //messageTaskService.deleateAllMessageTaskByStaff(messageTaskList);
        //googleCloudKeyService.deleteAllKeysByStaff((long) staffId);

        staffInfoService.deleteStaffInfo(staffInfo);

        return new ModelAndView("redirect:/staff/");
    }

    @RequestMapping(value = "/{staffId}/tasks", method = RequestMethod.GET)
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

        ModelAndView pushNotification = new ModelAndView("redirect:/staff/" + staffId +"/tasks");

        StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
        if (staffInfo !=null) {
            long userId = (Integer) httpSession.getAttribute("UserId");

            List<String> keys = new ArrayList<>(googleCloudKeyService.findAllKeysByStaff(staffId));

            MessageTask messageTask = new MessageTask();
            messageTask.setStaffInfo(staffInfo);
            messageTask.setTitle(title);
            messageTask.setMessageText(task);
            messageTask.setDate(new Date());
            messageTask.setUserId(userId);
            messageTask.setApprove(new Boolean(false));

            if (keys.size()>0) {
                notificationService.pushNotificationToGCM(keys, messageTask.getMessageText(), messageTask.getTitle());
            }
            pushNotification.addObject("isSuccess", true);

            messageTaskService.addMessageTask(messageTask);
        }else {
            pushNotification.addObject("isFalse", true);
        }

        return pushNotification;
    }
}
