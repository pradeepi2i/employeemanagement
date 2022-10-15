/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *   Contains basic information that are common to all employees 
 * </p>
 *
 * <p>  
 *   This file is created on 27/07/2022
 *   @author : Pradeep
 * </p>
 */
@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "company_name")
    protected static String companyName = "Ideas2IT";
    @Column(name = "bank_name")
    protected static String bankName = "HDFC";
    @Column(name = "previous_experience")
    private float previousExperience;
    @Column(name = "salary")
    private float salary;
    @Column(name = "account_number")
    private long accountNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String gender;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "blood_group")
    private String bloodGroup;
    @Column(name = "e_mail")
    private String emailId;
    @Column(name = "date_of_joining")
    private LocalDate dateOfJoining;
    @Column(name = "ifsc_code")
    private String ifscCode; 
    private String designation;
    @OneToOne(targetEntity = WorkPlace.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "work_id")
    private WorkPlace workPlace;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Mobile> mobileNumbers;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Set<Address> addresses;
    @ManyToMany(mappedBy = "employees", fetch = FetchType.EAGER)
    private Set<Project> projects;

    
}
