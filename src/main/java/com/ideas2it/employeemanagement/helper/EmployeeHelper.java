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
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setGender(employee.getGender());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth());
        employeeDTO.setBloodGroup(employee.getBloodGroup());
        employeeDTO.setEmailId(employee.getEmailId());
        employeeDTO.setDateOfJoining(employee.getDateOfJoining());
        employeeDTO.setAccountNumber(employee.getAccountNumber());
        employeeDTO.setIfscCode(employee.getIfscCode());
        employeeDTO.setDesignation(employee.getDesignation());
        employeeDTO.setPreviousExperience(employee.getPreviousExperience());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setWorkPlace(employee.getWorkPlace());
        employeeDTO.setMobileNumbers(employee.getMobileNumbers());
        employeeDTO.setAddresses(employee.getAddresses());
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
          //  employeeDTO.setProjects(projectsDTO);
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
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setBloodGroup(employeeDTO.getBloodGroup());
        employee.setEmailId(employeeDTO.getEmailId());
        employee.setDateOfJoining(employeeDTO.getDateOfJoining());
        employee.setAccountNumber(employeeDTO.getAccountNumber());
        employee.setIfscCode(employeeDTO.getIfscCode());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setPreviousExperience(employeeDTO.getPreviousExperience());
        employee.setSalary(employeeDTO.getSalary());
        employee.setWorkPlace(employeeDTO.getWorkPlace());
        employee.setMobileNumbers(employeeDTO.getMobileNumbers());
        employee.setAddresses(employeeDTO.getAddresses());
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
