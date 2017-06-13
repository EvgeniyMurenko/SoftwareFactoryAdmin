package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.model.Project;
import com.SoftwareFactoryAdmin.service.ProjectService;
import com.SoftwareFactoryAdmin.util.SaveFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/project-wf")
@SessionAttributes("roles")
public class ProjectWorkFlow {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView showWorkFlow(@PathVariable(value = "id") Long id) {

        ModelAndView projectsWorkFlow = new ModelAndView("projectWorkFlow");

        Project project = projectService.getProjectById(id);

        projectsWorkFlow.addObject("project", project);

        return projectsWorkFlow;
    }


    @RequestMapping(value = "/upload-scenario", method = RequestMethod.POST)
    public ModelAndView uploadScenario (@RequestParam("project_id") Long projectID,
                                        @RequestParam("file[]") MultipartFile[] scenario) {

        Project project = projectService.getProjectById(projectID);

        if (project.getScenarioUuidName() != null){
            SaveFile.deleteFileByName(project.getScenarioUuidName());
        }

        SaveFile saveFile = new SaveFile(scenario);

        String scenarioUuidName = saveFile.saveFileAndReturnName();

        if (scenarioUuidName != null){

            project.setScenarioUuidName(scenarioUuidName);
            projectService.updateProject(project);

        }


        return new ModelAndView("redirect:/project-wf/"+project.getId() ,"isScenarioUpload", "true");

    }

    @RequestMapping(value = "/start-new-task/{id}", method = RequestMethod.GET)
    public ModelAndView startNewTask(@PathVariable(value = "id") Long id) {

        ModelAndView startNewTask = new ModelAndView("projectTaskStart");

        Project project = projectService.getProjectById(id);

        startNewTask.addObject("project", project);

        return startNewTask;

    }


}
