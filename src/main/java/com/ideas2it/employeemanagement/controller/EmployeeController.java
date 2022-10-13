/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.controller;

import com.ideas2it.employeemanagement.dto.EmployeeDTO;
import com.ideas2it.employeemanagement.dto.ProjectDTO;
import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.model.Mobile;
import com.ideas2it.employeemanagement.service.EmployeeService;
import com.ideas2it.employeemanagement.util.EmployeeUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class EmployeeController {

    private EmployeeService employeeService;
    private static Logger logger = LoggerConfiguration
            .getInstance("EmployeeController.class");

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("employee")
    public ModelAndView employeeDirect() {
        return new ModelAndView("/employee");
    }

    @PostMapping("create")
    public ModelAndView addEmployee() {
        return new ModelAndView("/CreateEmployee")
                .addObject("employeeDTO", new EmployeeDTO())
                .addObject("employeeDTO", new Mobile())
                .addObject("employeeDTO", new Address());
    }

    /**
     * <p>
     *   Create employee by using the request get from user
     * </p>
     *
     * @param employeeDTO employee details get from user
     */
    @PostMapping("add")
    public ModelAndView createEmployee(@ModelAttribute("employeeDTO")
            EmployeeDTO employeeDTO, Mobile mobile, Address address) {
        List<Mobile> mobiles = new ArrayList<>();
        Set<Address> addresses = new HashSet<>();
        mobiles.add(mobile);
        addresses.add(address);
        employeeDTO.setMobileNumbers(mobiles);
        employeeDTO.setAddresses(addresses);
        int id = employeeService.addEmployee(employeeDTO);
        logger.info("Employee created with Id " + id);
        return new ModelAndView("Display")
                .addObject("message", "Employee Created with Id")
                .addObject("id", id);
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
            return printEmployee(employeeDTO);

        }
        return new ModelAndView("/Display").addObject("message",
                "Employee not found")
                .addObject("id", id);
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
                return new ModelAndView("/modifyEmployee")
                        .addObject("employeeDTO", employeeDTO);
            }
        }
        return new ModelAndView("/Display")
                .addObject("message", "Employee not found")
                .addObject("id", id);
    }

    /**
     * <p>
     *   Used to update address 
     * </p>
     */
    @PostMapping("updateEmployee")
    public ModelAndView updateEmployee(@ModelAttribute("employeeDTO")
                                           EmployeeDTO employeeDTO) {
        int id = employeeService.updateEmployee(employeeDTO);
        logger.info("Employee id : " + id + " Updated ");
        return new ModelAndView("/Display")
                .addObject("message", "Employee Updated")
                .addObject("id", id);
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
                return new ModelAndView("/Display")
                        .addObject("message", "Employee deleted")
                        .addObject("id", id);
            }
        }
        return new ModelAndView("/Display")
                .addObject("message", "Employee not found, Unable to delete")
                .addObject("id", id);
    }

    /**
     * <p>
     *   Print employee details 
     * </p>
     *
     * @param employeeDTO employee to be displayed
     */
    private ModelAndView printEmployee(EmployeeDTO employeeDTO) {
        ModelAndView modelAndView = new ModelAndView("ViewEmployee");
        modelAndView.addObject("employeeDTO", employeeDTO)
                .addObject("message", "Display Employee Details ")
                .addObject("id", employeeDTO.getId());
        if (null != employeeDTO.getMobileNumbers()) {
            List<Mobile> mobiles = employeeDTO.getMobileNumbers();
            modelAndView.addObject("mobiles", mobiles);
        }

        if (null != employeeDTO.getAddresses()) {
            modelAndView.addObject("address", employeeDTO.getAddresses());
        }

        if (null != employeeDTO.getWorkPlace()) {
            modelAndView.addObject("work", employeeDTO.getWorkPlace().getWorkPlaceId());
        }

        Set<ProjectDTO> projects = employeeDTO.getProjects();
        if (null != projects && (!projects.isEmpty())) {
            modelAndView.addObject("projects", projects);
        } else {
            modelAndView.addObject("message", "Doesn't worked on any projects");
        }
        return modelAndView;
    }
}

