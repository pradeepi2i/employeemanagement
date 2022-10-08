/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.filter;

import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 *   Implement this filter to check whether the user
 *   is logged in or not
 * </p>
 *
 * <p>
 *   This file is created on 28/09/2022
 *   @author : Pradeep
 * </p>
 */
@Component
public class CommonFilter implements Filter {

    private static Logger logger = LoggerConfiguration
            .getInstance("CommonFilter.class");

    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("init() method has been get invoked");
        logger.info("Filter name is " + filterConfig.getFilterName());
        this.filterConfig = filterConfig;
    }

    /**
     * <p>
     *   Used to  filter whether the user is logged in or not
     *   if not redirect to login page
     * </p>
     *
     * @param servletRequest request get from login page
     * @param servletResponse response sent from login page
     * @param filterChain to continue next filter if exists
     */
    @Override
    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String name = (String) request.getSession().getAttribute("sessionName");

        if (null != name) {
            logger.info(name);
            logger.info(request);
            String requestName = (String) request.getAttribute("requestName");
            logger.info(requestName);
            boolean isLoggedIn = (request.getAttribute("requestName").equals(name));
            //boolean isLoggedIn = (null != request.getSession(false));
            logger.info("isLogged in " + isLoggedIn);
            logger.info("Session attribute " + name);

            if (isLoggedIn) {
                logger.info("User Logged in");
                filterChain.doFilter(request, servletResponse);
            }
        } else {
            logger.info("Doesn't Logged in and forward to login.jsp");
            request.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
