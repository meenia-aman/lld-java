package org.example.factory;

import org.example.enums.PaymentType;
import org.example.strategy.CardPaymentStrategy;
import org.example.strategy.PaymentStrategy;
import org.example.strategy.UpiPaymentStrategy;

/**
 * PaymentFactory
 */
public class PaymentFactory {

    public static PaymentStrategy create(PaymentType type) {
        return switch (type) {
            case PaymentType.UPI -> new UpiPaymentStrategy();
            case PaymentType.CARD -> new CardPaymentStrategy();
            default -> throw new IllegalArgumentException(
                "Please select the valid paymentType"
            );
        };
    }
}
