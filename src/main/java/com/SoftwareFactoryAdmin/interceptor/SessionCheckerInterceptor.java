package com.SoftwareFactoryAdmin.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Component
public class SessionCheckerInterceptor implements HandlerInterceptor {

    //websites uri allowed
    private static final String LOGIN_REQUEST = "/list/";
    private static final String MAIN = "/main";
    private static final String ROOT = "/";
    private static final String ERROR = "/error/404";


    // request types
    private static final String MULTIPART_CONTENT_TYPE = "multipart/form-data";
    private static final String JSON_CONTENT_TYPE = "application/json";


    private static final String GET_FILE = "/get-file/";
    private static final String FILE_EXCHANGE = "/file-exchange";


    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {


        System.out.println("CONTENT TYPE " + request.getContentType());
        System.out.println("URI GET REQUEST URI "  + request.getRequestURI());


        String uri = request.getRequestURI();
        String contentType = request.getContentType();


       /* Check if app requests */
        if (contentType!= null) {
            if (contentType.contains(JSON_CONTENT_TYPE)) return true;
            if (contentType.contains(MULTIPART_CONTENT_TYPE) && FILE_EXCHANGE.contains(uri)) return true;
        }



        // Check if session die or user logout
        if (!MAIN.equals(uri) && !LOGIN_REQUEST.equals(uri) && !ROOT.equals(uri) && !uri.contains(GET_FILE) && !uri.contains(ERROR)) {

            System.out.println("STEP1");

            if (!isUserLogged()) {

                System.out.println("STEP2");
                session = request.getSession();

                System.out.println("STEP3");
                if (session.getAttribute("managerInfo") == null) {

                    System.out.println("Logging out, due to inactive session");
                    SecurityContextHolder.clearContext();
                    System.out.println("clearContext");
                    request.logout();

                    response.sendRedirect("/main");
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView model) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {}



    private static boolean isUserLogged() {
        try {
            return !SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser");
        } catch (Exception e) {
            return false;
        }
    }

}


