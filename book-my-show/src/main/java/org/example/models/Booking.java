package org.example.models;

import java.util.List;
import java.util.UUID;
import org.example.enums.BookingStatusType;

/**
 * Booking
 */
public class Booking {

    private String id;
    private int userId;
    private List<String> seats;
    private String showId;
    private BookingStatusType status;

    public Booking(int userId, String showId, List<String> seats) {
        this.id = UUID.randomUUID().toString();
        this.showId = showId;
        this.seats = seats;
        this.status = BookingStatusType.PENDING;
    }

    public BookingStatusType updateBookinStatus(BookingStatusType type) {
        this.status = type;
        return this.status;
    }

    public String getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public List<String> getSeats() {
        return seats;
    }

    public String getShowId() {
        return showId;
    }

    public BookingStatusType getStatus() {
        return status;
    }
}
