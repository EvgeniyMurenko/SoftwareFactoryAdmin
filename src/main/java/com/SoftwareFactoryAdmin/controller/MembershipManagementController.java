package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.model.*;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import com.SoftwareFactoryAdmin.service.StaffHistoryService;
import com.SoftwareFactoryAdmin.service.StaffInfoService;
import com.SoftwareFactoryAdmin.service.UserService;
import com.SoftwareFactoryAdmin.util.AppMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/membership-mm")
@SessionAttributes("roles")
public class MembershipManagementController {

    @Autowired
    StaffInfoService staffInfoService;

    @Autowired
    UserService userService;

    @Autowired
    ManagerInfoService managerInfoService;

    @Autowired
    StaffHistoryService staffHistoryService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView customerList() {

        ModelAndView staffList = new ModelAndView("staffList");

        List<StaffInfo> staffInfoList = staffInfoService.getAllStaffInfos();

        staffList.addObject("staffList", staffInfoList);

        return staffList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView addNewStaff() {
        ModelAndView staffEdit = new ModelAndView("staffEdit");

        staffEdit.addObject("isNew", true);
        return staffEdit;
    }

    @RequestMapping(value = "/edit/{staffId}", method = RequestMethod.GET)
    public ModelAndView managerEdit(@PathVariable Long staffId) {

        ModelAndView staffEdit = new ModelAndView("staffEdit");
        User user = userService.findById(staffId);
        StaffInfo staffInfo = staffInfoService.getStaffInfoById(staffId);

        staffEdit.addObject("user", user);
        staffEdit.addObject("staffInfo", staffInfo);
        staffEdit.addObject("isNew", false);

        return staffEdit;
    }

    @RequestMapping(value = "/saveStaff", method = RequestMethod.POST)
    public ModelAndView saveStaff(@RequestParam("name") String name,
                                  @RequestParam("birth_date") String birthDate,
                                  @RequestParam("email") String email,
                                  @RequestParam("phone") String phone,
                                  @RequestParam("password") String password,
                                  @RequestParam("confirm_password") String confirmPassword,
                                  HttpSession httpSession) {

        if (!password.equals(confirmPassword))
            return new ModelAndView("redirect:/membership-mm/create", "isPasswordError", "true");

        Long managerId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

        User userStaff = userService.createStaffUser(password);

        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setId(userStaff.getId());
        staffInfo.setName(name);
        staffInfo.setBirthDate(AppMethods.getDateFromString(birthDate));
        staffInfo.setCreationDate(new Date());
        staffInfo.setEmail(email);
        staffInfo.setPhone(phone);


        List<StaffHistory> staffHistories = new ArrayList<>();
        staffHistories.add(new StaffHistory("Staff was created", new Date(), staffInfo, managerInfo.getName(), managerId));
            /*Set<GoogleCloudKey> googleCloudKeys = new HashSet<>();*/

        staffInfo.setStaffHistories(staffHistories);

        staffInfoService.addNewStaffInfo(staffInfo);

        return new ModelAndView("redirect:/membership-mm/edit/" + userStaff.getId(), "isCreateUpdateSuccess", "true");
    }

    @RequestMapping(value = "/updateStaff", method = RequestMethod.POST)
    public ModelAndView saveStaff(@RequestParam(value = "id") Long id,
                                  @RequestParam("name") String name,
                                  @RequestParam("birth_date") String birthDate,
                                  @RequestParam("email") String email,
                                  @RequestParam("phone") String phone,
                                  @RequestParam("password") String password,
                                  @RequestParam("confirm_password") String confirmPassword,
                                  @RequestParam("rating") int rating,
                                  @RequestParam("android") int android,
                                  @RequestParam("ios") int iOs,
                                  @RequestParam("java") int java,
                                  @RequestParam("php") int php,
                                  @RequestParam("javascript") int javascript,
                                  @RequestParam("c_sharp") int cSharp,
                                  @RequestParam("c_plus_plus") int cPlusPlus,
                                  @RequestParam("frontend") int frontend,
                                  @RequestParam("design") int design,
                                  HttpSession httpSession) {

        System.out.print("rating " + rating);
        if (!password.equals(confirmPassword))
            return new ModelAndView("redirect:/membership-mm/create", "isPasswordError", "true");

        User userStaff = userService.findById(id);
        Long managerId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

        staffInfoService.updateStaffInfoWithParameters(id, userStaff, managerInfo, password, name,
                phone, email, birthDate, rating, android,
                iOs, java, php, javascript, cSharp, cPlusPlus, frontend, design);


        return new ModelAndView("redirect:/membership-mm/edit/" + userStaff.getId(), "isCreateUpdateSuccess", "true");
    }

    @RequestMapping(value = "/history/{staffId}", method = RequestMethod.GET)
    public ModelAndView viewHistory(@PathVariable Long staffId) {
        ModelAndView staffHistory = new ModelAndView("staffHistory");

        StaffInfo staffInfo = staffInfoService.getStaffInfoById(staffId);
        staffHistory.addObject("staffInfo", staffInfo);

        return staffHistory;
    }


    @RequestMapping(value = "/staffDelete/{staffId}", method = RequestMethod.GET)
    public ModelAndView staffDelete(@PathVariable Long staffId) {

        StaffInfo staffInfo = staffInfoService.getStaffInfoById(staffId);

        //List<GoogleCloudKey> googleCloudKeyList = new ArrayList<>(staffInfo.getGoogleCloudKeys());
        //googleCloudKeyService.deleteAllKeysByStaff((long) staffId);

        userService.deleteUserById(staffId);
        staffInfoService.deleteStaffInfo(staffInfo);

        return new ModelAndView("redirect:/membership-mm/");
    }
}

