/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2It
 * </p>
 */

package com.ideas2it.employeemanagement.repository;

import com.ideas2it.employeemanagement.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

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
public interface ProjectDAO extends JpaRepository<Project, Integer> {
}
