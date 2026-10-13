package org.example.models;

import java.util.UUID;
import org.example.enums.PaymentStatus;
import org.example.enums.PaymentType;

/**
 * Transaction
 */
public class Transaction {

    private final String transactionId;
    private String rideId;
    private double amount;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;

    public Transaction(String rideId, double amount, PaymentType paymentType) {
        this.transactionId = UUID.randomUUID().toString();
        this.paymentStatus = PaymentStatus.PENDING;
        this.rideId = rideId;
        this.amount = amount;
        this.paymentType = paymentType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getRideId() {
        return rideId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
