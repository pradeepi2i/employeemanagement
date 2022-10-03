/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.service.impl;

import com.ideas2it.employeemanagement.dao.EmployeeDAO;
import com.ideas2it.employeemanagement.dto.EmployeeDTO;
import com.ideas2it.employeemanagement.helper.EmployeeHelper;
import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Mobile;
import com.ideas2it.employeemanagement.model.WorkPlace;
import com.ideas2it.employeemanagement.service.EmployeeService;
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
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeServiceImpl() {

    }
    private EmployeeDAO employeeDAOImpl;

    public EmployeeServiceImpl(EmployeeDAO employeeDAOImpl) {
        this.employeeDAOImpl = employeeDAOImpl;
    }
    
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
            Set<Address> addresses) {
       
        EmployeeDTO employeeDTO = new EmployeeDTO(firstName, lastName,
                gender, dateOfBirth, bloodGroup, emailId, dateOfJoining,
                accountNumber, ifscCode, designation, experience, salary, 
                workPlace, mobileNumbers, addresses);
        Employee employee =  employeeDAOImpl.insertEmployee(EmployeeHelper
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
        return employeeDAOImpl.retrieveAllEmployees().entrySet().stream()
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
        Employee employee = employeeDAOImpl.retrieveEmployeeById(id);   
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
        Employee employee = employeeDAOImpl.updateEmployee(EmployeeHelper
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
        return employeeDAOImpl.deleteEmployeeById(id);            
    }

    /**
     * <p>
     *   Check mobile number duplication
     * </p>
     *
     * @return list of mobile numbers
     */
    public List<Long> checkDuplicate() {
        return employeeDAOImpl.checkDuplicate();
    }

    /**
     * <p>
     *   Check email id duplication
     * </p>
     *
     * @return list of email id
     */
    public List<String> checkDuplicateEmail() {
        return employeeDAOImpl.checkDuplicateEmail();
    }
} 
