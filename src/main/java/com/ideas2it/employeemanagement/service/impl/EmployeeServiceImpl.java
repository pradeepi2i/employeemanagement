/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.service.impl;

import com.ideas2it.employeemanagement.repository.EmployeeDAO;
import com.ideas2it.employeemanagement.dto.EmployeeDTO;
import com.ideas2it.employeemanagement.helper.EmployeeHelper;
import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.service.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *   Implementation to save new employee or search,
 *   update, and delete existing employee details
 * </p>
 *
 * <p>  
 *   This file is created on 02/08/2022
 *   @author : Pradeep
 * </p>
 */
@Service
public class EmployeeServiceImpl implements EmployeeService, UserDetailsService {

    private static Logger logger = LoggerConfiguration
            .getInstance("AuthenticationSecurityConfiguration.class");

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    
    /**
     * <p>
     *   Add a employee by getting the following details
     * </p>
     *
     * @param employeeDTO employee's details
     *
     * @return created id 
     */
    public int addEmployee(EmployeeDTO employeeDTO) {

        Employee employee =  employeeDAO.save(EmployeeHelper
                                     .convertEmployeeDTOIntoEmployee(
                                     employeeDTO));
        return employee.getId();
    }

    /**
     * <p>
     *   Get all employees
     * </p>
     *
     * @return all employees
     */
    public Map<Integer, EmployeeDTO> displayAllEmployees() {
        Map<Integer,Employee> employees = new HashMap<>();

        for (Employee employee : employeeDAO.findAll()) {
            employees.put(employee.getId(), employee);
        }
        return employees.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                employee -> EmployeeHelper
                .convertEmployeeIntoEmployeeDTO(employee.getValue())));
    }

    /**
     * <p>
     *   Get the employee,searched by using id
     * </p>   
     *
     * @param id id to be searched
     *
     * @return employee by searching id 
     *
     */
    public EmployeeDTO searchEmployeeById(int id) { 
        Employee employee = employeeDAO.findById(id).orElse(null);
        return (null != employee) 
                ? EmployeeHelper.convertEmployeeIntoEmployeeDTO(employee)
                : null;
    } 

    /**
     * <p>
     *   Update the employee by using employee object
     * </p>   
     *
     * @param employeeDTO updated employee to be replaced 
     *
     * @return updated id
     *
     */
    public int updateEmployee(EmployeeDTO employeeDTO) {  
        Employee employee = employeeDAO.save(EmployeeHelper
                                    .convertEmployeeDTOIntoEmployee(
                                    employeeDTO));
        return employee.getId();
    }

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
    public int deleteEmployeeById(int id) {
         employeeDAO.deleteById(id);
         return id;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        logger.info("loadUserByName method() in service");
        Employee employee = employeeDAO.findById(Integer.parseInt(id)).orElse(null);

        if (null == employee) {
            throw new UsernameNotFoundException("User with user id" + id + " not found");
        }
        logger.info("In service loadUserByName() " + employee.getFirstName());
        return new User(Integer.toString(employee.getId()), employee.getFirstName(), new ArrayList<>());
    }
}
