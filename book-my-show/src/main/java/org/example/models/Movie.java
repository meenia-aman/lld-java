package org.example.models;

import java.util.UUID;

public class Movie {

    private final String id;
    private String name;
    private String description;
    private int durationInSec;
    private boolean isAvailable;

    public Movie(
        String name,
        String description,
        int duration,
        boolean isAvailable
    ) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.durationInSec = duration;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getDurationInSec() {
        return durationInSec;
    }
}
