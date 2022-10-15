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
@Getter
@Setter
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("\n  ").append(type).append(": ")
                .append(countryCode).append(" - ")
                .append(mobileNumber).toString();
    }
}
