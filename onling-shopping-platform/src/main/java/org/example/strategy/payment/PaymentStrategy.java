package org.example.strategy.payment;

import org.example.enums.PaymentType;

/**
 * PaymentStrategy
 */
public interface PaymentStrategy {
    boolean pay(double amount);
    PaymentType getPaymentType();
}
