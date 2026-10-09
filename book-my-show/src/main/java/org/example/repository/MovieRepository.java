package org.example.repository;

import java.util.List;
import org.example.models.Movie;

public interface MovieRepository {
    Movie add(Movie movie);
    Movie update(String id, Movie movie);
    void delete(String id);
    List<Movie> getAll();
}
