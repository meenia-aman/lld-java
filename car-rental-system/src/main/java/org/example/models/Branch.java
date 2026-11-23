package org.example.models;

import org.example.enums.CarStatus;

import java.util.List;

public class Branch {
    private final String id;
    private List<Car> cars;
    private String location;

    public Branch(String id, List<Car> cars, String location) {
        this.id = id;
        this.cars = cars;
        this.location = location;
    }

    public List<Car> getAllActiveCars() {
        return cars.stream().filter(car -> car.getStatus() == CarStatus.ACTIVE).toList();
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public List<Car> getCars() {
        return cars;
    }
}
