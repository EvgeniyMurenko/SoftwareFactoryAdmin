package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.model.CustomerInfo;
import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.model.Project;
import com.SoftwareFactoryAdmin.model.User;
import com.SoftwareFactoryAdmin.service.CustomerInfoService;
import com.SoftwareFactoryAdmin.service.ManagerInfoService;
import com.SoftwareFactoryAdmin.service.ProjectService;
import com.SoftwareFactoryAdmin.service.UserService;
import com.SoftwareFactoryAdmin.util.AppMethods;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/project-mm")
@SessionAttributes("roles")
public class ProjectManagementController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Autowired
    CustomerInfoService customerInfoService;

    @Autowired
    ManagerInfoService managerInfoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getManagerCabinetCase(HttpSession httpSession) {

        ModelAndView projects = new ModelAndView("projectsList");

        List<Project> projectInfoList = projectService.getAllProjects();
        projects.addObject("projectsList", projectInfoList);

        Long managerId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);
        projects.addObject("managerInfo", managerInfo);

        return projects;
    }

    @RequestMapping(value = "/add-project/{customerId}", method = RequestMethod.GET)
    public ModelAndView addProject(@PathVariable Long customerId, HttpSession httpSession) {
        System.out.println("=============== customer id " + customerId);

        User customerUser = userService.findById(customerId);

        ModelAndView addProject = new ModelAndView("projectEdit");

        addProject.addObject("isNew", true);
        addProject.addObject("customerUser", customerUser);

        Long managerId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);
        addProject.addObject("managerInfo", managerInfo);

        return addProject;
    }

    @RequestMapping(value = "/edit-project/{projectId}", method = RequestMethod.GET)
    public ModelAndView editProject(@PathVariable Long projectId, HttpSession httpSession) {

        ModelAndView editProject = new ModelAndView("projectEdit");

        Project project = projectService.getProjectById(projectId);
        User customerUser = userService.findById(project.getCustomerInfo().getId());

        editProject.addObject("isNew", false);
        editProject.addObject("project", project);
        editProject.addObject("customerUser", customerUser);

        Long managerId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);
        editProject.addObject("managerInfo", managerInfo);

        return editProject;

    }

    @RequestMapping(value = "/view-project/{projectId}", method = RequestMethod.GET)
    public ModelAndView viewProject(@PathVariable Long projectId, HttpSession httpSession) {
        ModelAndView viewProject = new ModelAndView("projectView");

        Project project = projectService.getProjectById(projectId);
        ManagerInfo managerInfoByProject = project.getManagerInfo();

        viewProject.addObject("project", project);
        viewProject.addObject("managerInfoByProject", managerInfoByProject);

        Long managerId = (Long) httpSession.getAttribute("UserId");
        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);
        viewProject.addObject("managerInfo", managerInfo);

        return viewProject;
    }


    @RequestMapping(value = "/save-new-project", method = RequestMethod.POST)
    public ModelAndView saveNewProject(@RequestParam("customerSoid") String customerSOID,
                                       @RequestParam("projectName") String projectName,
                                       @RequestParam("selectStatus") String selectStatus,
                                       @RequestParam("dateStart") String dateStart,
                                       @RequestParam("dateEnd") String dateEnd,
                                       @RequestParam("description") String description, HttpSession httpSession,
                                       @RequestParam("pmName") String pmName,
                                       @RequestParam("pmEmail") String pmEmail,
                                       @RequestParam("pmPhone") String pmPhone) {

        ModelAndView saveProject;
        User userCustomer = userService.findBySSO(customerSOID);
        if (userCustomer == null) {
           return new ModelAndView("redirect:/project-mm/");
        }
        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(userCustomer.getId());

        if (customerInfo != null) {

            Long managerId = (Long) httpSession.getAttribute("UserId");
            ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

            Project project = new Project();

            project.setProjectName(projectName);
            project.setCustomerInfo(customerInfo);
            project.setCreateDate(new Date());
            project.setStatus(selectStatus);
            project.setDescription(description);
            project.setManagerInfo(managerInfo);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            if (!"".equals(dateStart)) {
                project.setStartDate(AppMethods.getDateFromString(dateStart));
            }else{
                project.setStartDate(new Date());
            }

            if (!"".equals(dateEnd)) {
                project.setEndDate(AppMethods.getDateFromString(dateEnd));
            }

            if (!"".equals(pmName)){
                project.setPmName(pmName);
            }else {
                project.setPmName("-");
            }

            if (!"".equals(pmEmail)){
                project.setPmEmail(pmEmail);
            }else {
                project.setPmEmail("-");
            }

            if (!"".equals(pmPhone)){
                project.setPmPhone(pmPhone);
            }else {
                project.setPmPhone("-");
            }

            projectService.addNewProject(project);

            saveProject = new ModelAndView("redirect:/project-mm/view-project/" + project.getId() + "/","isSuccess" , "true");
        } else {
            System.out.printf("=================== NOT FOUND CUSTOMER  by SOID");
            saveProject = new ModelAndView("redirect:/project-mm/");
        }
        return saveProject;
    }

    @RequestMapping(value = "/update-project", method = RequestMethod.POST)
    public ModelAndView updateProject(@RequestParam("customerSOID") String customerSOID,
                                      @RequestParam("idProject") Long idProject,
                                      @RequestParam("projectName") String projectName,
                                      @RequestParam("selectStatus") String selectStatus,
                                      @RequestParam("dateStart") String dateStart,
                                      @RequestParam("dateEnd") String dateEnd,
                                      @RequestParam("description") String description, HttpSession httpSession,
                                      @RequestParam("pmName") String pmName,
                                      @RequestParam("pmEmail") String pmEmail,
                                      @RequestParam("pmPhone") String pmPhone) {

        ModelAndView updateProjectView;

        User userCustomer = userService.findBySSO(customerSOID);
        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(userCustomer.getId());


        Project project = projectService.getProjectById(idProject);
        if (userCustomer != null && project != null && project.getCustomerInfo().getId() == customerInfo.getId()){

            Long managerId = (Long) httpSession.getAttribute("UserId");
            ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerId);

            project.setProjectName(projectName);
            project.setCustomerInfo(customerInfo);
            project.setCreateDate(new Date());
            project.setStatus(selectStatus);
            project.setDescription(description);
            project.setManagerInfo(managerInfo);

            if (!"".equals(dateStart)) {
                project.setStartDate(AppMethods.getDateFromString(dateStart));
            }

            if (!"".equals(dateEnd)) {
                project.setEndDate(AppMethods.getDateFromString(dateEnd));
            } else {
                project.setEndDate(null);
            }

            project.setPmName(pmName);
            project.setPmEmail(pmEmail);
            project.setPmPhone(pmPhone);


            projectService.updateProject(project);

            updateProjectView = new ModelAndView("redirect:/project-mm/view-project/" + idProject + "/" ,"isSuccess" , "true");
        }else {
            updateProjectView = new ModelAndView("redirect:/project-mm/");

        }

        return updateProjectView;
    }

    @ResponseBody
    @RequestMapping(value = "/show-customer-info", method = RequestMethod.GET)
    public String updateProject(@RequestParam("customerId") Long customerId){
        System.out.println("==============start");

        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(customerId);

        JSONObject myJsonObj = new JSONObject();

        myJsonObj.append("customerSoid", customerInfo.getUser().getSsoId());
        myJsonObj.append("customerCompany", AppMethods.changeNull(customerInfo.getCompany()));
        myJsonObj.append("customerWebsite", AppMethods.changeNull(customerInfo.getWebsite()));
        myJsonObj.append("customerName", AppMethods.changeNull(customerInfo.getName()));
        myJsonObj.append("customerEmail", AppMethods.changeNull(customerInfo.getEmail()));
        myJsonObj.append("customerPhone", AppMethods.changeNull(customerInfo.getPhone()));
        if (customerInfo.isStandardAccount()){
            myJsonObj.append("customerAccount", "Standart");
        }else {
            myJsonObj.append("customerAccount", "Temporal");
        }
        myJsonObj.append("customerDirectorsName", AppMethods.changeNull(customerInfo.getDirectorsName()));
        myJsonObj.append("customerDirectorsEmail", AppMethods.changeNull(customerInfo.getDirectorsEmail()));
        myJsonObj.append("customerDirectorsPhone", AppMethods.changeNull(customerInfo.getDirectorsPhone()));
        myJsonObj.append("customerCompanyType", AppMethods.changeNull(customerInfo.getCompanyType()));
        myJsonObj.append("customerAddress", AppMethods.changeNull(customerInfo.getAddress()));

        return myJsonObj.toString();
    }

}
