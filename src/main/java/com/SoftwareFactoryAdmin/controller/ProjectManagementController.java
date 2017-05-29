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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
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
    public ModelAndView getManagerCabinetCase() {


        ModelAndView projects = new ModelAndView("projectsList");

        List<Project> projectInfoList = projectService.getAllProjects();

        projects.addObject("projectsList", projectInfoList);

        return projects;
    }

    @RequestMapping(value = "/add-project", method = RequestMethod.GET)
    public ModelAndView addProject() {

        ModelAndView addProject = new ModelAndView("projectEdit");
        addProject.addObject("isNew", true);

        return addProject;
    }

    @RequestMapping(value = "/edit-project/{projectId}", method = RequestMethod.GET)
    public ModelAndView editProject(@PathVariable Long projectId) {

        ModelAndView editProject = new ModelAndView("projectEdit");

        Project project = projectService.getProjectById(projectId);
        User customerUser = userService.findById(project.getCustomerInfo().getId());

        editProject.addObject("isNew", false);
        editProject.addObject("project", project);
        editProject.addObject("customerUser", customerUser);

        return editProject;

    }

    @RequestMapping(value = "/view-project/{projectId}", method = RequestMethod.GET)
    public ModelAndView viewProject(@PathVariable Long projectId) {
        ModelAndView viewProject = new ModelAndView("projectView");

        Project project = projectService.getProjectById(projectId);
        ManagerInfo managerInfo = project.getManagerInfo();

        viewProject.addObject("project", project);
        viewProject.addObject("managerInfo", managerInfo);

        return viewProject;
    }


    @RequestMapping(value = "/save-new-project", method = RequestMethod.POST)
    public ModelAndView saveNewProject(@RequestParam("customerSOID") String customerSOID,
                                       @RequestParam("projectName") String projectName,
                                       @RequestParam("selectStatus") String selectStatus,
                                       @RequestParam("dateStart") String dateStart,
                                       @RequestParam("dateEnd") String dateEnd,
                                       @RequestParam("description") String description, HttpSession httpSession) {

        ModelAndView saveProject;
        System.out.printf("===================SOID " +customerSOID);
        User userCustomer = userService.findBySSO(customerSOID);
        if (userCustomer == null) {
            System.out.printf("=================== NOT FOUND USER  by SOID");
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
            }

            if (!"".equals(dateEnd)) {
                project.setStartDate(AppMethods.getDateFromString(dateEnd));
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
    public ModelAndView updateProject(@RequestParam("customerId") Long customerId,
                                      @RequestParam("idProject") Long idProject,
                                      @RequestParam("projectName") String projectName,
                                      @RequestParam("selectStatus") String selectStatus,
                                      @RequestParam("dateStart") String dateStart,
                                      @RequestParam("dateEnd") String dateEnd,
                                      @RequestParam("description") String description, HttpSession httpSession) {

        ModelAndView updateProjectView;

        User userCustomer = userService.findById(customerId);
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

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            if (!"".equals(dateStart)) {
                project.setStartDate(AppMethods.getDateFromString(dateStart));
            }

            if (!"".equals(dateEnd)) {
                project.setStartDate(AppMethods.getDateFromString(dateEnd));
            }

            projectService.updateProject(project);

            updateProjectView = new ModelAndView("redirect:/project-mm/view-project/" + idProject + "/" ,"isSuccess" , "true");
        }else {
            updateProjectView = new ModelAndView("redirect:/project-mm/");

        }

        return updateProjectView;
    }

}
