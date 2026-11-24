package org.example.models;

import java.util.List;

public class Screen {
    private final String id;
    private List<Seat> seats;

    public Screen(String id, List<Seat> seats) {
        this.id = id;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
