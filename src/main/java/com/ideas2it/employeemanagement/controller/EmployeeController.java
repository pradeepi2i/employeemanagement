/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.controller;

import com.ideas2it.employeemanagement.dto.EmployeeDTO;
import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import com.ideas2it.employeemanagement.service.EmployeeService;
import com.ideas2it.employeemanagement.util.EmployeeUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 *   Implemented to create a new employee or search, update, and delete
 *   existing employee 
 * </p>
 *
 * <p>  
 *   This file is created on 27/07/2022
 *   @author : Pradeep
 * </p>
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    public EmployeeController() {}
    @Autowired
    private EmployeeService employeeServiceImpl;
    private ModelAndView modelAndView = new ModelAndView("show.jsp");

    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    private static Logger logger = LoggerConfiguration
            .getInstance("EmployeeController.class");

    @GetMapping("/create")
    public ModelAndView addEmployee() {
        ModelAndView modelAndView = new ModelAndView("create.jsp");
        return modelAndView.addObject("employee", new EmployeeDTO());
    }

    /**
     * <p>
     *   Used to forward the employeeDTO along with
     *   request object through request dispatcher
     * </p>
     *
     * @param id id to be updated
     */
    @GetMapping("/update")
    private ModelAndView updateDispatch(@PathVariable("id") int id) {

        if (0 != id) {
            EmployeeDTO employeeDTO = employeeServiceImpl
                    .searchEmployeeById(id);

            if (null != employeeDTO) {
                ModelAndView modelAndView = new ModelAndView("/modify.jsp");
                modelAndView.addObject("employee", employeeDTO);
            }
        }
        return new ModelAndView().addObject("Employee not found");
    }

    /**
     * <p>
     *   Create employee by using the request get from user
     * </p>
     *
     * @param employeeDTO employee details get from user
     */
    @PostMapping("/add")
    public ModelAndView createEmployee(@ModelAttribute("employee") EmployeeDTO employeeDTO) {
//        ModelAndView modelAndView = new ModelAndView();
        String emailId = "";
        boolean isValid = false;

        do {
            List<String > emails = employeeServiceImpl.checkDuplicateEmail();
            String  email = EmployeeUtil.generateEmailByFirstNameAndLastName(
                    employeeDTO.getFirstName(), employeeDTO.getLastName());

            if (!emails.contains(email)) {
                String lastName = employeeDTO.getLastName() + EmployeeUtil.generateRandomID();
                EmployeeUtil.generateEmailByFirstNameAndLastName(
                        employeeDTO.getFirstName(), lastName);
                emailId = email;
                isValid = true;
            } else {
                logger.info("Email id already exists");
            }
        } while (!isValid);
        employeeDTO.setEmailId(emailId);
        int id = employeeServiceImpl.addEmployee(employeeDTO.getFirstName(), employeeDTO.getLastName(),
                employeeDTO.getGender(), employeeDTO.getDateOfBirth(), employeeDTO.getBloodGroup(),
                employeeDTO.getEmailId(), employeeDTO.getDateOfJoining(), employeeDTO.getAccountNumber(),
                employeeDTO.getIfscCode(), employeeDTO.getDesignation(), employeeDTO.getPreviousExperience(),
                employeeDTO.getSalary(), employeeDTO.getWorkPlace(), employeeDTO.getMobileNumbers(),
                employeeDTO.getAddresses());
        logger.info("Employee created with Id " + id);
        return new ModelAndView("show").addObject("message", "Employee Created");
    }

    /**
     * <p>
     *   Search employee by using id, when search
     *   found will display the details of that employee
     * </p>     
     *response.setContentType("text/html");
     */
    @GetMapping("/search/{id}")
    public ModelAndView searchEmployee(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        EmployeeDTO employeeDTO = employeeServiceImpl
                .searchEmployeeById(id);

        if (null != employeeDTO) {
            return printEmployee(employeeDTO);
        }
        logger.info("Employee not found");
        return modelAndView.addObject("error",
                "Employee not found");
    }  

    /**
     * <p>
     *   Used to update address 
     * </p>
     */
    @PostMapping("/updateEmployee")
    public ModelAndView updateEmployee(@ModelAttribute("employee") EmployeeDTO employeeDTO) {
        ModelAndView modelAndView = new ModelAndView();
        int id = employeeServiceImpl.updateEmployee(employeeDTO);
        logger.info("Employee id : " + id + " Updated ");
        return modelAndView.addObject("message", "Employee Updated");
    }

    /**
     * <p>
     *   Get the id to be deleted
     *   If id found, then will delete the details of the employee
     *   If not then return not found
     * </p>
     *
     */
    @GetMapping("/delete/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") int id) {
        EmployeeDTO employeeDTO = employeeServiceImpl.searchEmployeeById(id);

        if (null != employeeDTO) {

            if ( 0 != employeeServiceImpl.deleteEmployeeById(id)) {
                logger.info("Employee id : " + id + " deleted");
                return modelAndView.addObject("Employee deleted");
            }
        }
        return modelAndView.addObject("Employee not found, Unable to delete");
    }

    /**
     * <p>
     *   Print employee details 
     * </p>
     *
     * @param employeeDTO employee to be displayed
     */
    private ModelAndView printEmployee(EmployeeDTO employeeDTO) {
        ModelAndView modelAndView = new ModelAndView("display");
        return modelAndView.addObject("employee", employeeDTO);

    }
}

