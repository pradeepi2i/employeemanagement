package com.ideas2it.employeemanagement.controller;

import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import com.ideas2it.employeemanagement.security.JWTUtil;
import com.ideas2it.employeemanagement.service.impl.EmployeeServiceImpl;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class AuthenticationController {

    private JWTUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    private EmployeeServiceImpl employeeServiceImpl;

    public AuthenticationController(JWTUtil jwtUtil,
            AuthenticationManager authenticationManager,
            EmployeeServiceImpl employeeServiceImpl) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.employeeServiceImpl = employeeServiceImpl;
    }

    private static Logger logger = LoggerConfiguration
            .getInstance("AuthenticationController.class");


    @GetMapping("/")
    public ModelAndView login() {
        logger.info("In AuthController login()");
        return new ModelAndView("/login");
    }

    @GetMapping("/login")
    public ModelAndView createAuthenticationToken(HttpServletRequest request, HttpServletResponse response) throws Exception {

        if ((null != request.getParameter("userId"))
                && (null != request.getParameter("password"))) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            String password = request.getParameter("password");
            try {
                logger.info("In Auth Controller ");
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(userId, password));
            } catch (BadCredentialsException badCredentialsException) {
                throw new Exception("Incorrect User-id or password", badCredentialsException);
            }
            UserDetails userDetails = employeeServiceImpl.loadUserByUsername(Integer.toString(userId));
            String jwtToken = "Bearer" + jwtUtil.generateToken(userDetails);
            HttpSession session = request.getSession();
            session.setAttribute("Authorization", jwtToken);
            logger.info(jwtToken);
            return new ModelAndView("index");
        }
        return new ModelAndView("login");
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        return new ModelAndView("/home");
    }

    @GetMapping("/error")
    public ModelAndView error() {
        return new ModelAndView("index");
    }
}
