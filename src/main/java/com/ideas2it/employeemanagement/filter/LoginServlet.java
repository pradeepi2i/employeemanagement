/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.filter;

import com.ideas2it.employeemanagement.dto.EmployeeDTO;
import com.ideas2it.employeemanagement.service.EmployeeService;
import com.ideas2it.employeemanagement.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    EmployeeService employeeServiceImpl = new EmployeeServiceImpl();
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String employeeId = request.getParameter("id");
        String password = request.getParameter("password");

        if (!employeeId.isEmpty() && !password.isEmpty()) {
            int id = Integer.parseInt(employeeId);
            EmployeeDTO employeeDTO = employeeServiceImpl
                    .searchEmployeeById(id);

            if (null != employeeDTO) {

                if (password.equals(employeeDTO.getFirstName())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", employeeDTO.getId());
                    request.getRequestDispatcher("index.jsp")
                            .forward(request, response);
                } else {
                    out.println("Invalid Login Credentials");
                    request.getRequestDispatcher("login.html")
                            .include(request, response);
                }
            } else {
                out.println("User Id doesn't exist");
            }
        } else {
            out.println("Empty Input");
        }
    }
}
