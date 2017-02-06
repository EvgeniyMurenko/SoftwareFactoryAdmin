package com.SoftwareFactory.controller;


import com.SoftwareFactory.comparator.MessageComparator;
import com.SoftwareFactory.model.Case;
import com.SoftwareFactory.model.CustomerInfo;
import com.SoftwareFactory.model.Message;
import com.SoftwareFactory.model.Project;
import com.SoftwareFactory.service.CaseService;
import com.SoftwareFactory.service.CustomerInfoService;
import com.SoftwareFactory.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/cabinet")
@SessionAttributes("roles")
public class UserCabinetController {

    @Autowired
    CustomerInfoService customerInfoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getCustomerCabinet(HttpSession httpSession) {

        System.out.println("cabinet");

        ModelAndView customerCabinet = new ModelAndView("personalArea");


        Long userId = new Long((Integer) httpSession.getAttribute("UserId"));
        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(userId);


        Set<Project> projectsToShow = customerInfo.getProjects();
        ArrayList<Case> casesToShow = new ArrayList<>();


        if (projectsToShow != null) {
            System.out.println("add projects");


            // GET PROJECTS FROM CUSTOMER
            Iterator<Project> projectIterator = projectsToShow.iterator();
            while (projectIterator.hasNext()) {
                Project project = projectIterator.next();
                getCasesFromProject(project, casesToShow);
            }

        }

        //PUT OBJECTS TO MODEL
        customerCabinet.addObject("projects", projectsToShow);
        customerCabinet.addObject("cases", casesToShow);


        return customerCabinet;
    }


    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public ModelAndView getProjectCases(@PathVariable Long id, HttpSession httpSession) {

        System.out.print("ID" + id);


        Long userId = new Long((Integer) httpSession.getAttribute("UserId"));
        /*Long projectId = */

        System.out.print("Project id " + id + "userId " + userId);


        ModelAndView customerCabinetShowOneProject = new ModelAndView("personalArea");

        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(userId);
        System.out.println("STEP1");
        Set<Project> projectsToShow = customerInfo.getProjects();
        System.out.println("STEP2");
        ArrayList<Case> casesToShow = new ArrayList<>();
        System.out.println("STEP3");

        Project project = projectService.getProjectById(id);
        System.out.println("STEP4");
        getCasesFromProject(project, casesToShow);
        System.out.println("STEP6");


        //PUT OBJECTS TO MODEL
        customerCabinetShowOneProject.addObject("projects", projectsToShow);
        customerCabinetShowOneProject.addObject("cases", casesToShow);

        System.out.print("READY");

        return customerCabinetShowOneProject;
    }

    @Autowired
    CaseService caseService;

    @RequestMapping(value = "/case/{id}", method = RequestMethod.GET)
    public ModelAndView caseChatController(@PathVariable Long id, HttpSession httpSession) {

        ModelAndView caseChat = new ModelAndView("chat");

        System.out.print("ID" + id);
        Long userId = new Long((Integer) httpSession.getAttribute("UserId"));

        Case aCase = caseService.getCaseById(id);
        Set<Message> messagesUnsorted = aCase.getMessages();
        List<Message> messagesSorted = new ArrayList<>(messagesUnsorted);

        MessageComparator messageComparator = new MessageComparator();


        for (Message m : messagesSorted){
            System.out.println(m.getMessageTime().toString() + m.getMessageTime().toLocalDate().);
        }

        System.out.println("------------------------");
        Collections.sort(messagesSorted, messageComparator);

        for (Message m : messagesSorted){
            System.out.println(m.getMessageTime().toString());
        }


        caseChat.addObject("messagesSorted", messagesSorted);

        return caseChat;
    }


    //PUT ALL CASES FROM PROJECTS TO ONE ARRAY;
    private void getCasesFromProject(Project project, ArrayList<Case> casesToShow) {

        Set<Case> cases = project.getCases();

        if (cases != null) {
            Iterator<Case> caseIterator = cases.iterator();
            while (caseIterator.hasNext()) {
                Case aCase = caseIterator.next();
                casesToShow.add(aCase);
            }
        }
    }
}
