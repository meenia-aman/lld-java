package org.example.models;

import org.example.enums.SeatType;
import org.example.enums.ShowSeatStatus;

import java.time.LocalDateTime;

public class ShowSeat {
    private final String id;
    private String rowId;
    private String colId;
    private SeatType type;
    private double amount;
    private ShowSeatStatus status;
    private LocalDateTime seat_reservation_expiry;

    public ShowSeat(String id, String rowId, String colId, SeatType type, double amount) {
        this.id = id;
        this.rowId = rowId;
        this.colId = colId;
        this.type = type;
        this.amount = amount;
        this.status = ShowSeatStatus.AVAILABLE;
    }

    public void setSeat_reservation_expiry(LocalDateTime seat_reservation_expiry) {
        this.seat_reservation_expiry = seat_reservation_expiry;
    }

    public LocalDateTime getSeat_reservation_expiry() {
        return seat_reservation_expiry;
    }

    public void setStatus(ShowSeatStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getRowId() {
        return rowId;
    }

    public ShowSeatStatus getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public SeatType getType() {
        return type;
    }

    public String getColId() {
        return colId;
    }
}
