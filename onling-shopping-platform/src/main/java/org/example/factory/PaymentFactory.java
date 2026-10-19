package org.example.factory;

import org.example.enums.PaymentType;
import org.example.strategy.payment.CardPaymentStrategy;
import org.example.strategy.payment.PaymentStrategy;
import org.example.strategy.payment.UPIPaymentStrategy;

/**
 * PaymentFactory
 */
public class PaymentFactory {

    public static PaymentStrategy create(PaymentType type) {
        return switch (type) {
            case PaymentType.UPI -> new UPIPaymentStrategy();
            case PaymentType.CARD -> new CardPaymentStrategy();
        };
    }
}
