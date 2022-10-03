/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2It
 * </p>
 */

package com.ideas2it.employeemanagement.dto;

import java.util.Set;

/**
 * <p>
 *   Contains all possible information that are applicable to project
 * </p>
 *
 * <p>  
 *   This file is created on 20/08/2022
 *   @author : Pradeep
 * </p>
 */
public class ProjectDTO {

    private int id;
    private double cost;
    private String name;
    private String domain;
    private String description;
    private Set<EmployeeDTO> employees;

    public ProjectDTO() {}
    public ProjectDTO(String name, String domain,
            double cost, String description) {
        this.name = name;
        this.domain = domain;
        this.cost = cost;
        this.description = description;
    }

    //setters and getters

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    public double getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEmployees(Set<EmployeeDTO> employees) {
        this.employees = employees;
    }

    public Set<EmployeeDTO> getEmployees() {
        return employees;
    } 

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return  stringBuilder.append("<br>Project Details <br>")
                .append("<br>  Project Id : ").append(getId())
                .append("<br>  Project Name : ").append(getName())
                .append("<br>  Project Domain : ").append(getDomain())
                .append("<br>  Description of the Project : ")
                .append(getDescription()).toString();
    }
}
