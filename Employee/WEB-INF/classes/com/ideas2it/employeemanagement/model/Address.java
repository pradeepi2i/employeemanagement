/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>
 *   Contains all possible information that are related
 *   to address of an employee
 * </p>
 *
 * <p>  
 *   This file is created on 28/08/2022
 *   @author : Pradeep
 * </p>
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int postalCode;
    private String doorNumber;
    private String streetName;
    private String cityName;
    private String type;
    private String districtName;
    private String stateName;
    private String countryName;

    // setters and getters

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    } 

    public String getDoorNumber() {
        return this.doorNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetName() {
        return this.streetName;
    }
 
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getPostalCode() {
        return this.postalCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("<br>  ").append(getType())
                .append(" Address : ").append("<br>  ").append(getDoorNumber())
                .append(", ").append(getStreetName()).append(", ")
                .append(getCityName()).append(", <br>").append(getDistrictName())
                .append("(dt), <br>").append(getStateName()).append(", <br>")
                .append(getCountryName()).append(", <br>")
                .append(getPostalCode()).toString();
    }
}
