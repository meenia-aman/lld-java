package org.example.strategy.paymentStrategy;

import org.example.enums.PaymentType;

/**
 * UPIPaymentStrategy
 */
public class UPIPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing payment of  $ " + amount + " from UPI");
        return true;
    }

    @Override
    public PaymentType getType() {
        return PaymentType.UPI;
    }
}
