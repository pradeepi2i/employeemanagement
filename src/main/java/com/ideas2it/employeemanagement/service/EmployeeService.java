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
     * @param employeeDTO employee's details
     *
     * @return created id 
     */
    public int addEmployee(EmployeeDTO employeeDTO);

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


