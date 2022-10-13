package com.ideas2it.employeemanagement.controller;

import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthenticationController {

    private static Logger logger = LoggerConfiguration
            .getInstance("AuthenticationController.class");

    @GetMapping("/")
    public ModelAndView login() {
        logger.info("In AuthController login()");
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView index() {
        logger.info("In AuthController index()");
        return new ModelAndView("index");
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        return new ModelAndView("login");
    }
}
