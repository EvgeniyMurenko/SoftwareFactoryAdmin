package com.SoftwareFactoryAdmin.configuration;

import org.springframework.http.MediaType;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CharsetFilter implements Filter {

    final String APPLICATION_JSON_WITH_UTF8_CHARSET = MediaType.APPLICATION_JSON + ";charset=" + java.nio.charset.StandardCharsets.UTF_8;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        logger.info("Init CharsetFilter");
    }



  /*  @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletResponse r = (HttpServletResponse) response;
        HttpServletResponse wrappedResponse = new HttpServletResponseWrapper(r)
        {
            @Override
            public ServletOutputStream getOutputStream() throws java.io.IOException
            {
                ServletResponse response = this.getResponse();

                String ct = (response != null) ? response.getContentType() : null;
                if (ct != null && ct.toLowerCase().startsWith(String.valueOf(MediaType.APPLICATION_JSON)))
                {
                    response.setContentType(APPLICATION_JSON_WITH_UTF8_CHARSET);
                }

                return super.getOutputStream();
            }
        };

        chain.doFilter(request, wrappedResponse);
    }


*/

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
//        logger.info("Destroy CharsetFilter");
    }
}
