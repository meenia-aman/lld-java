package org.example.models;

import java.util.UUID;
import org.example.enums.PaymentStatus;
import org.example.enums.PaymentType;

/**
 * Transaction
 */
public class Transaction {

    private final String id;
    private String userId;
    private String orderId;
    private double amount;
    private PaymentStatus status;
    private PaymentType paymentType;

    public Transaction(
        String userId,
        String orderId,
        double amount,
        PaymentType paymentType
    ) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentType = paymentType;
        this.status = PaymentStatus.PENDING;
    }

    public PaymentStatus updateStatus(PaymentStatus status) {
        this.status = status;
        return this.status;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
