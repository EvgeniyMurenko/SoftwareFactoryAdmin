package com.SoftwareFactory.configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { AppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
//        logger.info("Create the 'root' Spring application context");
        super.onStartup(servletContext);

//        logger.info("Definition UTF-8 Encoding (CharsetFilter())");
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("charsetFilter", new CharsetFilter());
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");



    }

}
