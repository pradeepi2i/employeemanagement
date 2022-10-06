/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.filter;

import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import org.apache.log4j.Logger;

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
public class CommonFilter implements Filter {

    private static Logger logger = LoggerConfiguration
            .getInstance("CommonFilter.class");

    static FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) {
         filterConfig = filterConfig;
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
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        boolean isLoggedIn = ((null != session) && (null != session.getAttribute("userId")));
        //String path = request.getRequestURI().substring(request.getContextPath().length());

        if (isLoggedIn ) {
            logger.info("User Logged in");
            filterChain.doFilter(request, response);
        } else {
            logger.info("Doesn't Logged in and forward to login.html");
            response.sendRedirect("http://localhost:8080/Employee/login.html");
        }

    }

    @Override
    public void destroy() {

    }
}
