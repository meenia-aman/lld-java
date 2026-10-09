package org.example.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.models.Location;
import org.example.models.Show;

/**
 * InMemoryShowRepository
 */
public class InMemoryShowRepository implements ShowRepository {

    private Map<String, Show> shows = new HashMap<>();

    @Override
    public Show add(Show show) {
        this.shows.put(show.getId(), show);
        return show;
    }

    @Override
    public Show update(Show show) {
        this.shows.put(show.getId(), show);
        return show;
    }

    @Override
    public Show getById(String id) {
        return this.shows.getOrDefault(id, null);
    }

    @Override
    public List<Show> getByMovieId(String id) {
        List<Show> shows = new ArrayList<>();
        for (Show it : this.shows.values().stream().toList()) {
            if (it.getMovie().getId().equals(id)) {
                shows.add(it);
            }
        }
        return shows;
    }

    @Override
    public List<Show> getShowByCity(String city) {
        List<Show> shows = new ArrayList<>();
        for (Show it : this.shows.values().stream().toList()) {
            Location location = it.getLocation();
            if (location.getCity().equals(city)) {
                shows.add(it);
            }
        }
        return shows;
    }

    @Override
    public List<Show> getShowByCinemaId(String id) {
        List<Show> shows = new ArrayList<>();
        for (Show it : this.shows.values().stream().toList()) {
            if (it.getCinemaId().equals(id)) {
                shows.add(it);
            }
        }
        return shows;
    }
}
