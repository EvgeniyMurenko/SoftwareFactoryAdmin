package com.SoftwareFactory.controller;

import com.SoftwareFactory.comparator.EstimateByDateComparator;
import com.SoftwareFactory.model.Estimate;
import com.SoftwareFactory.service.EstimateService;
import com.SoftwareFactory.service.MailService;
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
import java.util.*;

/**
 * Created by Alex on 1/12/2017.
 */
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
    public ModelAndView loginPage(Model model) {


        // LOCALE
      /*  Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);*/


        if (isCurrentAuthenticationAnonymous()) {
            ModelAndView mainPage = new ModelAndView("index");


            ArrayList<Estimate> estimateUnsorted = (ArrayList<Estimate>) estimateService.getAllEstimates();

            Collections.sort(estimateUnsorted, new EstimateByDateComparator());

            ArrayList<Estimate> estimatesSorted = getSixEstimatesFromArray(estimateUnsorted);
            mainPage.addObject("Estimates" ,estimatesSorted );
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


        Estimate estimate = new Estimate();
        estimate.setName(recipientName);
        estimate.setEmail(recipientMail);
        estimate.setPhone(phone);
        estimate.setPriceRequest(priceRequest);
        estimate.setQuestionRequest(questionRequest);
        estimate.setDateRequest(new Date());
        estimate.setRespond(false);

        estimateService.addNewEstimate(estimate);

/*

        mailService.sendEmail(recipientMail, recipientName);
*/
        ModelAndView mainPageEstimateSuccess = new ModelAndView("redirect:/main");

        mainPageEstimateSuccess.addObject("isSuccess", true);

        return mainPageEstimateSuccess;
    }


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

}
