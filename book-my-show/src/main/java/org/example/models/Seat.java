package org.example.models;

import java.util.UUID;
import org.example.enums.SeatBookingType;
import org.example.enums.SeatType;

public class Seat {

    private String id;
    private String serialNo;
    private SeatType seatType;
    private SeatBookingType bookingType;

    public Seat(String serialNo, SeatType seatType) {
        this.id = UUID.randomUUID().toString();
        this.serialNo = serialNo;
        this.seatType = seatType;
        this.bookingType = SeatBookingType.AVAILABLE;
    }

    public SeatBookingType setSeatBookingType(SeatBookingType seatBookingType) {
        this.bookingType = seatBookingType;
        return this.bookingType;
    }

    public SeatBookingType getBookingType() {
        return this.bookingType;
    }

    public String getId() {
        return id;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public boolean isAvailable() {
        return this.bookingType == SeatBookingType.AVAILABLE;
    }
}
