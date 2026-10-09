package org.example.services;

import java.util.List;
import org.example.models.Cinema;
import org.example.models.CinemaHall;
import org.example.models.Location;
import org.example.repository.CinemaRepository;

/**
 * CinemaService
 */
public class CinemaService {

    private CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Cinema createCinema(
        String name,
        String city,
        String state,
        String country,
        List<CinemaHall> cinemaHalls
    ) {
        Location location = new Location(city, country, state);

        Cinema cinema = new Cinema(name, location, cinemaHalls);

        return cinemaRepository.add(cinema);
    }

    public List<Cinema> getCinemaByCity(String city) {
        return cinemaRepository.getCinemasByCity(city);
    }

    public Cinema getCinemaById(String id) {
        return cinemaRepository.getById(id);
    }
}
