package org.example.models.payment;

import org.example.enums.PaymentType;

public interface Payment {

    boolean pay(double amount);
    PaymentType getType();
}
