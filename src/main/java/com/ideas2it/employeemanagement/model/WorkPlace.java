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
 *   Contains all possible information regarding to work place of an employee
 * </p>
 *
 * <p>  
 *   This file is created on 28/08/2022
 *   @author : Pradeep
 * </p>
 */
@Entity
public class WorkPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int workPlaceId;
    private int floorNumber;
    
    // setters and getters

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setWorkPlaceId(int workPlaceId) {
        this.workPlaceId = workPlaceId;
    }

    public int getWorkPlaceId() {
        return workPlaceId;
    }
}
