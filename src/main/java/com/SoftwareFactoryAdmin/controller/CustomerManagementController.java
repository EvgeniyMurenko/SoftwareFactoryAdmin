package com.SoftwareFactoryAdmin.controller;


import com.SoftwareFactoryAdmin.constant.ProjectEnum;
import com.SoftwareFactoryAdmin.constant.StatusEnum;
import com.SoftwareFactoryAdmin.model.*;
import com.SoftwareFactoryAdmin.service.CustomerInfoService;
import com.SoftwareFactoryAdmin.service.EstimateService;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import com.SoftwareFactoryAdmin.service.UserService;
import com.SoftwareFactoryAdmin.util.AppMethods;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/customer-mm")
@SessionAttributes("roles")
public class CustomerManagementController {

    @Autowired
    CustomerInfoService customerInfoService;

    @Autowired
    EstimateService estimateService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView customerList() {

        ModelAndView customersList = new ModelAndView("customersList");

        List<CustomerInfo> customerInfoList = customerInfoService.getAllCustomerInfos();

        customersList.addObject("customersList", customerInfoList);

        return customersList;
    }


    @RequestMapping(value = "/add-customer", method = RequestMethod.GET)
    public ModelAndView addNotice() {

        ModelAndView addCustomer = new ModelAndView("customersEdit");

        addCustomer.addObject("isNew", true);

        return addCustomer;
    }


    @RequestMapping(value = "/edit-customer/{customerId}", method = RequestMethod.GET)
    public ModelAndView editCustomer(@PathVariable Long customerId) {

        ModelAndView editCustomer = new ModelAndView("customersEdit");

        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(customerId);

        editCustomer.addObject("isNew", false);
        editCustomer.addObject("customerInfo", customerInfo);

        return editCustomer;
    }


    @RequestMapping(value = "/delete-customer/{customerId}", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable Long customerId) {

        Estimate estimate = estimateService.findEstimateByCustomerInfoId(customerId);
        estimate.setCustomerInfo(null);
        estimateService.updateEstimate(estimate);

        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(customerId);
        customerInfoService.deleteCustomerInfo(customerInfo);

        userService.deleteUserById(customerId);

        return new ModelAndView("redirect:/customer-mm/");
    }

    @Autowired
    UserService userService;

    @Autowired
    ManagerInfoService managerInfoService;

    @RequestMapping(value = "/save-new-customer", method = RequestMethod.POST)
    public ModelAndView saveNewCustomer(@RequestParam("name") String name,
                                        @RequestParam("email") String email,
                                        @RequestParam("phone") String phone,
                                        @RequestParam("company") String company,
                                        @RequestParam("site_link") String website,
                                        @RequestParam("password") String password,
                                        @RequestParam("confirm_password") String confirmPassword, HttpSession httpSession) {

        if (!password.equals(confirmPassword))
            return new ModelAndView("redirect:/customer-mm/add-customer", "isPasswordError", "true");

        User customerUser = userService.createCustomerUser(password);

        CustomerInfo customerInfo = new CustomerInfo(customerUser.getId(), customerUser, name, company, phone, email, website, true , true ,"","","","","",new Date());
        customerInfoService.addNewCustomerInfo(customerInfo);

        CustomerInfo customerInfoCreated = customerInfoService.getCustomerInfoById(customerInfo.getId());


        Long managerId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

        //CREATE #$GENERAL PROJECT FOR CUSTOMER
        Project projectNormal = new Project(ProjectEnum.projectNameNormal.getDbValue(), new Date(), StatusEnum.OPEN.toString(), customerInfo,
                new HashSet<>(), "test", new Date(), null, "Default Normal project", managerInfo, "", "", "");
        Project projectEstimate = new Project(ProjectEnum.projectNameEstimate.getDbValue(), new Date(), StatusEnum.OPEN.toString(), customerInfo,
                new HashSet<>(), "test", new Date(), null, "Default Estimate project", managerInfo, "", "", "");


        ArrayList<Project> projectsToAdd = new ArrayList<>();
        projectsToAdd.add(projectNormal);
        projectsToAdd.add(projectEstimate);
        customerInfoCreated.setProjects(projectsToAdd);

        customerInfoService.updateCustomerInfo(customerInfoCreated);

        return new ModelAndView("redirect:/customer-mm/edit-customer/" + customerInfoCreated.getId(), "isEditCreateSuccess", "true");
    }

    @RequestMapping(value = "/update-customer", method = RequestMethod.POST)
    public ModelAndView updateCustomer(@RequestParam("id") Long id,
                                       @RequestParam("name") String name,
                                       @RequestParam("email") String email,
                                       @RequestParam("phone") String phone,
                                       @RequestParam("company") String company,
                                       @RequestParam("site_link") String website,
                                       @RequestParam("password") String password,
                                       @RequestParam("confirm_password") String confirmPassword,
                                       @RequestParam("account_type") String accountType,
                                       @RequestParam("directors_name") String directorsName,
                                       @RequestParam("directors_email") String directorsEmail,
                                       @RequestParam("directors_phone") String directorsPhone,
                                       @RequestParam("company_type") String companyType,
                                       @RequestParam("address") String address,
                                       HttpSession httpSession) {


        if (!password.equals(confirmPassword) && "".equals(password) && !"".equals(confirmPassword))
            return new ModelAndView("redirect:/customer-mm/edit-customer/" + id, "isPasswordError", "true");

        Long managerId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);
        User user = userService.findById(id);

        customerInfoService.updateCustomerInfoWithParameters(id, user, managerInfo, password, directorsName, company, directorsEmail, directorsPhone, companyType, address, website, name, email, phone, accountType);

        return new ModelAndView("redirect:/customer-mm/edit-customer/" + id, "isEditCreateSuccess", "true");
    }

    @RequestMapping(value = "/history/{id}", method = RequestMethod.GET)
    public ModelAndView customerHistory(@PathVariable Long id) {

        ModelAndView customerHistory = new ModelAndView("customerHistory");

        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(id);
        customerHistory.addObject("customerInfo", customerInfo);

        return customerHistory;
    }

    @RequestMapping(value = "/add-review", method = RequestMethod.POST)
    public ModelAndView addReview(@RequestParam("id") Long id,
                                  @RequestParam("description") String description,
                                  HttpSession httpSession) {

        if (!"".equals(description)) {

            CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(id);
            Long managerId = (Long) httpSession.getAttribute("UserId");
            ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

            List<CustomerHistory> customerHistories = customerInfo.getCustomerHistories();

            String historyText = "New review: " + description;
            CustomerHistory customerHistory = new CustomerHistory(historyText, new Date(), customerInfo, managerInfo.getName(), managerId);
            customerHistories.add(customerHistory);
            customerInfo.setCustomerHistories(customerHistories);

            customerInfoService.updateCustomerInfo(customerInfo);
            return new ModelAndView("redirect:/customer-mm/history/" + id, "isUpdated", "true");

        }

        return new ModelAndView("redirect:/membership-mm/history/" + id);
    }

    @ResponseBody
    @RequestMapping(value = "/show-customer-project", method = RequestMethod.GET)
    public String returnValues(@RequestParam("index") long index) {

        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(index);

        JSONObject myJsonObj = new JSONObject();

        StringBuilder stringBuilderModalBody = new StringBuilder();
        StringBuilder stringBuilderModalButton = new StringBuilder();
        String string = "<a href=\"/project-mm/add-project/"+customerInfo.getId()+"/\"";
        string+= "class=\"btn btn-success\">Add new project</a>";

        stringBuilderModalButton.append(string);
        stringBuilderModalButton.append("<button class=\"btn btn-info\" type=\"button\" data-dismiss=\"modal\">Close</button>");


        for (Project project : customerInfo.getProjects()) {

            String projectName = "";
            if (!"".equals(project.getProjectName())) projectName = project.getProjectName();
            if (projectName.equals(ProjectEnum.projectNameNormal.getDbValue())) {
                projectName = ProjectEnum.projectNameNormal.getValue();
            } else if (projectName.equals(ProjectEnum.projectNameEstimate.getDbValue())) {
                projectName = ProjectEnum.projectNameEstimate.getValue();
            }

            stringBuilderModalBody.append("<tr>");

            stringBuilderModalBody.append("<td>" + projectName + "</td>");
            stringBuilderModalBody.append("<td>" + changeDateNull(project.getStartDate()) + "</td>");
            stringBuilderModalBody.append("<td>" + changeDateNull(project.getEndDate()) + "</td>");
            stringBuilderModalBody.append("<td>" + AppMethods.changeNull(project.getPmName()) + "</td>");
            stringBuilderModalBody.append("<td>" + AppMethods.changeNull(project.getPmEmail()) + "</td>");
            stringBuilderModalBody.append("<td>" + AppMethods.changeNull(project.getPmPhone()) + "</td>");

            stringBuilderModalBody.append("</tr>");
        }

        String customerSoid = "<input type=\"hidden\" name=\"customerSoid\" value=\""+customerInfo.getUser().getSsoId()+"\"/>";

        myJsonObj.append("stringBuilder", stringBuilderModalBody);
        myJsonObj.append("stringBuilderModalButtonAdd", stringBuilderModalButton);
        myJsonObj.append("customerSoid_json", "All Project :: "+customerInfo.getUser().getSsoId());
        myJsonObj.append("customerSoid", customerSoid);

        return myJsonObj.toString();

    }

    private String changeDateNull(Date data){
        SimpleDateFormat dateFormatStartEnd = new SimpleDateFormat("yyyy-MM-dd");
        String value= "-";
        if (data == null) {
            return value;
        } else {
            return dateFormatStartEnd.format(data);
        }
    }

}