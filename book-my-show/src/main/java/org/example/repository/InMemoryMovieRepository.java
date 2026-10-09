package org.example.repository;

import org.example.models.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryMovieRepository implements MovieRepository{
  private Map<String,Movie> movies = new HashMap<>();

    @Override
    public void delete(String id) {
    movies.remove(id);
    }

    @Override
    public Movie add(Movie movie) {
        movies.put(movie.getId(),movie);
        return null;
    }

    @Override
    public Movie update(String id, Movie movie) {
        movies.put(movie.getId(),movie);
        return null;
    }

    @Override
    public List<Movie> getAll(){
        return movies.values().stream().toList();
    }


}
