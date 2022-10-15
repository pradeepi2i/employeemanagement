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
@Table(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "postal_code")
    private int postalCode;
    @Column(name = "door_number")
    private String doorNumber;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "type")
    private String addressType;
    @Column(name = "district_name")
    private String districtName;
    @Column(name = "state_name")
    private String stateName;
    @Column(name = "country_name")
    private String countryName;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("<br>  ").append(getAddressType())
                .append(" Address : ").append("<br>  ").append(getDoorNumber())
                .append(", ").append(getStreetName()).append(", ")
                .append(getCityName()).append(", <br>").append(getDistrictName())
                .append("(dt), <br>").append(getStateName()).append(", <br>")
                .append(getCountryName()).append(", <br>")
                .append(getPostalCode()).toString();
    }
}
