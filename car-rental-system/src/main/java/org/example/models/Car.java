package org.example.models;

import org.example.enums.CarStatus;
import org.example.enums.CarType;

public class Car {
    private String reg_no;
    private CarType type;
    private CarStatus status;


    public Car(String reg_no, CarType type) {
        this.reg_no = reg_no;
        this.type = type;
        this.status = CarStatus.ACTIVE;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }
}
