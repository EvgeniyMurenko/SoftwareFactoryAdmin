package com.SoftwareFactoryAdmin.controller;

import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SoftwareFactoryAdmin.constant.MainPathEnum;
import com.SoftwareFactoryAdmin.model.Message;
import com.SoftwareFactoryAdmin.model.User;
import com.SoftwareFactoryAdmin.model.UserProfile;
import com.SoftwareFactoryAdmin.service.CustomerInfoService;
import com.SoftwareFactoryAdmin.service.MessageService;
import com.SoftwareFactoryAdmin.service.UserProfileService;
import com.SoftwareFactoryAdmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
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
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public ModelAndView listUsers(HttpSession session) {



        User currentUser = userService.findBySSO(getPrincipal());


        Set profiles = currentUser.getUserProfiles();

        UserProfile userProfile = null;
        Iterator iterator = profiles.iterator();
        while (iterator.hasNext()) {
            userProfile = (UserProfile) iterator.next();
        }


        ModelAndView modelAndView = new ModelAndView("redirect:/main/");

        if (userProfile.getType().equals("MANAGER")) {
            System.out.println("LOGIN AS MANAGER");
            modelAndView.setViewName("redirect:/estimate/");
        } else if (userProfile.getType().equals("ADMIN")) {
            System.out.println("LOGIN AS ADMIN");
            modelAndView.setViewName("redirect:/estimate/");
        }

        System.out.println(currentUser.getId());
        System.out.println(userProfile.getType());

        session.setAttribute("UserId", currentUser.getId());
        session.setAttribute("UserRole", userProfile.getType());

        return modelAndView;
    }

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
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
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        request.getSession().invalidate();
        return "redirect:/main?logout";
    }


    @RequestMapping(value = "/get-file/{type}/{filename}", method = RequestMethod.GET)
    public void getFile(HttpServletResponse response,
                        @PathVariable String type,
                        @PathVariable String filename) throws IOException {

        String EXTERNAL_FILE_PATH = MainPathEnum.mainPath + "/" + type + "/" + filename;

        File file = new File(EXTERNAL_FILE_PATH);

        checkFile(file, response);

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }

        System.out.println("mimetype : " + mimeType);

        response.setContentType(mimeType);

        response.setHeader("Content-Disposition : attachment", String.format("inline; filename=\"" + file.getName() + "\""));


        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));


        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

    /**
     * This method check if file exist and return error
     */
    private void checkFile(File file, HttpServletResponse response) {

        if (!file.exists()) {
            String errorMessage = "Sorry. The file you are looking for does not exist";
            System.out.println(errorMessage);
            OutputStream outputStream = null;
            try {
                outputStream = response.getOutputStream();
                outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
                outputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                return;
            }

        }
    }

}


/*
    @RequestMapping(value = "/show-image/{folderName}/{folderId}/{filename}", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response,
                             @PathVariable String folderName,
                             @PathVariable String folderId,
                             @PathVariable String filename) throws IOException {

        String EXTERNAL_FILE_PATH = MainPathEnum.mainPath + "/" + folderName + "/" + folderId + "/" + filename;

        File file = new File(EXTERNAL_FILE_PATH);

        checkFile(file, response);

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }

        System.out.println("mimetype : " + mimeType);

        response.setContentType(mimeType);

        response.setHeader("Content-Disposition : attachment", String.format("inline; filename=\"" + file.getName() + "\""));

        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
*/


/*@Autowired
    MessageService messageService;

    @RequestMapping(value = "/download/{messageId}/{filename}/", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response, @PathVariable Long messageId, @PathVariable String filename) throws IOException {


        Message message = messageService.getMessageById(messageId);

        String EXTERNAL_FILE_PATH =*//* message.getMessagePath() +*//* "/" + filename;

        File file = new File(EXTERNAL_FILE_PATH);


        checkFile(file, response);


        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }

        System.out.println("mimetype : " + mimeType);

        response.setContentType(mimeType);

        *//* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*//*
        response.setHeader("Content-Disposition : attachment", String.format("inline; filename=\"" + file.getName() + "\""));


        *//* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*//*
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));

        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }*/


/*
    @RequestMapping(value = "/show-video/{noticeId}/{filename}", method = RequestMethod.GET)
    public void showVideo(HttpServletResponse response, @PathVariable String noticeId,
                          @PathVariable String filename) throws IOException {
        String EXTERNAL_FILE_PATH = MainPathEnum.mainPath + "/notice/" + noticeId + "/video/" + filename;
        try {

            int fileSize = (int) new File(EXTERNAL_FILE_PATH).length();
            response.setContentLength(fileSize);
            FileInputStream inputStream = new FileInputStream(EXTERNAL_FILE_PATH);
            ServletOutputStream outputStream = response.getOutputStream();
            int value = IOUtils.copy(inputStream, outputStream);
            System.out.println("File Size :: " + fileSize);
            System.out.println("Copied Bytes :: " + value);
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (java.io.FileNotFoundException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
*/

