package org.example.factory;

import org.example.enums.PaymentType;
import org.example.models.payment.CardPayment;
import org.example.models.payment.Payment;
import org.example.models.payment.UpiPayment;

public class PaymentFactory {

    public static Payment createPayment(PaymentType type){
        return switch (type){
            case PaymentType.UPI -> new UpiPayment();
            case PaymentType.CARD -> new CardPayment();
            default ->  throw new IllegalArgumentException("Please select the supported paymenttype");
        };

    }
}
