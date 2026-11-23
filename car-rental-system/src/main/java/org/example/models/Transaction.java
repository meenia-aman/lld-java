package org.example.models;

import org.example.enums.PaymentType;
import org.example.enums.TransactionStatus;

import java.util.UUID;

public class Transaction {
    private final String id;
    private String userId;
    private String bookingId;
    private double amount;
    private PaymentType type;
    private TransactionStatus status;

    public Transaction(String userId, String bookingId, double amount, PaymentType type) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.type = type;
        this.status = TransactionStatus.PENDING;
    }


    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public PaymentType getType() {
        return type;
    }

    public String getBookingId() {
        return bookingId;
    }

    public double getAmount() {
        return amount;
    }
}
