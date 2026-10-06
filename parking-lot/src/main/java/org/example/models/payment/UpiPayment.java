package org.example.models.payment;

import org.example.enums.PaymentType;

public class UpiPayment implements Payment{
    @Override
    public boolean pay(double amount) {
        System.out.println("Payment of $ "+amount +" by uPI");
        return  true;
    }

    @Override
    public PaymentType getType() {
        return PaymentType.UPI;
    }
}
