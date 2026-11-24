package org.example.models;

public class Movie {
    private final String id;
    private String name;
    private int duration;

    public Movie(String id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getId() {
        return id;
    }
}
