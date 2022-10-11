/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * <p>
 *   This class contains some utility function 
 * </p>
 *
 * <p>  
 *   This file is created on 08/08/2022
 *   @author : Pradeep
 * </p>
 */
public final class EmployeeUtil {    

    /**
     * <p>
     *  Generate random id for an employee
     * </p>
     *
     * @return created employeeId
     */
    public static String generateRandomID() {
        String userId = "";
        Random random = new Random();
        String numbers = "1234567890";
        for (int index = 0; index < 2; index++) {
            userId += numbers.charAt(random.nextInt(numbers.length()));
        }
        return userId;
    }

    /**
     * <p>
     *   Calculate age from date of birth
     * </p>
     * 
     * @param dateOfBirth employee's date of birth
     *
     * @return employee age in years
     */
    public static int calculateAge(LocalDate dateOfBirth) {        
        LocalDate currentDate = LocalDate.now();  
        Period age = Period.between(dateOfBirth, currentDate);
        return age.getYears();    
    }

    /**
     * <p>
     *   Calculate experience from date of join
     * </p>
     * 
     * @param dateOfJoining employee's date of joining
     *
     * @return experience in years
     */
    public static int calculateExperience(LocalDate dateOfJoining) {        
        LocalDate currentDate = LocalDate.now();  
        Period experience = Period.between(dateOfJoining, currentDate);
        return experience.getYears();    
    }

    /**
     * <p>
     *   Convert string into date
     * </p>
     *
     * @param date date get from user
     *
     * @return formatted date
     */
    public static LocalDate convertToDate(String date) {
        DateTimeFormatter dateFormat = DateTimeFormatter
                .ofPattern("yyyy-MM-dd");
        String[] dateArray = date.split("[-|//]");           
        String day = dateArray[0];
        String month = dateArray[1];
        String year = dateArray[2]; 

        if (day.matches("[1-9]")) {
            day = ("0").concat(day);
        }
  
        if (month.matches("[1-9]")) {
            month = "0" + month;
        }
        date = day.concat("-").concat(month).concat("-").concat(year); 
        return LocalDate.parse(date, dateFormat);  
    }

    /**
     * <p>
     *   Generate employee email address
     * </p>
     *
     * @param firstName employee's first name
     * @param lastName employee's last name
     *
     * @return generated email id
     */
    public static String generateEmailByFirstNameAndLastName(String firstName,
            String lastName) {

        return firstName.toLowerCase() + "."
                + lastName.toLowerCase() + "@ideas2it.com";
    }

    /**
     * <p>
     *   Mask the mobile number to user while display 
     * </p>
     *
     * @return masked mobile number
     */
    public static String maskMobileNumber(long mobileNumber) {
        return "xxxxxx" + Long.toString(mobileNumber).substring(6,10);
    }

    /**
     * <p>
     *   Mask the account number to user while display 
     * </p>
     *
     * @return masked account number
     */
    public static String maskAccountNumber(long accountNumber) {        
        return "xxxx-xxxx-xx" + Long.toString(accountNumber).substring(10,14);
    }
}
