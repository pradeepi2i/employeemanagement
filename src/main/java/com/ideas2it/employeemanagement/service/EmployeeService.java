/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.service;

import com.ideas2it.employeemanagement.dto.EmployeeDTO;
import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.model.Mobile;
import com.ideas2it.employeemanagement.model.WorkPlace;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *   Interface that contains abstract and static methods
 *   create, search, update and delete an employee
 * </p>
 *
 * <p>  
 *   This file is created on 02/08/2022
 *   @author : Pradeep
 * </p>
 *
 */
public interface EmployeeService {
 
    /**
     * <p>
     *   Add a employee by getting the following details
     * </p>
     *
     * @param firstName employee's first name 
     * @param lastName employee's last name 
     * @param gender employee's gender 
     * @param dateOfBirth employee's date of birth
     * @param bloodGroup employee's blood group 
     * @param emailId employee's email address
     * @param dateOfJoining employee's date of joining
     * @param accountNumber employee's account number
     * @param ifscCode bank's IFSC code
     * @param designation employee's designation
     * @param experience employee's experience
     * @param salary employee's annual CTC 
     * @param workPlace employee's work place
     * @param mobileNumbers employee's mobile number
     * @param addresses employee's addresses
     *
     * @return created id 
     */
    public int addEmployee(String firstName, String lastName, String gender,
            LocalDate dateOfBirth, String bloodGroup, String emailId,
            LocalDate dateOfJoining, long accountNumber, String ifscCode,
            String designation, float experience, float salary,
            WorkPlace workPlace, Set<Mobile> mobileNumbers,
            Set<Address> addresses);

    /**
     * <p>
     *   Get all employees
     * </p>
     *
     * @return all employees
     */
    public Map<Integer, EmployeeDTO> displayAllEmployees();

    /**
     * <p>
     *   Get the employee, searched by using id 
     * </p>   
     *
     * @param id id to be searched
     *
     * @return employee by searching id from map
     *
     */
    public EmployeeDTO searchEmployeeById(int id);    

    /**
     * <p>
     *   Update the employee by employee object 
     * </p>   
     *
     * @param employeeDTO updated employee to be replaced
     *
     * @return updated id
     *
     */
    public int updateEmployee(EmployeeDTO employeeDTO); 
   
    /**
     * <p>
     *   Delete the employee by id 
     * </p>          
     *
     * @param id id to be deleted
     *
     * @return deleted id
     *
     */
    public int deleteEmployeeById(int id);

    /**
     * <p>
     *   Check mobile number duplication
     * </p>
     *
     * @return list of mobile numbers
     */
    public List<Long> checkDuplicate();

    /**
     * <p>
     *   Check email id duplication
     * </p>
     *
     * @return list of email id
     */
    public List<String> checkDuplicateEmail();
}


