/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2It
 * </p>
 */

package com.ideas2it.employeemanagement.dao.impl;

import com.ideas2it.employeemanagement.connection.HibernateConfiguration;
import com.ideas2it.employeemanagement.dao.ProjectDAO;
import com.ideas2it.employeemanagement.exception.CustomException;
import com.ideas2it.employeemanagement.model.Project;
import org.hibernate.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *   Implementation to save, search, update, and delete
 *   existing project details to Map
 * </p>Integer, Project
 *
 * <p>  
 *   This file is created on 06/08/2022
 *   @author : Pradeep
 * </p>
 */
public class ProjectDAOImpl implements ProjectDAO {     
    
    private SessionFactory sessionFactory = HibernateConfiguration
            .getInstance().getSessionFactory();
    private Session session = null;
    private Transaction transaction = null;

    /**
     * <p>
     *   Insert an project to the Map  
     * </p>
     *
     * @param project project to be inserted 
     * 
     * @return inserted id
     */
    public Project insertProject(Project project) {
        session = sessionFactory.openSession();
        try { 
            transaction = session.beginTransaction();                         
            session.save(project);

            if (session.contains(project)) {
                transaction.commit();
                return project;
            }
        } catch (HibernateException hibernateException) {

            if (transaction != null) {
                transaction.rollback();
            }
            throw new CustomException("Error in inserting project", hibernateException);
        }
        finally {
            session.close();            
        }
        return null;
    }

    /**
     * <p>
     *   Retrieve all projects
     * </p>
     *
     * @return projects all projects
     */
    public Map<Integer, Project> retrieveAllProjects() {
        Map<Integer, Project> projects = new LinkedHashMap<>();
        session = sessionFactory.openSession(); 
        try {
            Query query = session.createQuery("from Project");
            List<Project> results = query.list();  
            
            for (Project project : results) {
                projects.put(project.getId(), project);
            }            
        } catch (HibernateException hibernateException) {
            throw new CustomException("Error in retrieving project", hibernateException);
        }
        finally {
            session.close();            
        } 

        return projects; 
    }
    
    /**
     * <p>
     *   Get the project id and find the object through key
     * </p>
     * 
     * @param id id of the project to be searched
     * 
     * @return project by searching id 
     * 
     */  
    public Project retrieveProjectById(int id) {
        Project project = null; 
        session = sessionFactory.openSession();
        try {
            project = session.get(Project.class,id); 
        } catch (HibernateException hibernateException) {
            throw new CustomException("Error in retrieve project" + id, hibernateException);
        }
        finally {
            session.close();            
        }
        return project;             
    }

    /**
     * <p>
     *   Modify the project details by using the object
     *   Set the new one instead of existing object      
     * </p>
     *    
     * @param project updated project  
     * 
     * @return updated id
     * 
     */
    public Project updateProject(Project project) {
        session = sessionFactory.openSession();
        try {           
            transaction = session.beginTransaction();        
            session.update(project);
            transaction.commit();
            return project;
        } catch (HibernateException hibernateException) {
            
            if (transaction != null) {
                transaction.rollback();
            }
            throw new CustomException("Error in update project", hibernateException);
        }
        finally {
            session.close();            
        }
    }

    /**
     * <p>
     *   Delete the project details by using their id  
     * </p>
     *    
     * @param id the id to be deleted     
     * projectHelper
     * @return deleted id 
     * 
     */
    public int deleteProjectById(int id) {
        session = sessionFactory.openSession(); 
        try {  
            transaction = session.beginTransaction();        
            Project project = session.get(Project.class, id);

            if (null != project) {
                session.delete(project);
                transaction.commit();
                return id;
            }
        } catch (HibernateException hibernateException) {
            
            if (transaction != null) {
                transaction.rollback();
            }
            throw new CustomException("Error in delete project" + id, hibernateException);
        }
        finally {
            session.close();            
        }
        return 0;
    }     

}
