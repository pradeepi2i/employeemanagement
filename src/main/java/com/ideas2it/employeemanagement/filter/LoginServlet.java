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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class LoginServlet {

    private static final Logger logger = LoggerConfiguration
            .getInstance("LoginServlet.class");
    @GetMapping("/login")
    public void userLogin(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (("pradeep".equals(userName)) && ("1234".equals(password))) {
            HttpSession session = request.getSession();
            request.setAttribute("requestName", userName);
            session.setAttribute("sessionName", userName);

            logger.info("Login servlet after set attribute");
            request.getRequestDispatcher("index.jsp")
                    .forward(request, response);
        } else {
            request.getRequestDispatcher("/login.jsp")
                    .include(request, response);
        }

    }
}
