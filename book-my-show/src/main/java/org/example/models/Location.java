package org.example.models;

public class Location {

    private String city;
    private String country;
    private String state;

    public Location(String city, String country, String state) {
        this.city = city;
        this.country = country;
        this.state = state;
    }

    public String getCity() {
        return this.city;
    }

    public String country() {
        return this.country;
    }

    public String state() {
        return this.state;
    }
}
