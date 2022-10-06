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
public class ProjectController {

    private final EmployeeService employeeServiceImpl;

    private final ProjectService projectServiceImpl;
    private static Logger logger = LoggerConfiguration
            .getInstance("ProjectController.class");

    @Autowired
    public ProjectController(EmployeeService employeeServiceImpl,
                             ProjectService projectServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
        this.projectServiceImpl = projectServiceImpl;
    }

    //@PostMapping(value = "project/create")
    @RequestMapping(value = "/project/create", method = RequestMethod.GET)
    public ModelAndView addProject() {
        return new ModelAndView("createProject","project", new ProjectDTO());
    }

    /**
     * <p>
     *   Create Project by using the information get from user
     * </p>
     *
     * @param projectDTO project details get from the user
     */
    @PostMapping(value = "/project/addProject")
    public void createProject(@ModelAttribute("project") ProjectDTO projectDTO) {
        //ModelAndView modelAndView = new ModelAndView();
        int id = projectServiceImpl.addProject(projectDTO.getName(), projectDTO.getDomain(),
                projectDTO.getCost(), projectDTO.getDescription());
        logger.info("Project Id created " + id);
        //return modelAndView.addObject("message", "Project Created");
    }

    /**
     * <p>
     *   Used to assign employee to project
     * </p> 
     *
     */
    @GetMapping(value = "project/assign/{id}/{employeeId}")
    public ModelAndView assignEmployee(@PathVariable("id") int id,
            @PathVariable("employeeId") int employeeId) {
        ModelAndView modelAndView = new ModelAndView();

        ProjectDTO projectDTO = projectServiceImpl.searchProjectById(id);
        Set<EmployeeDTO> employees;
        Set<ProjectDTO> projects;

        if (null != projectDTO) {
            EmployeeDTO employeeDTO = employeeServiceImpl
                    .searchEmployeeById(employeeId);

            if (null != employeeDTO) {

                if (null != projectDTO.getEmployees()) {
                    employees = projectDTO.getEmployees();
                    employees.add(employeeDTO);
                } else {
                    employees = new HashSet<>();
                    employees.add(employeeDTO);
                }

                if (null != employeeDTO.getProjects()) {
                    projects = employeeDTO.getProjects();
                    projects.add(projectDTO);
                } else {
                    projects = new HashSet<>();
                    projects.add(projectDTO);
                }
                projectDTO.setEmployees(employees);
                employeeDTO.setProjects(projects);
                id = projectServiceImpl.updateProject(projectDTO);
                employeeId = employeeServiceImpl
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
     *   Search project by using id, when search
     *   found will display the details of that project
     * </p>     
     *
     */
    @GetMapping(value = "/project/searchProject/{id}")
    public ModelAndView searchProject(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        ProjectDTO projectDTO = projectServiceImpl
                .searchProjectById(id);
        logger.info("In search project URL");

        if (null != projectDTO) {
            return printProject(projectDTO);
        }
        logger.info("Project not found");
        return modelAndView.addObject("error",
                "Project not found");
    }

    /**
     * <p>
     *   Used to forward the employeeDTO along with
     *   request object through request dispatcher
     * </p>
     *
     * @param id id to be updated
     */
    @GetMapping(value = "project/modifyProject/{id}")
    private ModelAndView updateDispatch(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();

        if (0 != id) {
            ProjectDTO projectDTO = projectServiceImpl
                    .searchProjectById(id);

            if (null != projectDTO) {
                modelAndView = new ModelAndView("modifyProject");
                modelAndView.addObject("project", projectDTO);
            }
        }
        return modelAndView.addObject("error", "Project not found");
    }

    /**
     * <p>
     *   Update employee using id, if found then do function call,
     *   which takes trainee as a parameter
     *   If not then return not found
     * </p> 
     *
     */
    @PostMapping(value = "project/updateProject")
    public ModelAndView updateProject(@ModelAttribute("project") ProjectDTO projectDTO) {
        ModelAndView modelAndView = new ModelAndView();
        int id = projectServiceImpl.updateProject(projectDTO);
        logger.info("Project id : " + id + " Updated ");
        return modelAndView.addObject("message", "Project Updated");
    }
 
    /**
     * <p>
     *   Get the id to be deleted
     *   If id found, then will delete the details of the project
     *   If not then return not found
     * </p>          
     *
     */
    @GetMapping(value = "project/deleteProject/{id}")
    public ModelAndView deleteProject(@PathVariable("id") int id) {
        ProjectDTO projectDTO = projectServiceImpl.searchProjectById(id);
        ModelAndView modelAndView = new ModelAndView();
      
        if (null != projectDTO) {

            if (0 != projectServiceImpl.deleteProjectById(id)) {
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
        ModelAndView modelAndView = new ModelAndView("display.jsp");
        return modelAndView.addObject("project", projectDTO);
    }
}
