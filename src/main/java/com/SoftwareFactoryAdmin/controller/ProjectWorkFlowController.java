package com.SoftwareFactoryAdmin.controller;

import com.SoftwareFactoryAdmin.constant.StatusEnum;
import com.SoftwareFactoryAdmin.model.*;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/project-wf")
@SessionAttributes("roles")
public class ProjectWorkFlowController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectTaskService projectTaskService;

    @Autowired
    private TaskMessageService taskMessageService;

    @Autowired
    private StaffInfoService staffInfoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView showWorkFlow(@PathVariable(value = "id") Long id) {

        ModelAndView projectsWorkFlow = new ModelAndView("projectWorkFlow");

        projectsWorkFlow.addObject("project", projectService.getProjectById(id));

        return projectsWorkFlow;
    }


    @RequestMapping(value = "/upload-scenario", method = RequestMethod.POST)
    public ModelAndView uploadScenario(@RequestParam("project_id") Long projectID,
                                       @RequestParam("file[]") MultipartFile[] scenario) {

        Project project = projectService.getProjectById(projectID);

        if (project.getScenarioUuidName() != null) {
            SaveFile.deleteFileByName(project.getScenarioUuidName());
        }

        SaveFile saveFile = new SaveFile(scenario);

        String scenarioUuidName = saveFile.saveFileAndReturnName();

        if (scenarioUuidName != null) {

            project.setScenarioUuidName(scenarioUuidName);
            projectService.updateProject(project);

        }


        return new ModelAndView("redirect:/project-wf/" + project.getId(), "isScenarioUpload", "true");

    }

    @RequestMapping(value = "/start-new-task/{id}", method = RequestMethod.GET)
    public ModelAndView startNewTask(@PathVariable(value = "id") Long id) {

        ModelAndView startNewTask = new ModelAndView("projectTaskStart");

        startNewTask.addObject("project", projectService.getProjectById(id));

        return startNewTask;

    }

    @RequestMapping(value = "/start-task", method = RequestMethod.POST)
    public ModelAndView startTask(@RequestParam("project_id") Long projectID,
                                  @RequestParam("title") String title,
                                  @RequestParam("short_description") String shortDescription,
                                  @RequestParam("full_description") String fullDescription,
                                  @RequestParam("end_date") String endDate,
                                  @RequestParam("file[]") MultipartFile[] files,
                                  HttpSession httpSession) {

        Project project = projectService.getProjectById(projectID);
        SaveFile saveFile = new SaveFile(files);

        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date endDateFormat = simpleDateFormat.parse(endDate + ":00");

            ProjectTask projectTask = new ProjectTask(project, title, shortDescription, StatusEnum.OPEN.toString(), new Date(),
                    endDateFormat, null, new HashSet<TaskMessage>(), new HashSet<StaffInfo>(), null);

            projectTaskService.addNewProjectTask(projectTask);


            TaskMessage taskMessage = new TaskMessage(projectTask, managerInfo.getUser(), fullDescription, new Date(), managerInfo.getName(), new ArrayList<>());

            taskMessageService.addNewTaskMessage(taskMessage);

            saveFile.saveToTaskMessageFiles(taskMessage);

            taskMessageService.updateTaskMessage(taskMessage);


        } catch (ParseException e) {
            e.printStackTrace();
        }


        return new ModelAndView("redirect:/project-wf/" + projectID, "isTaskStarted", "true");
    }


    @RequestMapping(value = "/select-staff-to-task/{id}", method = RequestMethod.GET)
    public ModelAndView selectStaffToTask(@PathVariable(value = "id") Long id) {

        ModelAndView selectStaffToTask = new ModelAndView("selectStaffToTask");

        selectStaffToTask.addObject("projectTask", projectTaskService.getProjectTaskById(id));

        return selectStaffToTask;
    }


    @RequestMapping(value = "/approve-staff-to-task/{project_task_id}/{staff_id}", method = RequestMethod.GET)
    public ModelAndView selectStaffToTask(@PathVariable(value = "project_task_id") Long projectTaskID,
                                          @PathVariable(value = "staff_id") Long staffID,
                                          HttpSession httpSession) {

        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        // change status of project and set staff info
        ProjectTask projectTask = projectTaskService.getProjectTaskById(projectTaskID);

        projectTask.setStatus(StatusEnum.IN_WORK.toString());
        projectTask.setStaffInfos(null);
        projectTask.setWorkingStaffID(staffID);

        projectTaskService.updateProjectTask(projectTask);

        // add new staff history to staff info
        StaffInfo staffInfo = staffInfoService.getStaffInfoById(staffID);

        String staffHistoryText = "Was approved on task # " + projectTask.getId() + " , project # " + projectTask.getProject().getId();
        StaffHistory staffHistory = new StaffHistory(staffHistoryText, new Date(), staffInfo, managerInfo.getName(), managerInfo.getId());

        List<StaffHistory> staffHistories =  staffInfo.getStaffHistories();
        staffHistories.add(staffHistory);
        staffInfo.setStaffHistories(staffHistories);

        staffInfoService.updateStaffInfo(staffInfo);


        return new ModelAndView("redirect:/project-wf/task-management/" + projectTask.getId());
    }


    @RequestMapping(value = "/task-management/{id}", method = RequestMethod.GET)
    public ModelAndView taskManagement(@PathVariable(value = "id") Long id) {

        ModelAndView taskManagement = new ModelAndView("projectTaskManagement");

        ProjectTask projectTask = projectTaskService.getProjectTaskById(id);

        taskManagement.addObject("projectTask", projectTask);

        return taskManagement;
    }

    @RequestMapping(value = "/write-task-message" ,method = RequestMethod.POST)
    public ModelAndView writeMessage(@RequestParam("id") Long id,
                                     @RequestParam("text") String text ,
                                     @RequestParam("file[]") MultipartFile[] multipartFile,
                                     HttpSession httpSession){

        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");

        ProjectTask projectTask = projectTaskService.getProjectTaskById(id);

        TaskMessage taskMessage = new TaskMessage(projectTask, managerInfo.getUser(), text, new Date(), managerInfo.getName(), new ArrayList<>());

        taskMessageService.addNewTaskMessage(taskMessage);

        SaveFile saveFile = new SaveFile(multipartFile);
        saveFile.saveToTaskMessageFiles(taskMessage);

        taskMessageService.updateTaskMessage(taskMessage);

        return new ModelAndView("redirect:/project-wf/task-management/" + id);
    }

    @RequestMapping(value = "/reopen-task/{id}" , method = RequestMethod.GET)
    public ModelAndView reopenTask (@PathVariable("id") Long id,
                                    HttpSession httpSession){

        ManagerInfo managerInfo = (ManagerInfo) httpSession.getAttribute("managerInfo");
        ProjectTask projectTask = projectTaskService.getProjectTaskById(id);
        Long staffWorkerID = projectTask.getWorkingStaffID();

        projectTask.setStatus(StatusEnum.RE_OPEN.toString());
        projectTask.setWorkingStaffID(null);

        projectTaskService.updateProjectTask(projectTask);

        // write new staff history notice
        StaffInfo staffInfo = staffInfoService.getStaffInfoById(staffWorkerID);

        List<StaffHistory> staffHistories =staffInfo.getStaffHistories();

        String staffHistoryText = "Failed task - " +projectTask.getId() + " - " + projectTask.getTitle();

        staffHistories.add(new StaffHistory(staffHistoryText ,new Date() ,staffInfo ,managerInfo.getName(),managerInfo.getId()));

        staffInfo.setStaffHistories(staffHistories);

        staffInfoService.updateStaffInfo(staffInfo);

        return new ModelAndView("redirect:/project-wf/select-staff-to-task/" + projectTask.getId() ,"isReopen" , "true");
    }

    @RequestMapping(value = "/done-task/{id}" , method = RequestMethod.GET)
    public ModelAndView doneTask (@PathVariable("id") Long id) {

        ProjectTask projectTask = projectTaskService.getProjectTaskById(id);

        projectTask.setStatus(StatusEnum.DONE.toString());

        projectTaskService.updateProjectTask(projectTask);

        return new ModelAndView("redirect:/project-wf/task-management/"+id , "isDone" , "true");
    }
}
