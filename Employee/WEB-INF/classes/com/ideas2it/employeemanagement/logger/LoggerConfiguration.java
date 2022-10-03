/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * <p>
 *   Implement Logger for overall application
 * </p>
 *
 * <p>
 *   This file is created on 17/09/2022
 *   @author : Pradeep
 * </p>
 */
public class LoggerConfiguration {

    /**
     * <p>
     *   Use this method to get the instance of logger class
     * </p>
     *
     * @param name name of the class which uses logger
     *
     * @return logger logger object
     */
    public static Logger getInstance(String name ) {
        String log4jPath = "/home/ubuntu/Desktop/Employee/src/log4j/log4j.properties";
        PropertyConfigurator.configure(log4jPath);
        Logger logger = Logger.getLogger(name);
        return logger;
    }

}
