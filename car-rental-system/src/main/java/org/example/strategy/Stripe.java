package org.example.strategy;

public class Stripe implements IPayment {

    @Override
    public boolean pay(double amount) {
        System.out.println("Making payment of amount " + amount + " by STRIP");
        return true;
    }

}
