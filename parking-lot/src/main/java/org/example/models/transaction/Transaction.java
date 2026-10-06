package org.example.models.transaction;

import org.example.enums.PaymentStatus;
import org.example.enums.PaymentType;

import java.time.LocalDateTime;

public class Transaction {
    private  String id;
    private double amount;
    private PaymentStatus status;
    private PaymentType type;
    private LocalDateTime paymentTime;
    private String ticketId;

    public  Transaction(String id, double amount, String ticketId, PaymentType type){
        this.id = id;
        this.amount = amount;
        this.ticketId = ticketId;
        this.type = type;
    }

    public void markPayment(PaymentType paymentType){
        this.paymentTime = LocalDateTime.now();
        this.status = PaymentStatus.SUCCESS;
        this.type = paymentType;
    }

    public  String getId(){
        return this.id;
    }
    public double getAmount(){
        return this.amount;
    }
    public PaymentType getPaymentType(){
        return this.type;
    }
}
