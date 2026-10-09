package org.example.repository;

import java.util.List;
import org.example.models.Cinema;

public interface CinemaRepository {
    Cinema add(Cinema cinema);
    Cinema update(String id, Cinema cinema);
    void delete(String id);
    List<Cinema> getCinemasByCity(String city);
    Cinema getById(String id);
}
