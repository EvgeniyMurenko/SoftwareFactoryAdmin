package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.constant.StatusEnum;
import com.SoftwareFactoryAdmin.model.ManagerInfo;
import com.SoftwareFactoryAdmin.model.Project;
import com.SoftwareFactoryAdmin.model.ProjectTask;
import com.SoftwareFactoryAdmin.model.TaskMessage;
import com.SoftwareFactoryAdmin.service.*;
import com.SoftwareFactoryAdmin.util.SaveFile;
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
@RequestMapping("/project-wf")
@SessionAttributes("roles")
public class ProjectWorkFlowController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectTaskService projectTaskService;

    @Autowired
    ManagerInfoService managerInfoService;

    @Autowired
    TaskMessageService taskMessageService;

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

    @RequestMapping(value = "/start-task", method = RequestMethod.POST)
    public ModelAndView startTask (@RequestParam ("project_id") Long projectID,
                                   @RequestParam("title") String title,
                                   @RequestParam("short_description") String shortDescription,
                                   @RequestParam("full_description") String fullDescription,
                                   @RequestParam("end_date") String endDate,
                                   @RequestParam("file[]") MultipartFile[] files,
                                   HttpSession httpSession){

        Project project = projectService.getProjectById(projectID);
        Long managerID = (Long) httpSession.getAttribute("UserId");
        SaveFile saveFile = new SaveFile(files);

        ManagerInfo managerInfo = managerInfoService.getManagerInfoById(managerID);

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date endDateFormat = simpleDateFormat.parse(endDate+ ":00");

            ProjectTask projectTask = new ProjectTask(project ,title ,shortDescription , StatusEnum.OPEN.toString(), new Date(),
                                            endDateFormat, null, new ArrayList<>(),new HashSet<>() , null);




            TaskMessage taskMessage = new TaskMessage(projectTask, managerInfo.getUser() , fullDescription, new Date() , managerInfo.getName(), new ArrayList<>());



            saveFile.saveToTaskMessageFiles(taskMessage);

            List<TaskMessage> taskMessages = projectTask.getTaskMessages();
            taskMessages.add(taskMessage);

            projectTask.setTaskMessages(taskMessages);


            projectTaskService.addNewProjectTask(projectTask);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        return new ModelAndView("redirect:/project-wf/"+projectID, "isTaskStarted", "true");
    }


}
