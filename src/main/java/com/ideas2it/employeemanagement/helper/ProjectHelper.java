/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2It
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
public class ProjectHelper {        

    /**
     * <p>
     *   Used to convert project into projectDTO
     * </p>
     *
     * @param project project to be converted 
     * @return converted project
     */
    public static ProjectDTO convertProjectIntoProjectDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO(
                project.getName(), project.getDomain(),
                project.getCost(), project.getDescription());        
        projectDTO.setId(project.getId());
        Set<EmployeeDTO> employeesDTO = new HashSet<>();
        Set<Employee> employees = project.getEmployees();

        if (null != employees) {

            for (Employee employee : employees) {
                EmployeeDTO employeeDTO = new EmployeeDTO(
                        employee.getFirstName(), employee.getLastName(),
                        employee.getGender(), employee.getDateOfBirth(),
                        employee.getBloodGroup(), employee.getEmailId(),
                        employee.getDateOfJoining(),
                        employee.getAccountNumber(), employee.getIfscCode(),
                        employee.getDesignation(),
                        employee.getPreviousExperience(), employee.getSalary(),
                        employee.getWorkPlace(), employee.getMobileNumbers(),
                        employee.getAddresses());
                employeeDTO.setId(employee.getId());
                employeesDTO.add(employeeDTO);               
            }
            projectDTO.setEmployees(employeesDTO);
        }
        return projectDTO;
    }

    /**
     * <p>
     *   Used to convert projectDTO into project
     * </p>
     *
     * @param projectDTO projectDTO to be converted 
     * @return converted project
     */
    public static Project convertProjectDTOIntoProject(ProjectDTO projectDTO) {
        Project project = new Project(
                projectDTO.getName(), projectDTO.getDomain(),
                projectDTO.getCost(), projectDTO.getDescription());
        project.setId(projectDTO.getId());
        Set<Employee> employees = new HashSet<>();
        Set<EmployeeDTO> employeesDTO = projectDTO.getEmployees();

        if (null != employeesDTO) {

            for (EmployeeDTO employeeDTO : employeesDTO) {       
                Employee employee = new Employee(
                        employeeDTO.getFirstName(), employeeDTO.getLastName(),
                        employeeDTO.getGender(), employeeDTO.getDateOfBirth(),
                        employeeDTO.getBloodGroup(), employeeDTO.getEmailId(),
                        employeeDTO.getDateOfJoining(), 
                        employeeDTO.getAccountNumber(),
                        employeeDTO.getIfscCode(), employeeDTO.getDesignation(), 
                        employeeDTO.getPreviousExperience(),
                        employeeDTO.getSalary(), employeeDTO.getWorkPlace(),
                        employeeDTO.getMobileNumbers(), 
                        employeeDTO.getAddresses());
                employee.setId(employeeDTO.getId());
                employees.add(employee);
            }
            project.setEmployees(employees);
        }
        return project;
    }
}
