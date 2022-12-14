/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.exception;

/**
 * <p>
 *   Thrown to indicate that the user's age is not valid.
 * </p>
 *
 * <p>
 *   This file is created on 14/08/2022
 *   @author : Pradeep
 * </p>
 */
public class CustomException extends RuntimeException {

    public CustomException(String error, Throwable clause) {
        super(error, clause);
    }
    public CustomException(String error) {
        super(error);
    }


}