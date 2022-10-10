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
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeService employeeService;
    private static Logger logger = LoggerConfiguration
            .getInstance("EmployeeController.class");

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

/*
    @GetMapping("create")
    public ModelAndView addEmployee() {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView.addObject("employeeDTO", new EmployeeDTO());
    }
*/

    /**
     * <p>
     *   Create employee by using the request get from user
     * </p>
     *
     * @param employeeDTO employee details get from user
     */
    @PostMapping("add")
    public ModelAndView createEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
        logger.info(employeeDTO);
        /*String emailId = "";
        boolean isValid = false;

        do {
            List<String > emails = employeeService.checkDuplicateEmail();
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
        employeeDTO.setEmailId(emailId);*/
        int id = employeeService.addEmployee(employeeDTO);

        /*int id = employeeService.addEmployee(employeeDTO.getFirstName(), employeeDTO.getLastName(),
                employeeDTO.getGender(), employeeDTO.getDateOfBirth(), employeeDTO.getBloodGroup(),
                employeeDTO.getEmailId(), employeeDTO.getDateOfJoining(), employeeDTO.getAccountNumber(),
                employeeDTO.getIfscCode(), employeeDTO.getDesignation(), employeeDTO.getPreviousExperience(),
                employeeDTO.getSalary(), employeeDTO.getWorkPlace(), employeeDTO.getMobileNumbers(),
                employeeDTO.getAddresses());
*/
        logger.info("Employee created with Id " + id);
        return new ModelAndView("addEmployee").addObject("message", "Employee Created");
    }

    /**
     * <p>
     *   Search employee by using id, when search
     *   found will display the details of that employee
     * </p>     
     *response.setContentType("text/html");
     */
    @GetMapping("search")
    public ModelAndView searchEmployee(@RequestParam("id") int id) {
        EmployeeDTO employeeDTO = employeeService
                .searchEmployeeById(id);

        if (null != employeeDTO) {
            return new ModelAndView("/searchEmployee").addObject("employeeDTO", employeeDTO);
          //  return printEmployee(employeeDTO);
        }
        logger.info("Employee not found");
        return new ModelAndView("/searchEmployee").addObject("error",
                "Employee not found");
    }

    /**
     * <p>
     *   Used to forward the employeeDTO along with
     *   request object through request dispatcher
     * </p>
     *
     * @param id id to be updated
     */
    @GetMapping("update")
    private ModelAndView updateDispatch(@RequestParam("id") int id) {
        if (0 != id) {
            EmployeeDTO employeeDTO = employeeService
                    .searchEmployeeById(id);

            if (null != employeeDTO) {
                return new ModelAndView("/modify").addObject("employeeDTO", employeeDTO);
            }
        }
        return new ModelAndView("/addEmployee").addObject("Employee not found");
    }

    /**
     * <p>
     *   Used to update address 
     * </p>
     */
    @PostMapping("updateEmployee")
    public ModelAndView updateEmployee(@ModelAttribute("employeeDTO") EmployeeDTO employeeDTO) {
        ModelAndView modelAndView = new ModelAndView();
        int id = employeeService.updateEmployee(employeeDTO);
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
    @GetMapping("delete")
    public ModelAndView deleteEmployee(@RequestParam("id") int id) {
        EmployeeDTO employeeDTO = employeeService.searchEmployeeById(id);

        if (null != employeeDTO) {

            if ( 0 != employeeService.deleteEmployeeById(id)) {
                logger.info("Employee id : " + id + " deleted");
                return new ModelAndView("/addEmployee").addObject("message", "Employee deleted");
            }
        }
        return new ModelAndView("/addEmployee").addObject("message", "Employee not found, Unable to delete");
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

