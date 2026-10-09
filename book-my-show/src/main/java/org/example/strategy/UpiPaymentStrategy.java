package org.example.strategy;

/**
 * UpiPaymentStrategy
 */
public class UpiPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(Double amount) {
        System.out.println("Payment of $ " + amount + " by UPI");
        return true;
    }
}
