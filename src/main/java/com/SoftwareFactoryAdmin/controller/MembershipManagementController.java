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
    private StaffInfoService staffInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private ManagerInfoService managerInfoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView customerList(HttpSession session) {

        if (session.getAttribute("managerInfo") == null){
            return new ModelAndView("redirect:/main/");
        }



        ModelAndView staffList = new ModelAndView("staffList");

        staffList.addObject("staffList", staffInfoService.findAllWhereStaffIsNotDelete());

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
        staffInfo.setRating(0d);

        List<StaffHistory> staffHistories = new ArrayList<>();
        staffHistories.add(new StaffHistory("Staff was created", new Date(), staffInfo, managerInfo.getName(), managerId));

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
                                  @RequestParam("android") int android,
                                  @RequestParam("ios") int iOs,
                                  @RequestParam("iot") int iot,
                                  @RequestParam("java") int java,
                                  @RequestParam("php") int php,
                                  @RequestParam("javascript") int javascript,
                                  @RequestParam("c_sharp") int cSharp,
                                  @RequestParam("c_plus_plus") int cPlusPlus,
                                  @RequestParam("frontend") int frontend,
                                  @RequestParam("design") int design,
                                  HttpSession httpSession) {


        if (!password.equals(confirmPassword))
            return new ModelAndView("redirect:/membership-mm/edit/"+id, "isPasswordError", "true");

        User userStaff = userService.findById(id);
        Long managerId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

        staffInfoService.updateStaffInfoWithParameters(id, userStaff, managerInfo, password, name,
                phone, email, birthDate, android,
                iOs, iot, java, php, javascript, cSharp, cPlusPlus, frontend, design);


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

        User customerUser = userService.findById(staffId);
        customerUser.setDelete(true);
        userService.updateUser(customerUser);

        return new ModelAndView("redirect:/membership-mm/");
    }


    @RequestMapping(value = "/update-rating", method = RequestMethod.POST)
    public ModelAndView updateRating(@RequestParam("id") Long id,
                                     @RequestParam("rating") int rating,
                                     HttpSession httpSession) {

        StaffInfo staffInfo = staffInfoService.getStaffInfoById(id);
        Long managerId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

        if (rating != 0) {
            Double newRating;
            if (staffInfo.getRating() == 0) {
                newRating = (double) rating;
            } else {
                newRating = Math.floor((staffInfo.getRating() + rating) / 2 * 100) / 100;
            }
            List<StaffHistory> staffHistories = staffInfo.getStaffHistories();

            String historyText = "rating changed from - " + staffInfo.getRating() + " to  " + newRating + "<br>";
            StaffHistory staffHistory = new StaffHistory(historyText, new Date(), staffInfo, managerInfo.getName(), managerId);
            staffHistories.add(staffHistory);
            staffInfo.setStaffHistories(staffHistories);
            staffInfo.setRating(newRating);

            staffInfoService.updateStaffInfo(staffInfo);
            return new ModelAndView("redirect:/membership-mm/history/" + id, "isUpdated", "true");
        }

        return new ModelAndView("redirect:/membership-mm/history/" + id);
    }

    @RequestMapping(value = "/add-review", method = RequestMethod.POST)
    public ModelAndView addReview(@RequestParam("id") Long id,
                                  @RequestParam("description") String description,
                                  HttpSession httpSession) {

        if (!"".equals(description)) {
            StaffInfo staffInfo = staffInfoService.getStaffInfoById(id);
            Long managerId = (Long) httpSession.getAttribute("UserId");
            ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

            List<StaffHistory> staffHistories = staffInfo.getStaffHistories();

            String historyText = "New review: " + description;
            StaffHistory staffHistory = new StaffHistory(historyText, new Date(), staffInfo, managerInfo.getName(), managerId);
            staffHistories.add(staffHistory);
            staffInfo.setStaffHistories(staffHistories);

            staffInfoService.updateStaffInfo(staffInfo);
            return new ModelAndView("redirect:/membership-mm/history/" + id, "isUpdated", "true");
        }
        return new ModelAndView("redirect:/membership-mm/history/" + id);
    }
}

