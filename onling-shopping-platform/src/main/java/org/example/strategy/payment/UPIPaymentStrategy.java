package org.example.strategy.payment;

import org.example.enums.PaymentType;

/**
 * UPIPaymentStrategy
 */
public class UPIPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Making payment of amount $ " + amount + " by UPI");
        return true;
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.UPI;
    }
}
