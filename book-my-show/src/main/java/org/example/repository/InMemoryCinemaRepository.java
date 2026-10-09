package org.example.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.models.Cinema;

/**
 * InMemoryCinemaRepository
 */
public class InMemoryCinemaRepository implements CinemaRepository {

    private Map<String, Cinema> cinemas = new HashMap<>();

    @Override
    public Cinema add(Cinema cinema) {
        cinemas.put(cinema.getId(), cinema);
        return cinema;
    }

    @Override
    public void delete(String id) {
        cinemas.remove(id);
        return;
    }

    @Override
    public List<Cinema> getCinemasByCity(String city) {
        List<Cinema> cinemas = new ArrayList<>();
        for (Map.Entry<String, Cinema> entry : this.cinemas.entrySet()) {
            Cinema value = entry.getValue();
            if (value.getCity() == city) {
                cinemas.add(value);
            }
        }

        return cinemas;
    }

    @Override
    public Cinema update(String id, Cinema cinema) {
        cinemas.put(id, cinema);
        return cinema;
    }

    @Override
    public Cinema getById(String id) {
        return this.cinemas.getOrDefault(id, null);
    }
}
