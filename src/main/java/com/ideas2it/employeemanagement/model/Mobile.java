/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <p>
 *   Contains all possible information that are related
 *   to employee's mobile
 * </p>
 *
 * <p>  
 *   This file is created on 28/08/2022
 *   @author : Pradeep
 * </p>
 */
@Entity
@Table(name = "mobile")
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "mobile_number")
    private long mobileNumber;
    @Column(name = "country_code")
    private String countryCode;
    private String type;
    
    // setters and getters

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public long getMobileNumber() {
        return this.mobileNumber; 
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("\n  ").append(type).append(": ")
                .append(countryCode).append(" - ")
                .append(mobileNumber).toString();
    }
}
