package org.example.models;

import org.example.enums.BookingStatus;

import java.util.List;

public class Booking {
    private String id;
    private String showId;
    private String userId;
    private double amount;
    private List<ShowSeat> showSeats;
    private BookingStatus bookingStatus;

    public Booking(String id, String showId, String userId, double amount,
                   BookingStatus bookingStatus, List<ShowSeat> showSeats) {
        this.id = id;
        this.showId = showId;
        this.userId = userId;
        this.amount = amount;
        this.bookingStatus = bookingStatus;
        this.showSeats = showSeats;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getId() {
        return id;
    }

    public String getShowId() {
        return showId;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public String getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }
}
