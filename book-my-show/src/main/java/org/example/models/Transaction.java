package org.example.models;

import java.time.LocalDateTime;
import java.util.UUID;
import org.example.enums.PaymentStatusType;
import org.example.enums.PaymentType;

/**
 * Transaction
 */
public class Transaction {

    private final String id;
    private String bookingId;
    private double amount;
    private PaymentType type;
    private LocalDateTime createdAt;
    private int userId;
    private PaymentStatusType paymentStatus;

    public Transaction(
        String bookingId,
        double amount,
        PaymentType type,
        int userId
    ) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.bookingId = bookingId;
        this.type = type;
        this.amount = amount;
        this.paymentStatus = paymentStatus.PENDING;
    }

    public PaymentStatusType updateStatus(PaymentStatusType type) {
        this.paymentStatus = type;
        return this.paymentStatus;
    }

    public String getId() {
        return id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentType getType() {
        return type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getUserId() {
        return userId;
    }
}
