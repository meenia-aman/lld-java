package org.example.strategy.paymentStrategy;

import org.example.enums.PaymentType;

/**
 * CardPaymentStrategy
 */
public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing payment of  $ " + amount + " from CARD");
        return true;
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CARD;
    }
}
