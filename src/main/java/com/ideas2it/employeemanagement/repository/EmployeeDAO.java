/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.repository;

import com.ideas2it.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *   Interface that contains abstract methods
 *   create, search, update and delete an employee
 * </p>
 *
 * <p>  
 *   This file is created on 06/08/2022
 *   @author : Pradeep
 * </p>
 *
 */
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
}



