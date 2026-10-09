package org.example.strategy;

/**
 * CardPaymentStrategy
 */
public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(Double amount) {
        System.out.println("Payment of $ " + amount + " by CARD");
        return true;
    }
}
