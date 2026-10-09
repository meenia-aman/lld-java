package org.example.services;

import java.util.List;
import org.example.models.Movie;
import org.example.repository.MovieRepository;

/**
 * MovieService
 */
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(
        String name,
        int duration,
        String description,
        boolean isAvailable
    ) {
        Movie movie = new Movie(name, description, duration, isAvailable);
        movieRepository.add(movie);
        return movie;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.getAll();
    }
}
