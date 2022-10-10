/*
 * <p>
 *   Copyright (c) All rights reserved
 * </p>
 */

package com.ideas2it.employeemanagement.controller;

import com.ideas2it.employeemanagement.dto.EmployeeDTO;
import com.ideas2it.employeemanagement.dto.ProjectDTO;
import com.ideas2it.employeemanagement.logger.LoggerConfiguration;
import com.ideas2it.employeemanagement.service.EmployeeService;
import com.ideas2it.employeemanagement.service.ProjectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *   Implemented to create a new project or search, update, and delete
 *   existing project 
 * </p>
 *
 * <p>  
 *   This file is created on 29/08/2022
 *   @author : Pradeep
 * </p>
 */
@RestController
@RequestMapping("management/project")
public class ProjectController {

    private EmployeeService employeeService;
    private ProjectService projectService;
    private static final Logger logger = LoggerConfiguration
            .getInstance("ProjectController.class");

    public ProjectController(EmployeeService employeeService,
                             ProjectService projectService) {
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    //@PostMapping(value = "project/create")
    @RequestMapping("/project/create")
    public ModelAndView addProject() {
        return new ModelAndView("/createProject");
    }

    /**
     * <p>
     *   Create Project by using the information get from user
     * </p>
     *
     * @param projectDTO project details get from the user
     */
    @PostMapping("addProject")
    public ModelAndView createProject(@ModelAttribute("projectDTO") ProjectDTO projectDTO) {
        int id = projectService.addProject(projectDTO.getName(), projectDTO.getDomain(),
                projectDTO.getCost(), projectDTO.getDescription());
        logger.info("Project Id created " + id);
        return new ModelAndView("/addProject").addObject("message", id);
    }

    /**
     * <p>
     *   Search project by using id, when search
     *   found will display the details of that project
     * </p>
     *
     */
    @GetMapping("searchProject")
    public ModelAndView searchProject(@RequestParam("id") int id) {
        ProjectDTO projectDTO = projectService
                .searchProjectById(id);

        if (null != projectDTO) {
            // return printProject(projectDTO);
            return new ModelAndView("/searchProject").addObject("projectDTO", projectDTO);
        }
        logger.info("Project not found");
        return new ModelAndView("/searchProject").addObject("error",
                "Project not found");
    }


    /**
     * <p>
     *   Used to assign employee to project
     * </p> 
     *
     */
    @GetMapping("assign")
    public ModelAndView assignEmployee(@RequestParam("id") int id,
            @RequestParam("employeeId") int employeeId) {
        ModelAndView modelAndView = new ModelAndView("/addProject");

        ProjectDTO projectDTO = projectService.searchProjectById(id);
        Set<EmployeeDTO> employees;
        Set<ProjectDTO> projects;

        if (null != projectDTO) {
            EmployeeDTO employeeDTO = employeeService
                    .searchEmployeeById(employeeId);

            if (null != employeeDTO) {

                if (null != projectDTO.getEmployees()) {
                    employees = projectDTO.getEmployees();
                    employees.add(employeeDTO);
                } else {
                    employees = new HashSet<>();
                    employees.add(employeeDTO);
                }

                /*if (null != employeeDTO.getProjects()) {
                    projects = employeeDTO.getProjects();
                    projects.add(projectDTO);
                } else {
                    projects = new HashSet<>();
                    projects.add(projectDTO);
                }*/
                projectDTO.setEmployees(employees);
                //employeeDTO.setProjects(projects);
                id = projectService.updateProject(projectDTO);
                employeeId = employeeService
                        .updateEmployee(employeeDTO);
                logger.info("Project " + id + " assigned to Employee "
                        + employeeId);
                return modelAndView.addObject("message", "Assigned Successfully");
            }
            logger.info("No employee found");
            return modelAndView.addObject("error", "Employee not found");
        }
        logger.info("Project not found");
        return modelAndView.addObject("error", "Project not found");
    }

    /**
     * <p>
     *   Used to forward the employeeDTO along with
     *   request object through request dispatcher
     * </p>
     *
     * @param id id to be updated
     */
    @GetMapping("modifyProject")
    private ModelAndView updateDispatch(@RequestParam("id") int id) {
        if (0 != id) {
            ProjectDTO projectDTO = projectService
                    .searchProjectById(id);

            if (null != projectDTO) {
                return new ModelAndView("/modifyProject").addObject("projectDTO", projectDTO);
            }
        }
        return new ModelAndView("/addProject").addObject("message", "Project not found");
    }

    /**
     * <p>
     *   Update employee using id, if found then do function call,
     *   which takes trainee as a parameter
     *   If not then return not found
     * </p> 
     *
     */
    //@PostMapping(value = "updateProject")
    public ModelAndView updateProject(@ModelAttribute("projectDTO") ProjectDTO projectDTO) {
        int id = projectService.updateProject(projectDTO);
        logger.info("Project id : " + id + " Updated ");
        return new ModelAndView("/addProject").addObject("message", "Project Updated");
    }
 
    /**
     * <p>
     *   Get the id to be deleted
     *   If id found, then will delete the details of the project
     *   If not then return not found
     * </p>          
     *
     */
    @RequestMapping(value = "deleteProject")
    public ModelAndView deleteProject(@RequestParam("id") int id) {
        ProjectDTO projectDTO = projectService.searchProjectById(id);
        ModelAndView modelAndView = new ModelAndView("/addProject");
      
        if (null != projectDTO) {

            if (0 != projectService.deleteProjectById(id)) {
                logger.info("Project id : " + id + " deleted");
                return modelAndView.addObject("message", "Project deleted");
            }
        }
        return modelAndView.addObject("error",
                "Project not found, Unable to delete");
    }

    /**
     * <p>
     *   Print employee details 
     * </p>
     */
    private ModelAndView printProject(ProjectDTO projectDTO) {
        ModelAndView modelAndView = new ModelAndView("display");
        return modelAndView.addObject("projectDTO", projectDTO);
    }
}
