package org.example.models;

import org.example.enums.SeatStatus;
import org.example.enums.SeatType;

import java.util.UUID;

public class Seat {
    private final String id;
    private String rowId;
    private String colId;
    private SeatStatus status;
    private SeatType type;

    public Seat(String rowId, String colId, SeatType type) {
        this.id = UUID.randomUUID().toString();
        this.rowId = rowId;
        this.colId = colId;
        this.status = SeatStatus.AVAILABLE;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getColId() {
        return colId;
    }

    public void setColId(String colId) {
        this.colId = colId;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public SeatType getType() {
        return type;
    }
}
