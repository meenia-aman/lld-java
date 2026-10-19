package org.example.strategy.payment;

import org.example.enums.PaymentType;

/**
 * CardPaymentStrategy
 */
public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Making payment of amount $ " + amount + " by CARD");
        return true;
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.CARD;
    }
}
