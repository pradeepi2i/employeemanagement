/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.util;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public final class EmployeeValidation {
    
    /**
     * <p>
     *   Check whether the given date is valid or not
     * </p>
     *
     * @param date date to be validated
     *
     * @return true if and only if the date is valid
     */
    public static boolean isValidDate(String date) {
        LocalDate currentDate = LocalDate.now(); 
        Pattern pattern = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])"
               + "[-|//](0?[1-9]|1[012])[-|//]((19|2[0-9])[0-9]{2})$");
        Matcher matcher = pattern.matcher(date);

        if (matcher.find()) {
            String[] dateArray = date.split("[-|//]");           
            int day = Integer.parseInt(dateArray[0]);
            int month = Integer.parseInt(dateArray[1]);
            int year = Integer.parseInt(dateArray[2]);
            if (checkDateMonthAndYear(day, month, year)
                    && (year <= currentDate.getYear()))
                return true;                           
        } 
        return false;
    }

    /**
     * <p>
     *   Check whether the given date is valid for particular month or not
     * </p>
     *
     * @param date date to be validated
     * @param monthAsInt year to be validated
     * @param year year to be validated
     *
     * @return true if and only if date is valid for particular month and year
     */
    private static boolean checkDateMonthAndYear(int date, int monthAsInt,
            int year) {
        String month = Integer.toString(monthAsInt);

        if (monthAsInt > 0 && monthAsInt <= 12) {

            if (month.matches("0?[13578]|1[02]") && (date > 0 && date <= 31)) {
                return true;
            } else if (month.matches("0?[469]|11") 
                    && (date > 0 && date <= 30)) {
                return true;
            } else if (month.matches("0?2") && (year % 4 == 0) 
                    && (year % 400 == 0) && (date > 0 && date <= 29)) {
                return true;
            } else if (month.matches("0?2") && (date > 0 && date <= 28)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     *   Check whether the given gender is valid or not
     * </p>
     *
     * @param gender gender to be validated
     *
     * @return true if and only if the gender is valid 
     */
    public static boolean isValidGender(String gender) {
        return gender.toLowerCase().matches("male|female|m|f");
    }

    /**
     * <p>
     *   Check whether the given blood group is valid or not
     * </p>
     *
     * @param bloodGroup bloodGroup to be validated
     *
     * @return true if and only if the bloodGroup is valid 
     */
    public static boolean isValidBloodGroup(String bloodGroup) {
        return bloodGroup.toLowerCase().matches("(a|b|ab|o)[+-]ve");
    }

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
        return userInput.toLowerCase().matches("([a-z]+( [a-z]*)*?)[^0-9]");
    }

    /**
     * <p>
     *   Check whether the given mobile number is valid or not
     * </p>
     *
     * @param mobileNumber mobile number to be validated
     *
     * @return true if and only if the mobile number is valid 
     */
    public static boolean isValidMobileNumber(long mobileNumber) { 
        return Long.toString(mobileNumber).matches("[6789][0-9]{9}");        
    }

    /**
     * <p>
     *   Check whether the given account number is valid or not
     * </p>
     *
     * @param accountNumber account number to be validated
     *
     * @return true if and only if the account number is valid 
     */
    public static boolean isValidAccountNumber(long accountNumber) {
        return Long.toString(accountNumber).matches("[0-9]{14}");
    }   

    /**
     * <p>
     *   used to validate ifsc code
     * </p>
     *
     * @param ifscCode ifsc to be checked
     *
     * @return true if it is valid ifsc code
     */
    public static boolean isValidIfscCode(String ifscCode) {
        return ifscCode.toLowerCase()
                .matches("([a-z]{4})(0{3})([a-z][0-9]{3})");
    } 
}
