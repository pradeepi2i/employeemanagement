/*
 * <p>
 *   Copyright (c) All rights reserved
 * </p>
 */

package com.ideas2it.employeemanagement.service;

import com.ideas2it.employeemanagement.dto.ProjectDTO;

import java.util.Map;

/**
 * <p>
 *   Interface that contains abstract and static methods
 *   create, search, update and delete an employee
 * </p>
 *
 * <p>  
 *   This file is created on 02/08/2022
 *   @author : Pradeep
 * </p>
 *
 */
public interface ProjectService {
 
    /**
     * <p>
     *   Add a employee by getting the following details
     * </p>
     *
     * @param projectName project name 
     * @param domain project's domain
     * @param description project's description 
     * @param cost project's cost
     *
     * @return created id 
     */
    public int addProject(String projectName, String domain, double cost,
            String description);  //Set<EmployeeDTO> employees

    /**
     * <p>
     *   Get all projects
     * </p>
     *
     * @return all projects
     */
    public Map<Integer, ProjectDTO> displayAllProjects();

    /**
     * <p>
     *   Get the project, searched by using id 
     * </p>   
     *
     * @param id id to be searched
     *
     * @return project by searching id from map
     *
     */
    public ProjectDTO searchProjectById(int id);

    /**
     * <p>
     *   Update the project by employee object 
     * </p>   
     *
     * @param projectDTO updated project to be replaced
     *
     * @return updated id
     *
     */
    public int updateProject(ProjectDTO projectDTO);
   
    /**
     * <p>
     *   Delete the project by id 
     * </p>          
     *
     * @param id id to be deleted
     *
     * @return deleted id
     *
     */
    public int deleteProjectById(int id);
}


