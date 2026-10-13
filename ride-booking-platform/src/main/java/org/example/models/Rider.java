package org.example.models;

import java.util.UUID;

/**
 * Rider
 */
public class Rider {

    private final String riderId;
    private String name;
    private String phoneNo;

    public Rider(String name, String phoneNo) {
        this.riderId = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public String getRiderId() {
        return riderId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
