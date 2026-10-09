package org.example.repository;

import java.util.List;
import org.example.models.Show;

/**
 * ShowRepository
 */
public interface ShowRepository {
    Show add(Show show);
    Show update(Show show);
    Show getById(String id);
    List<Show> getByMovieId(String id);
    List<Show> getShowByCity(String city);
    List<Show> getShowByCinemaId(String id);
}
