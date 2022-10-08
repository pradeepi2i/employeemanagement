package com.ideas2it.employeemanagement.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;
    private double cost;
    @Column(name = "project_name")
    private String name;
    private String domain;
    private String description;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_project",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")})
    private Set<Employee> employees;

    public Project() {}

    public Project(String name, String domain,
            double cost, String description) {
        this.name = name;
        this.domain = domain;
        this.cost = cost;
        this.description = description;
    }

    // setters and getters

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
        return this.description;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    } 
}
