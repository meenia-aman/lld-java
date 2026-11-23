package org.example.service;

import org.example.enums.PaymentType;
import org.example.enums.TransactionStatus;
import org.example.models.Booking;
import org.example.models.Transaction;
import org.example.strategy.IPayment;
import org.example.strategy.Stripe;
import org.example.strategy.Upi;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private Map<String, Transaction> transactions = new HashMap<>();


    Transaction createTransaction(Booking booking, PaymentType type) {
        Transaction transaction = new Transaction(booking.getUserId(), booking.getId(), booking.getAmount(), type);
        transactions.put(transaction.getId(), transaction);
        return transaction;
    }

    IPayment getPayment(PaymentType type) {
        return switch (type) {
            case UPI -> new Upi();
            case STRIPE -> new Stripe();
        };
    }

    boolean pay(String transactionId) {
        Transaction transaction = transactions.getOrDefault(transactionId, null);

        if (transaction == null) {
            System.out.println("Please select the the valoid transacitonId for payment");
            return false;
        }
        IPayment payment = this.getPayment(transaction.getType());

        payment.pay(transaction.getAmount());
        transaction.setStatus(TransactionStatus.COMPLETED);
        return true;
    }

}
