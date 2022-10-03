/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement;

import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;

/**
 * <p>
 *   The overall control of application
 * </p>
 *
 * <p>  
 *   This file is created on 26/08/2022
 *   @author : Pradeep
 * </p>
 */

public class MainApplication extends HttpServlet {

    private static Logger logger = LoggerConfiguration.getInstance("MainApplication.class");

    /**
     * <p>
     *   Method where object creation and method call to access all 
     *   function in an application takes place
     * </p>
     *
     * @param args command line argument
     *
     */
    public static void main(String[] args) {
       logger.info("Running main");
    }
}
