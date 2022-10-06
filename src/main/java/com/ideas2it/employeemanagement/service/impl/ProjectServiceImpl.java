/*
 * <p>
 *   Copyright (c) All rights reserved
 * </p>
 */

package com.ideas2it.employeemanagement.service.impl;

import com.ideas2it.employeemanagement.dao.ProjectDAO;
import com.ideas2it.employeemanagement.dto.ProjectDTO;
import com.ideas2it.employeemanagement.helper.ProjectHelper;
import com.ideas2it.employeemanagement.model.Project;
import com.ideas2it.employeemanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *   Implementation to save new employee or search,
 *   update, and delete existing employee details
 * </p>
 *
 * <p>  
 *   This file is created on 02/08/2022
 *   @author : Pradeep
 * </p>
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDAO projectDAOImpl;

    public ProjectServiceImpl(ProjectDAO projectDAOImpl) {
        this.projectDAOImpl = projectDAOImpl;
    }
    
    /**
     * <p>
     *   Add a project by getting the following details
     * </p>
     *
     * @param projectName project name 
     * @param domain project's domain
     * @param description project's description 
     * @param cost project's
     * @return created id 
     */
    public int addProject(String projectName, String domain, double cost,
            String description) {
        ProjectDTO projectDTO = new ProjectDTO(projectName, domain,
                cost, description);  
        Project project = projectDAOImpl.insertProject(ProjectHelper
                                  .convertProjectDTOIntoProject(
                                  projectDTO));

        if (null != project) {
            return project.getId();
        }
        return 0;
    }

    /**
     * <p>
     *   Get all projects
     * </p>
     *
     * @return all projects
     */
    public Map<Integer, ProjectDTO> displayAllProjects() {
        return projectDAOImpl.retrieveAllProjects().entrySet().stream()
                .collect(Collectors.toMap(project -> project.getKey(),
                project -> ProjectHelper
                .convertProjectIntoProjectDTO(project.getValue())));
    }

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
    public ProjectDTO searchProjectById(int id) {
        Project project = projectDAOImpl.retrieveProjectById(id);   
        return (null != project) 
                ? ProjectHelper.convertProjectIntoProjectDTO(project)
                : null;
    } 

    /**
     * <p>
     *   Update the project by project object 
     * </p>   
     *
     * @param projectDTO updated project to be replaced
     *
     * @return updated id
     *
     */
    public int updateProject(ProjectDTO projectDTO) {
        Project project = projectDAOImpl.updateProject(ProjectHelper
                                  .convertProjectDTOIntoProject(
                                  projectDTO));

        if (null != project) {
            return project.getId();
        }
        return 0;
    }

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
    public int deleteProjectById(int id) {
        return projectDAOImpl.deleteProjectById(id);            
    }

}
