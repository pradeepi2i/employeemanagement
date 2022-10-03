/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2It
 * </p>
 */

package com.ideas2it.employeemanagement.dao;

import com.ideas2it.employeemanagement.model.Project;

import java.util.Map;

/**
 * <p>
 *   Interface that contains abstract methods
 *   create, search, update and delete an project
 * </p>
 *
 * <p>  
 *   This file is created on 06/08/2022
 *   @author : Pradeep
 * </p>
 *
 */
public interface ProjectDAO {

    /**
     * <p>
     *   Insert an project to the Map  
     * </p>
     *
     * @param project project to be inserted 
     * 
     * @return inserted id
     */
    public Project insertProject(Project project);

    /**
     * <p>
     *   Retrieve all projects
     * </p>
     *
     * @return projects all projects
     */
    public Map<Integer, Project> retrieveAllProjects();

    /**
     * <p>
     *   Get the project id and find the object through key
     * </p>
     *    
     * 
     * @param id id of the project to be searched
     * 
     * @return project by searching id 
     * 
     */ 
    public Project retrieveProjectById(int id);

    /**
     * <p>
     *   Modify the project details by using the object 
     *
     *   Set the new one instead of existing object      
     * </p>
     *    
     * @param project updated project  
     * 
     * @return updated id
     * 
     */
    public Project updateProject(Project project);

    /**
     * <p>
     *   Delete the project details by using their id  
     * </p>
     *    
     * @param id the id to be deleted     
     * 
     * @return deleted id 
     * 
     */
    public int deleteProjectById(int id);
 
}

