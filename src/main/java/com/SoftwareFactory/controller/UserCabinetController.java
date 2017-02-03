package com.SoftwareFactory.controller;


import com.SoftwareFactory.model.Case;
import com.SoftwareFactory.model.CustomerInfo;
import com.SoftwareFactory.model.Project;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

@Controller
/*@RequestMapping("cabinet")*/
@SessionAttributes("roles")
public class UserCabinetController {

    @Autowired
    CustomerInfoService customerInfoService;

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
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
                getCasesFromProject(project , casesToShow);
            }

        }

        //PUT OBJECTS TO MODEL
        customerCabinet.addObject("projects", projectsToShow);
        customerCabinet.addObject("cases", casesToShow);


        return customerCabinet;
}



    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project{id}", method = RequestMethod.GET)
    public String getProjectCases(@PathVariable String id) {
        System.out.print(id);

        Long projectId = Long.getLong(id);


        ModelAndView modelAndView = new ModelAndView("personalArea");


        Project project = projectService.getProjectById(projectId);


        return null;
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
