package org.example.models;

import org.example.enums.RideType;

/**
 * Vehicle
 */
public class Vehicle {

    private String reg_no;
    private RideType offered_ride_type;

    public Vehicle(String reg_no, RideType offered_ride_type) {
        this.reg_no = reg_no;
        this.offered_ride_type = offered_ride_type;
    }

    public String getReg_no() {
        return reg_no;
    }

    public RideType getOffered_ride_type() {
        return offered_ride_type;
    }
}
