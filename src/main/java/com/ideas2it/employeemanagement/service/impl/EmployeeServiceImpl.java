/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.service.impl;

import com.ideas2it.employeemanagement.configuration.EmployeeDetails;
import com.ideas2it.employeemanagement.dao.EmployeeDAO;
import com.ideas2it.employeemanagement.dto.EmployeeDTO;
import com.ideas2it.employeemanagement.exception.EmployeeException;
import com.ideas2it.employeemanagement.helper.EmployeeHelper;
import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Mobile;
import com.ideas2it.employeemanagement.model.WorkPlace;
import com.ideas2it.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

        Employee employee =  employeeDAO.insertEmployee(EmployeeHelper
                                     .convertEmployeeDTOIntoEmployee(
                                     employeeDTO));
        if (null != employee) {
            return employee.getId();
        }
        return 0;
    }

    /**
     * <p>
     *   Get all employees
     * </p>
     *
     * @return all employees
     */
    public Map<Integer, EmployeeDTO> displayAllEmployees() {
        return employeeDAO.retrieveAllEmployees().entrySet().stream()
                .collect(Collectors.toMap(employee -> employee.getKey(),
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
        Employee employee = employeeDAO.retrieveEmployeeById(id);
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
        Employee employee = employeeDAO.updateEmployee(EmployeeHelper
                                    .convertEmployeeDTOIntoEmployee(
                                    employeeDTO));
        if (null != employee) {
            return employee.getId();
        }
        return 0;
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
        return employeeDAO.deleteEmployeeById(id);
    }

    /**
     * <p>
     *   Check mobile number duplication
     * </p>
     *
     * @return list of mobile numbers
     */
    public List<Long> checkDuplicate() {
        return employeeDAO.checkDuplicate();
    }

    /**
     * <p>
     *   Check email id duplication
     * </p>
     *
     * @return list of email id
     */
    public List<String> checkDuplicateEmail() {
        return employeeDAO.checkDuplicateEmail();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeDAO.retrieveEmployeeById(Integer.parseInt(username));
        if (null == employee) {
            throw new EmployeeException("User not found", new UsernameNotFoundException("error"));
        }
        return new EmployeeDetails(EmployeeHelper.convertEmployeeIntoEmployeeDTO(employee));
    }
}
