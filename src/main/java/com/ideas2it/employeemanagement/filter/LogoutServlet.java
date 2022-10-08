/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.filter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class LogoutServlet {

    @RequestMapping("/logout")
    public void loggingOut(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (null != session) {
            session.invalidate();
            request.getRequestDispatcher("login.jsp")
                    .include(request, response);

        }
    }
}
