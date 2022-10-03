/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.dao;

import com.ideas2it.employeemanagement.model.Employee;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *   Interface that contains abstract methods
 *   create, search, update and delete an employee
 * </p>
 *
 * <p>  
 *   This file is created on 06/08/2022
 *   @author : Pradeep
 * </p>
 *
 */
public interface EmployeeDAO {

    /**
     * <p>
     *   Insert an employee to the Map  
     * </p>
     *
     * @param employee employee to be inserted 
     * 
     * @return inserted id
     */
    public Employee insertEmployee(Employee employee);

    /**
     * <p>
     *   Retrieve all employees
     * </p>
     *
     * @return employees all employees
     */
    public Map<Integer, Employee> retrieveAllEmployees();

    /**
     * <p>
     *   Get the employee id and find the object through key
     * </p>
     *    
     * 
     * @param id id of the employee to be searched
     * 
     * @return employee by searching id 
     * 
     */ 
    public Employee retrieveEmployeeById(int id);

    /**
     * <p>
     *   Modify the employee details by using the object 
     *
     *   Set the new one instead of existing object      
     * </p>
     *    
     * @param employee updated employee  
     * 
     * @return updated id
     * 
     */
    public Employee updateEmployee(Employee employee);

    /**
     * <p>
     *   Delete the employee details by using their id  
     * </p>
     *    
     * @param id the id to be deleted     
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
    public List<String > checkDuplicateEmail();
}

