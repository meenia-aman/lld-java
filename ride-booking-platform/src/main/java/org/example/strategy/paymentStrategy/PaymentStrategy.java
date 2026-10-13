package org.example.strategy.paymentStrategy;

import org.example.enums.PaymentType;

/**
 * PaymentStrategy
 */
public interface PaymentStrategy {
    boolean pay(double amount);
    PaymentType getType();
}
