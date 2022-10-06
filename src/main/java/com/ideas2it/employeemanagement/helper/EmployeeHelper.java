/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.helper;

import com.ideas2it.employeemanagement.dto.EmployeeDTO;
import com.ideas2it.employeemanagement.dto.ProjectDTO;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Project;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *   Used to convert DTO to simple POJO and vice-versa
 * </p>
 *
 * <p>  
 *   This file is created on 21/08/2022
 *   @author : Pradeep
 * </p>
 */
public class EmployeeHelper {        

    /**
     * <p>
     *   Used to convert employee into employeeDTO
     * </p>
     *
     * @param employee employee to be converted 
     * @return converted employee
     */
    public static EmployeeDTO convertEmployeeIntoEmployeeDTO
            (Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getFirstName(), employee.getLastName(),
                employee.getGender(), employee.getDateOfBirth(),
                employee.getBloodGroup(), employee.getEmailId(),
                employee.getDateOfJoining(), employee.getAccountNumber(),
                employee.getIfscCode(), employee.getDesignation(),
                employee.getPreviousExperience(), employee.getSalary(),
                employee.getWorkPlace(), employee.getMobileNumbers(),
                employee.getAddresses());
        employeeDTO.setId(employee.getId());
        Set<ProjectDTO> projectsDTO = new HashSet<>();
        Set<Project> projects = employee.getProjects();

        if (null != projects) {

            for (Project project : projects) {   
                ProjectDTO projectHelperDTO = new ProjectDTO(
                        project.getName(), project.getDomain(),
                        project.getCost(), project.getDescription());
                projectHelperDTO.setId(project.getId());
                projectsDTO.add(projectHelperDTO);       
            }
            employeeDTO.setProjects(projectsDTO);
        }
        return employeeDTO;
    }

    /**
     * <p>
     *   Used to convert employeeDTO into employee
     * </p>
     *
     * @param employeeDTO employeeDTO to be converted 
     * @return converted employee
     */
    public static Employee convertEmployeeDTOIntoEmployee
            (EmployeeDTO employeeDTO) {       
        Employee employee = new Employee(
                employeeDTO.getFirstName(), employeeDTO.getLastName(),
                employeeDTO.getGender(), employeeDTO.getDateOfBirth(),
                employeeDTO.getBloodGroup(), employeeDTO.getEmailId(),
                employeeDTO.getDateOfJoining(), employeeDTO.getAccountNumber(),
                employeeDTO.getIfscCode(), employeeDTO.getDesignation(), 
                employeeDTO.getPreviousExperience(),
                employeeDTO.getSalary(), employeeDTO.getWorkPlace(),
                employeeDTO.getMobileNumbers(), employeeDTO.getAddresses());
        employee.setId(employeeDTO.getId());
        Set<Project> projects = new HashSet<>();
        Set<ProjectDTO> projectsDTO = employeeDTO.getProjects();

        if (null != projectsDTO) {

            for (ProjectDTO projectDTO : projectsDTO) {                 
                Project projectHelper = new Project(
                        projectDTO.getName(), projectDTO.getDomain(),
                        projectDTO.getCost(), projectDTO.getDescription());
                projectHelper.setId(projectHelper.getId());
                projects.add(projectHelper);     
            }
            employee.setProjects(projects);
        }        
        return employee;
    }
}
