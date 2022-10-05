/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2It
 * </p>
 */

package com.ideas2it.employeemanagement.connection;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * <p>
 *   Implementation to singleton object inorder to avoid 
 *   creating multiple instances
 * </p>
 *
 * <p>  
 *   This file is created on 06/09/2022
 *   @author : Pradeep
 * </p>
 */
public class HibernateConfiguration {

    private static HibernateConfiguration hibernateConfiguration; 
    private static SessionFactory sessionFactory = null;
    
    private HibernateConfiguration() {   
        try {            
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
    }

    /** 
     * <p>
     *   Used to get singleton object
     * </p>
     *
     * @return created object
     *
     */
    public static HibernateConfiguration getInstance() {

        if (sessionFactory == null) {
            hibernateConfiguration = new HibernateConfiguration();
        }
        return hibernateConfiguration;
    }

    /** 
     * <p>
     *   Used to get session factory for the particular object
     * </p>
     *
     * @return session factory 
     *
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
