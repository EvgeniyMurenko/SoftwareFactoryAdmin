package com.SoftwareFactory.controller;

import com.SoftwareFactory.comparator.EstimateByDateComparator;
import com.SoftwareFactory.model.Estimate;
import com.SoftwareFactory.model.User;
import com.SoftwareFactory.model.UserProfile;
import com.SoftwareFactory.service.EstimateService;
import com.SoftwareFactory.service.MailService;
import com.SoftwareFactory.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.*;
import java.util.Date;


@Controller
@SessionAttributes("roles")
public class IndexPageController {
    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    EstimateService estimateService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "isEstimateSuccess", required = false) Boolean isEstimateSuccess) {

        if (isCurrentAuthenticationAnonymous()) {
            ModelAndView mainPage = new ModelAndView("index");

            if (isEstimateSuccess != null){
                mainPage.addObject("isEstimateSuccess" , isEstimateSuccess);
            }

            ArrayList<Estimate> estimateUnsorted = (ArrayList<Estimate>) estimateService.getAllEstimates();

            Collections.sort(estimateUnsorted, new EstimateByDateComparator());

            ArrayList<Estimate> estimatesSorted = getSixEstimatesFromArray(estimateUnsorted);
            mainPage.addObject("estimates" ,estimatesSorted );
            return mainPage;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/list");
            return modelAndView;
        }
    }


    @Autowired
    MailService mailService;

    @RequestMapping(value = "/estimate", method = RequestMethod.POST)
    public ModelAndView estimateWindow(@RequestParam("name") String recipientName, @RequestParam("email") String recipientMail, @RequestParam("phone") String phone,
                                       @RequestParam("message") String recipientRequestText, @RequestParam(value = "price_request", required = false) boolean priceRequest,
                                       @RequestParam(value = "question_request", required = false) boolean questionRequest, Model model) {



        System.out.println("ESTIMATE");
        System.out.println("name " + recipientName + " email " + recipientMail + " text "
                + recipientRequestText + "phone" + phone);


        Date currentDate = new Date();

        Estimate estimate = new Estimate();
        estimate.setName(recipientName);
        estimate.setEmail(recipientMail);
        estimate.setPhone(phone);
        estimate.setPriceRequest(priceRequest);
        estimate.setEstimateRequest(recipientRequestText);
        estimate.setQuestionRequest(questionRequest);
        estimate.setDateRequest(currentDate);
        estimate.setRespond(false);
        estimateService.addNewEstimate(estimate);

        String generatedEstimateId = generateEstimateId(estimate.getDateRequest() , estimate.getId());

        estimate.setEstimateGeneratedId(generatedEstimateId);
        estimateService.updateEstimate(estimate);



        ModelAndView mainPageEstimateSuccess = new ModelAndView("redirect:/main");

        mainPageEstimateSuccess.addObject("isEstimateSuccess", new Boolean(true));

        return mainPageEstimateSuccess;
    }

    @RequestMapping(value = "/requestId/{estimateId}", method = RequestMethod.GET)
    public ModelAndView requestIdShowPage(@PathVariable String estimateId /*, @PathVariable Long generatedEstimateId *//* */){

        ModelAndView requestIdPage = new ModelAndView("/requestId");

        Estimate estimate = estimateService.getEstimateById(Long.valueOf(estimateId));

        requestIdPage.addObject("CustomerEstimate" , estimate);

        return requestIdPage;
    }

    /*@Autowired
    UserService userService;

    @RequestMapping(value = "/generateCustomerId", method = RequestMethod.POST)
    public ModelAndView requestIdCreateAccount(@RequestParam("estimateId") String estimateId , @RequestParam("name") String name, @RequestParam("email") String email,
                                               @RequestParam("phone") String phone , @RequestParam("companyName") String companyName, @RequestParam("companySite") String companySite){

        String password = phone.replace(" " , "");
        // CREATE USER WITH ROLE CUSTOMER
        String ssoId =  generateCustomerId(estimateId);



        User user = new User();

        user.setPassword(password);
        user.setEmail(email);
        user.setSsoId(ssoId);

        UserProfile userProfile = new UserProfile();
        userProfile.setId(1);
        userProfile.setType("CUSTOMER");

        Set<UserProfile> userProfiles = new HashSet<>();
        userProfiles.add(userProfile);

        user.setUserProfiles(userProfiles);

        userService.saveUser(user);

        // CREATE CUSTOMER PROFILE

        User userAfterSave = userService.findBySSO(emailSSO);

        Long userId = new Long(userAfterSave.getId());
        String firstName = "test";
        String lastName = "test";
        String company = "test";
        String avatar = "test";


        //CREATE FINAL NEW CUSTOMER
        Set<Project> projects = new HashSet<>();

        CustomerInfo customerInfo = new CustomerInfo(userId, firstName, lastName, company, avatar, projects);
        customerInfoService.addNewCustomerInfo(customerInfo);


        CustomerInfo customerInfoCreated = customerInfoService.getCustomerInfoById(userId);


        //CREATE #$GENERAL PROJECT FOR CUSTOMER
        Date projectCreationDate = new Date(1990, 12, 13);

        Set<Case> cases = new HashSet<>();


        Project project = new Project("#$GENERAL", projectCreationDate, StatusEnum.OPEN.toString(), customerInfo, cases, "test");

        Set<Project> projectsToAdd = new HashSet<>();
        projectsToAdd.add(project);
        customerInfoCreated.setProjects(projectsToAdd);


        customerInfoService.updateCustomerInfo(customerInfoCreated);







        return new ModelAndView("redirect:/main");
    }*/


    /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }


    private ArrayList<Estimate> getSixEstimatesFromArray(ArrayList<Estimate> sortedEstimateList) {

        ArrayList<Estimate> estimateToShow = new ArrayList<>();
        if (sortedEstimateList.size() >= 6) {
            for (int i = 0; i < 6; i++) {
                estimateToShow.add(sortedEstimateList.get(i));
            }
        } else {
            for (int i = 0; i < 6; i++) {
                estimateToShow.add(null);
            }
            for (int i = 0; i < sortedEstimateList.size(); i++) {
                estimateToShow.set(i, sortedEstimateList.get(i));
            }
        }
        return estimateToShow;
    }

    private String generateEstimateId(Date currentDate , long id) {

        java.sql.Date date = new java.sql.Date(currentDate.getTime());

        String dateWithoutHours = date.toString();
        dateWithoutHours = dateWithoutHours.substring(2 ,10);
        dateWithoutHours = dateWithoutHours.replaceAll("-","");

        String stringId = Long.toString(id);

        String generatedEstimateId = "";
        if (stringId.length() <= 4){
            String zero = "";
            for (int i = 0; i < 4-stringId.length(); i++){
                zero = zero + "0";
                System.out.println("1");
            }
            generatedEstimateId = dateWithoutHours + zero + stringId;
        } else {
            generatedEstimateId = dateWithoutHours + stringId;
        }
        System.out.println(generatedEstimateId);
        return generatedEstimateId;
    }

    private String generateCustomerId(String id){
        if (id.length() <= 4){
            String zero = "";
            for (int i = 0; i < 4-id.length(); i++){
                zero = zero + "0";
                System.out.println("1");
            }
             return zero + id;
        } else {
            return id;
        }
    }
}
