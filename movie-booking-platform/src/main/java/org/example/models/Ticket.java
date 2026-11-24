package org.example.models;

public class Ticket {
    private final String id;
    private String bookingId;
    private String showId;
    private String userId;

    public Ticket(String id, String bookingId, String showId, String userId) {
        this.id = id;
        this.bookingId = bookingId;
        this.showId = showId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getShowId() {
        return showId;
    }

    public String getBookingId() {
        return bookingId;
    }
}
