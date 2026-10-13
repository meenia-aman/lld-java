package org.example.services;

import org.example.enums.PaymentStatus;
import org.example.enums.PaymentType;
import org.example.factory.PaymentFactory;
import org.example.models.Transaction;
import org.example.repository.payment.PaymentRepository;
import org.example.strategy.paymentStrategy.PaymentStrategy;

/**
 * PaymentService
 */
public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    Transaction createPayment(String rideId, double amount, PaymentType type) {
        PaymentStrategy paymentStrategy = PaymentFactory.create(type);
        Transaction transaction = new Transaction(rideId, amount, type);
        paymentRepository.add(transaction);
        paymentStrategy.pay(amount);
        transaction.setPaymentStatus(PaymentStatus.SUCCESS);
        paymentRepository.update(transaction);
        return transaction;
    }
}
