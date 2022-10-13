/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

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

    // setters and getters

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {	
        return this.id;
    }

    public void setCompanyName(String companyName) {
        Employee.companyName = companyName;
    }   

    public String getCompanyName() {      
        return companyName;
    }

    public void setBankName(String bankName) {
        Employee.bankName = bankName;
    }   

    public String getBankName() {      
        return bankName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }   

    public String getFirstName() {      
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }   

    public String getLastName() {      
        return this.lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getBloodGroup() {
        return this.bloodGroup;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
 
    public String getEmailId() {
        return this.emailId;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public LocalDate getDateOfJoining() {
        return this.dateOfJoining;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
 
    public long getAccountNumber() {
        return this.accountNumber;       
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getIfscCode() {
        return this.ifscCode;
    } 
     
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return this.designation;
    } 

    public void setPreviousExperience(float previousExperience) {
        this.previousExperience = previousExperience;
    }

    public float getPreviousExperience() {
        return this.previousExperience;
    }
    
    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setWorkPlace(WorkPlace workPlace) {
        this.workPlace = workPlace;
    }

    public WorkPlace getWorkPlace() {
        return this.workPlace;
    }

    public void setMobileNumbers(List<Mobile> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public List<Mobile> getMobileNumbers() {
        return this.mobileNumbers;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Address> getAddresses() {
        return this.addresses;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Project> getProjects() {
        return this.projects;
    }
    
}
