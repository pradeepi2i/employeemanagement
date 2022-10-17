/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement;

import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

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
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class MainApplication {

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
        try {
            SpringApplication.run(MainApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();}

    }
}
