package com.ideas2it.employeemanagement.controller;

import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import com.ideas2it.employeemanagement.security.JWTUtil;
import com.ideas2it.employeemanagement.service.impl.EmployeeServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthenticationController {

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    private static Logger logger = LoggerConfiguration
            .getInstance("AuthenticationController.class");


    @GetMapping("/")
    public ModelAndView login() {
        logger.info("In AuthController login()");
        return new ModelAndView("login");
    }

    @GetMapping("/login")
    public ModelAndView createAuthenticationToken(@RequestParam("userId") int userId,
            @RequestParam("password") String password) throws Exception {
        try {
            logger.info("In Auth Controller ");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userId, password));
        } catch (BadCredentialsException badCredentialsException) {
            throw new Exception("Incorrect User-id or password", badCredentialsException);
        }
        UserDetails userDetails = employeeServiceImpl.loadUserByUsername(Integer.toString(userId));
        String jwtToken = jwtUtil.generateToken(userDetails);

        return new ModelAndView("index");
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
