package org.example.services;

import org.example.models.Cinema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaService {
    private Map<String, Cinema> cinemas = new HashMap<>();

    public CinemaService(List<Cinema> cinemas) {
        for (Cinema cinema : cinemas) {
            this.cinemas.put(cinema.getId(), cinema);
        }
    }

    public List<Cinema> getCinemas() {
        return this.cinemas.values().stream().toList();
    }
}
