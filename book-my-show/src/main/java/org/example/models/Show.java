package org.example.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.example.enums.SeatBookingType;
import org.example.enums.SeatType;

/**
 * Show
 */
public class Show {

    private String id;
    private String name;
    private String cinemaId;
    private String cinemaHallId;
    private Movie movie;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Map<SeatType, Double> priceMapping;
    private Map<String, Seat> seats;
    private Location location;

    public Show(
        String name,
        String cinemaId,
        String cinemaHallId,
        Movie movie,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Map<SeatType, Double> priceMapping,
        Map<String, Seat> seats,
        Location location
    ) {
        this.name = name;
        this.cinemaId = cinemaId;
        this.cinemaHallId = cinemaHallId;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priceMapping = priceMapping;
        this.seats = seats;
        this.location = location;
    }

    public boolean reserveSeat(List<String> ids) {
        for (String id : ids) {
            Seat seat = this.seats.getOrDefault(id, null);
            if (seat == null) {
                System.out.println("Invalide seatId passed");
                return false;
            }
            if (!seat.isAvailable()) {
                System.out.println(
                    "Seat with id " +
                        seat.getId() +
                        " is already booked. Please select the available seats and try to book the ticket. "
                );
                return false;
            }
        }

        for (String id : ids) {
            Seat seat = this.seats.getOrDefault(id, null);
            seat.setSeatBookingType(SeatBookingType.RESERVED);
        }
        return true;
    }

    public boolean bookSeat(List<String> ids) {
        for (String id : ids) {
            Seat seat = this.seats.getOrDefault(id, null);
            if (seat == null) {
                System.out.println(
                    "Unable to books seat due to invalid seatId provided"
                );
                return false;
            }

            if (seat.getBookingType() != SeatBookingType.RESERVED) {
                System.out.println(
                    "Unable to book seat. please try to book the seat with correct ids"
                );
                return false;
            }
        }

        for (String id : ids) {
            Seat seat = this.seats.getOrDefault(id, null);
            seat.setSeatBookingType(SeatBookingType.BOOKED);
        }

        return true;
    }

    public void displayAllSeats() {
        List<Seat> seats = this.seats.values().stream().toList();

        System.out.println(
            " Displaying seats for the CinemaHall " +
                this.cinemaHallId +
                " Show Name " +
                this.name
        );
        for (Seat it : seats) {
            System.out.println(
                "Seat id " + it.getId() + " Booking Type " + it.getBookingType()
            );
        }
        System.out.println("");
    }

    public void makeSeatAvailable(List<String> ids) {
        for (String id : ids) {
            Seat seat = this.seats.getOrDefault(id, null);
            if (seat != null) {
                seat.setSeatBookingType(SeatBookingType.AVAILABLE);
                this.seats.put(id, seat);
            }
        }
    }

    public String getId() {
        return this.id;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public String getCinemaId() {
        return this.cinemaId;
    }

    public String getCinemaHallId() {
        return this.cinemaHallId;
    }

    public Location getLocation() {
        return this.location;
    }

    public double getPriceBySeatId(String seatId) {
        Seat seat = seats.get(seatId);
        return priceMapping.get(seat.getSeatType());
    }
}
