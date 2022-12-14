/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.dao.impl;

import com.ideas2it.employeemanagement.connection.HibernateConfiguration;
import com.ideas2it.employeemanagement.dao.EmployeeDAO;
import com.ideas2it.employeemanagement.exception.CustomException;
import com.ideas2it.employeemanagement.model.Employee;
import com.ideas2it.employeemanagement.model.Mobile;
import org.hibernate.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *   Implementation to save, search, update, and delete
 *   existing employee details to Map
 * </p>
 *
 * <p>  
 *   This file is created on 06/08/2022
 *   @author : Pradeep
 * </p>
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {   

    private SessionFactory sessionFactory = HibernateConfiguration
            .getInstance().getSessionFactory();
    private Session session = null;
    private Transaction transaction = null;

    /**
     * <p>
     *   Insert an employee to the Map  
     * </p>
     *
     * @param employee employee to be inserted 
     * 
     * @return inserted id
     */
    public Employee insertEmployee(Employee employee) {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(employee);

            if (session.contains(employee)) {
                transaction.commit();
                return employee;
            }
        } catch (HibernateException hibernateException) {

            if (null != transaction) {
                transaction.rollback();
            }
            throw new CustomException("Couldn't add employee", hibernateException);
        }
        finally {
            session.close();            
        }
        return null;
    }       

    /**
     * <p>
     *   Retrieve all employees
     * </p>
     *
     * @return employees all employees
     */
    public Map<Integer, Employee> retrieveAllEmployees() {
        Map<Integer, Employee> employees = new LinkedHashMap<>();
        session = sessionFactory.openSession();  
        try {      
            Query query = session.createQuery("from Employee");
            List<Employee> results = query.list();  
            
            for (Employee employee : results) {
                employees.put(employee.getId(), employee);
            }                 
        } catch (HibernateException hibernateException) {
            throw new CustomException("Error in retrieving employee", hibernateException);
        }
        finally {
            session.close();            
        }  
        return employees;  
    }
    
    /**
     * <p>
     *   Get the employee id and find the object through key
     * </p>
     * 
     * @param id id of the employee to be searched
     * 
     * @return employee by searching id 
     * 
     */  
    public Employee retrieveEmployeeById(int id) {
        session = sessionFactory.openSession();   
        Employee employee = null;
        try {                            
            employee = session.get(Employee.class,id);               
        } catch (HibernateException hibernateException) {
            throw new CustomException("Error in retrieve employee", hibernateException);
        }
        finally {
            session.close();            
        }
        return employee;                  
    }

    /**
     * <p>
     *   Modify the employee details by using the object 
     *
     *   Set the new one instead of existing object      
     * </p>
     *    
     * @param employee updated employee  
     * 
     * @return updated id
     * 
     */
    public Employee updateEmployee(Employee employee) {
        session = sessionFactory.openSession();
        try {           
            transaction = session.beginTransaction();        
            session.update(employee);
            transaction.commit();
        } catch (HibernateException hibernateException) {

            if (null != transaction) {
                transaction.rollback();
            }
            throw new CustomException("Error in employee update", hibernateException);
        }
        finally {
            session.close();            
        }
        return employee;
    }

    /**
     * <p>
     *   Delete the employee details by using their id  
     * </p>
     *    
     * @param id the id to be deleted     
     * 
     * @return deleted id 
     * 
     */
    public int deleteEmployeeById(int id) {
        session = sessionFactory.openSession();
        try {              
            transaction = session.beginTransaction();        
            Employee employee = session.get(Employee.class, id);

            if (null != employee) {
                session.delete(employee);
                transaction.commit();
                return id;
            }
        } catch (HibernateException hibernateException) {
            
            if (null != transaction) {
                transaction.rollback();
            }            
            throw new CustomException("Error in delete employee", hibernateException);
        }
        finally {
            session.close();            
        }
        return 0;
    }

    /**
     * <p>
     *   Check mobile number duplication
     * </p>
     *
     * @return list of mobile numbers
     */
    public List<Long> checkDuplicate() {
        session = sessionFactory.openSession();
        List<Long> mobileNumbers = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Mobile");
            List<Mobile> mobiles = query.list();

            for (Mobile mobile : mobiles) {
                mobileNumbers.add(mobile.getMobileNumber());
            }
            return mobileNumbers;
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        } finally {
            session.close();
        }
        return mobileNumbers;
    }

    /**
     * <p>
     *   Check email id duplication
     * </p>
     *
     * @return list of email id
     */
    public List<String> checkDuplicateEmail() {
        session = sessionFactory.openSession();
        List<String > emailIds = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Employee");
            List<Employee> employees = query.list();

            for (Employee employee : employees) {
                emailIds.add(employee.getEmailId());
            }
            return emailIds;
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        } finally {
            session.close();
        }
        return emailIds;
    }
}
