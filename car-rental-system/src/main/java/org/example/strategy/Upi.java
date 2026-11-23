package org.example.strategy;

public class Upi implements IPayment {

    @Override
    public boolean pay(double amount) {
        System.out.println("Making payment of " + amount + " by UPI ");
        return true;
    }
}
