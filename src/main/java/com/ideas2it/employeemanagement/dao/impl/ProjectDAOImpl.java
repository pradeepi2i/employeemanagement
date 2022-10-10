/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2It
 * </p>
 */

package com.ideas2it.employeemanagement.dao.impl;

import com.ideas2it.employeemanagement.dao.ProjectDAO;
import com.ideas2it.employeemanagement.model.Project;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
@Repository
public class ProjectDAOImpl implements ProjectDAO {

    private Session session = null;
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * <p>
     *   Insert an project to the Map  
     * </p>
     *
     * @param project project to be inserted 
     * 
     * @return inserted id
     */
    @Transactional(rollbackFor = HibernateException.class)
    public Project insertProject(Project project) {
        session = sessionFactory.getCurrentSession();
        session.save(project);
        return project;
        /*
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

         */

    }

    /**
     * <p>
     *   Retrieve all projects
     * </p>
     *
     * @return projects all projects
     */

    public Map<Integer, Project> retrieveAllProjects() {
        /*
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
         */

        return null;
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
    @Transactional(rollbackFor = HibernateException.class, readOnly = true)
    public Project retrieveProjectById(int id) {
        return sessionFactory.getCurrentSession().get(Project.class, id);
        /*
        session = sessionFactory.openSession();
        try {
            project = session.get(Project.class,id); 
        } catch (HibernateException hibernateException) {
            throw new CustomException("Error in retrieve project" + id, hibernateException);
        }
        finally {
            session.close();            
        }

         */
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
    @Transactional(rollbackFor = HibernateException.class)
    public Project updateProject(Project project) {
        sessionFactory.getCurrentSession().update(project);
        /*
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

         */
        return project;
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
    @Transactional(rollbackFor = HibernateException.class)
    public int deleteProjectById(int id) {
        session = sessionFactory.getCurrentSession();
        Project project = session.get(Project.class, id);
        session.delete(project);
        return id;

        /*
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

         */
    }     

}
