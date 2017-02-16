package com.SoftwareFactory.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.SoftwareFactory.model.User;
import com.SoftwareFactory.model.UserProfile;
import com.SoftwareFactory.service.UserProfileService;
import com.SoftwareFactory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	@Autowired
	UserService userService;

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;


	/**
	 * This method will list all existing users .
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public ModelAndView listUsers(HttpSession session) {

		User currentUser = userService.findBySSO(getPrincipal());

		Set profiles = currentUser.getUserProfiles();

		UserProfile userProfile = null;
		Iterator iterator = profiles.iterator();
		while (iterator.hasNext()) {
			userProfile = (UserProfile) iterator.next();
		}

		ModelAndView modelAndView = new ModelAndView();

		if (userProfile.getType().equals("ADMIN")){
			System.out.println("LOGIN AS ADMIN");

			modelAndView.setViewName("userslist");

		} else if (userProfile.getType().equals("CUSTOMER")){
			System.out.println("LOGIN AS CUSTOMER");
			modelAndView.setViewName("redirect:/cabinet/");
		}

		System.out.println(currentUser.getId());
		System.out.println(userProfile.getType());

		session.setAttribute("UserId" , currentUser.getId());
		session.setAttribute("UserRole" , userProfile.getType());

		return modelAndView;
	}

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}

	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response ){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);

		}
		request.getSession().invalidate();
		return "redirect:/main?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}