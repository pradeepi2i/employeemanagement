/*
 * <p>
 *   Copyright (c) All rights reserved Ideas2IT
 * </p>
 */

package com.ideas2it.employeemanagement.model;

import javax.persistence.*;

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
@Table(name = "work_place")
public class WorkPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int workPlaceId;
    @Column(name = "floor_number")
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
