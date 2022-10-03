/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2It
 * </p>
 */

package com.ideas2it.employeemanagement.util;

/**
 * <p>
 *   This class contains validation function to validate user inputs
 * </p>
 *
 * <p>  
 *   This file is created on 10/08/2022
 *   @author : Pradeep
 * </p>
 */
public final class ProjectValidation {

    /**
     * <p>
     *   Check whether the given userInput is valid or not
     * </p>
     *
     * @param userInput userInput to be validated
     *
     * @return true if and only if the userInput is valid 
     */
    public static boolean isValidString(String userInput) {
        return userInput.matches("([a-zA-Z0-9\\s]+)");
    }
}
