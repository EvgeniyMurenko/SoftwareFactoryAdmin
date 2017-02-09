
package com.SoftwareFactory.controller;


import com.SoftwareFactory.comparator.CaseByStatusAndDateComparator;
import com.SoftwareFactory.comparator.MessageByDateComparator;
import com.SoftwareFactory.comparator.ProjectByDateComparator;
import com.SoftwareFactory.constant.MessageEnum;
import com.SoftwareFactory.model.*;
import com.SoftwareFactory.service.CaseService;
import com.SoftwareFactory.service.CustomerInfoService;
import com.SoftwareFactory.service.ProjectService;
import com.SoftwareFactory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

        //SORT PROJECT & CASE
        List<Project> sortedProjectListToShow = new ArrayList<>(projectsToShow);
        Collections.sort(sortedProjectListToShow, new ProjectByDateComparator());

        Collections.sort(casesToShow, new CaseByStatusAndDateComparator());

        //PUT OBJECTS TO MODEL
        customerCabinet.addObject("projects", sortedProjectListToShow);
        customerCabinet.addObject("cases", casesToShow);


        return customerCabinet;
    }


    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public ModelAndView getProjectCases(@PathVariable Long id, HttpSession httpSession) {

        Long userId = new Long((Integer) httpSession.getAttribute("UserId"));
        System.out.print("Project id " + id + "userId " + userId);

        // GET CASES FROM PROJECT BY ID
        ModelAndView customerCabinetShowOneProject = new ModelAndView("personalArea");

        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(userId);

        Set<Project> projectsToShow = customerInfo.getProjects();

        ArrayList<Case> casesToShow = new ArrayList<>();

        Project project = projectService.getProjectById(id);
        getCasesFromProject(project, casesToShow);

        List<Project> sortedProjectListToShow = new ArrayList<>(projectsToShow);

        Collections.sort(casesToShow, new CaseByStatusAndDateComparator());

        //PUT OBJECTS TO MODEL
        customerCabinetShowOneProject.addObject("projects", sortedProjectListToShow);
        customerCabinetShowOneProject.addObject("cases", casesToShow);


        System.out.print("READY");

        return customerCabinetShowOneProject;
    }


    @Autowired
    CaseService caseService;


    @RequestMapping(value = "/case/{id}", method = RequestMethod.GET)
    public ModelAndView caseChatController(@PathVariable Long id, HttpSession httpSession) {

        ModelAndView caseChat = new ModelAndView("chat");

        // GET MESSAGE FROM CASE BY ID
        Case aCase = caseService.getCaseById(id);
        Set<Message> messagesUnsorted = aCase.getMessages();
        List<Message> messagesSorted = new ArrayList<>(messagesUnsorted);

        MessageByDateComparator messageByDateComparator = new MessageByDateComparator();

        // SORT BY DATE
        Collections.sort(messagesSorted, messageByDateComparator);

        //PUT OBJECTS TO MODEL
        caseChat.addObject("messagesSorted", messagesSorted);
        caseChat.addObject("caseId", id);

        return caseChat;
    }

    @Autowired
    UserService userService;



    @RequestMapping (value = "/case/{id}/print_message", method = RequestMethod.POST)
    public ModelAndView casePrintMessageController( @PathVariable Long id, @RequestParam("message") String messageText,
                                                   /*@RequestParam("file") MultipartFile  file, */HttpSession httpSession){

        // GET
        Case aCase = caseService.getCaseById(id);
        int userId = (Integer) httpSession.getAttribute("UserId");
        User currentUser = userService.findById(userId);

        // CREATE MESSAGE
        Message message = new Message();
        message.setaCase(aCase);

        message.setUser(currentUser);
        message.setMessageTime(new Date());
        message.setMessageText(messageText);
        message.setIsRead(MessageEnum.READ.toString());


        // SAVE MESSAGE TO CASE
        Set <Message> messages = aCase.getMessages();
        messages.add(message);
        aCase.setMessages(messages);
        caseService.updateCase(aCase);


        // REDIRECT TO CHAT
        String redirectLink = "redirect:/cabinet/case/" + id;

        return new ModelAndView(redirectLink);
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