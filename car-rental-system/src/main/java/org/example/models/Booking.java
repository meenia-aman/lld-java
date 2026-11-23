package org.example.models;

import org.example.enums.BookingStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {
    private final String id;
    private String userId;
    private String carId;
    private String pickupBranchId;
    private String dropBranchId;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private double amount;
    private BookingStatus status;
    private LocalDateTime reserved_expiry_time;

    public Booking(String userId, String carId, String pickupBranchId, String dropBranchId, LocalDate pickupDate, LocalDate returnDate,
                   double amount, LocalDateTime reserved_expiry_time) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.carId = carId;
        this.pickupBranchId = pickupBranchId;
        this.dropBranchId = dropBranchId;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.amount = amount;
        this.status = BookingStatus.RESERVED;
        this.reserved_expiry_time = reserved_expiry_time;
    }

    public void updateStatus(BookingStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPickupBranchId() {
        return pickupBranchId;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public LocalDateTime getReserved_expiry_time() {
        return reserved_expiry_time;
    }

    public double getAmount() {
        return amount;
    }

    public String getDropBranchId() {
        return dropBranchId;
    }

    public String getCarId() {
        return carId;
    }
}
