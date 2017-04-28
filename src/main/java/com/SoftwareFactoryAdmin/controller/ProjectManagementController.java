package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.model.Project;
import com.SoftwareFactoryAdmin.service.CustomerInfoService;
import com.SoftwareFactoryAdmin.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/project-mm")
@SessionAttributes("roles")
public class ProjectManagementController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getManagerCabinetCase() {


        ModelAndView projects = new ModelAndView("projectsList");

        List<Project> projectInfoList = projectService.getAllProjects();

        projects.addObject("projectsList", projectInfoList);

        return  projects;
    }

    @RequestMapping(value = "/add-project", method = RequestMethod.GET)
    public ModelAndView addProject() {


        ModelAndView addProject = new ModelAndView("addProject");


        return  addProject;
    }



}
