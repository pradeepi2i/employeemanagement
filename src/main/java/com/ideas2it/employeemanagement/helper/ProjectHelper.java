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
import com.ideas2it.employeemanagement.util.EmployeeUtil;

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
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setId(employee.getId());
                employeeDTO.setFirstName(employee.getFirstName());
                employeeDTO.setLastName(employee.getLastName());
                employeeDTO.setGender(employee.getGender());
                employeeDTO.setDateOfBirth(employee.getDateOfBirth().toString());
                employeeDTO.setBloodGroup(employee.getBloodGroup());
                employeeDTO.setEmailId(employee.getEmailId());
                employeeDTO.setDateOfJoining(employee.getDateOfJoining().toString());
                employeeDTO.setAccountNumber(employee.getAccountNumber());
                employeeDTO.setIfscCode(employee.getIfscCode());
                employeeDTO.setDesignation(employee.getDesignation());
                employeeDTO.setPreviousExperience(employee.getPreviousExperience());
                employeeDTO.setSalary(employee.getSalary());
                employeeDTO.setWorkPlace(employee.getWorkPlace());
                employeeDTO.setMobileNumbers(employee.getMobileNumbers());
                employeeDTO.setAddresses(employee.getAddresses());
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
                Employee employee = new Employee();
                employee.setId(employeeDTO.getId());
                employee.setFirstName(employeeDTO.getFirstName());
                employee.setLastName(employeeDTO.getLastName());
                employee.setGender(employeeDTO.getGender());
                employee.setDateOfBirth(EmployeeUtil.convertToDate(employeeDTO.getDateOfBirth()));
                employee.setBloodGroup(employeeDTO.getBloodGroup());
                employee.setEmailId(employeeDTO.getEmailId());
                employee.setDateOfJoining(EmployeeUtil.convertToDate(employeeDTO.getDateOfJoining()));
                employee.setAccountNumber(employeeDTO.getAccountNumber());
                employee.setIfscCode(employeeDTO.getIfscCode());
                employee.setDesignation(employeeDTO.getDesignation());
                employee.setPreviousExperience(employeeDTO.getPreviousExperience());
                employee.setSalary(employeeDTO.getSalary());
                employee.setWorkPlace(employeeDTO.getWorkPlace());
                employee.setMobileNumbers(employeeDTO.getMobileNumbers());
                employee.setAddresses(employeeDTO.getAddresses());
                employees.add(employee);
            }
            project.setEmployees(employees);
        }


        return project;
    }
}
