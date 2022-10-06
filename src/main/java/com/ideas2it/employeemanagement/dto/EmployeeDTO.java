/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.dto;

import com.ideas2it.employeemanagement.model.Address;
import com.ideas2it.employeemanagement.model.Mobile;
import com.ideas2it.employeemanagement.model.WorkPlace;
import com.ideas2it.employeemanagement.util.EmployeeUtil;

import java.time.LocalDate;
import java.util.Set;

/**
 * <p>
 *   Contains all possible information that are applicable to employee
 * </p>
 *
 * <p>  
 *   This file is created on 20/08/2022
 *   @author : Pradeep
 * </p>
 */
public class EmployeeDTO {

    protected static String companyName = "Ideas2IT";
    protected static String bankName = "HDFC";
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String bloodGroup;
    private String emailId;
    private LocalDate dateOfJoining;
    private long accountNumber;
    private String ifscCode; 
    private String designation; 
    private float previousExperience;    
    private float salary; 
    private WorkPlace workPlace;  
    private Set<Mobile> mobileNumbers;
    private Set<Address>addresses;
    private Set<ProjectDTO>projects;

    public EmployeeDTO() {}

    public EmployeeDTO(String firstName, String lastName,
            String gender, LocalDate dateOfBirth, String bloodGroup, 
            String emailId, LocalDate dateOfJoining, long accountNumber, 
            String ifscCode, String designation, float previousExperience,
            float salary, WorkPlace workPlace, Set<Mobile> mobileNumbers, 
            Set<Address>addresses) {
      
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
        this.emailId = emailId;
        this.dateOfJoining = dateOfJoining;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.designation = designation;
        this.previousExperience = previousExperience;
        this.salary = salary;
        this.workPlace = workPlace;
        this.mobileNumbers = mobileNumbers;
        this.addresses = addresses;
    }
    
    // setters and getters

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {	
        return this.id;
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

    public void setMobileNumbers(Set<Mobile> mobileNumbers) {
        this.mobileNumbers  = mobileNumbers;
    }

    public Set<Mobile> getMobileNumbers() {
        return this.mobileNumbers;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Address> getAddresses() {
        return this.addresses;
    }

    public void setProjects(Set<ProjectDTO> projects) {
        this.projects = projects;
    }

    public Set<ProjectDTO> getProjects() {
        return this.projects;
    }
    
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return  stringBuilder.append("<br>Company Name : <br>")
                .append(companyName).append("<br>")
                .append("<br>Personal Details <br>")
                .append("<br>  Id : ").append(getId())
                .append( "<br>  Name : ").append(getFirstName())
                .append(" ").append(getLastName())
                .append( "<br>  Age : ").append(EmployeeUtil.calculateAge(getDateOfBirth()))
                .append("<br>  Designation : ").append(getDesignation())
                .append( "<br>  Experience : ").append((getPreviousExperience() + EmployeeUtil
                        .calculateExperience(getDateOfJoining())))
                .append("<br>Bank Details <br>").append("<br>  Bank Name : ").append(bankName)
                .append("<br>  Account Number : ").append(getAccountNumber())
                .append("<br>  IFSC Code : ").append(getIfscCode()).toString();
    }
}
