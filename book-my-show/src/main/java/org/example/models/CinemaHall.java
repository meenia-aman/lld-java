package org.example.models;

import java.util.List;
import java.util.UUID;

public class CinemaHall {

    private String id;
    private Movie movie;
    private List<Seat> seats;

    public CinemaHall(List<Seat> seats) {
        this.seats = seats;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
