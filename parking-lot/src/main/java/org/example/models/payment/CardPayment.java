package org.example.models.payment;

import org.example.enums.PaymentType;

public class CardPayment implements Payment{
    @Override
    public boolean pay(double amount) {
        System.out.println("Payment of $"+amount+" by CARD");
        return true;
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CARD;
    }
}
