package org.example.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Cinema {

    private String id;
    private String name;
    private Location location;
    private Map<String, CinemaHall> cinemaHalls = new HashMap<>();

    public Cinema(
        String name,
        Location location,
        List<CinemaHall> cinemaHalls
    ) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;

        for (CinemaHall it : cinemaHalls) {
            this.cinemaHalls.put(it.getId(), it);
        }
    }

    public CinemaHall addCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHalls.put(cinemaHall.getId(), cinemaHall);
        return cinemaHall;
    }

    public List<CinemaHall> getAllCinemaHalls() {
        return cinemaHalls.values().stream().toList();
    }

    public CinemaHall getCinemaHallById(String id) {
        return this.cinemaHalls.getOrDefault(id, null);
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    public String getCity() {
        return this.location.getCity();
    }
}
