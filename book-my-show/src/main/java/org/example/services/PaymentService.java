package org.example.services;

import org.example.enums.PaymentStatusType;
import org.example.enums.PaymentType;
import org.example.factory.PaymentFactory;
import org.example.models.Transaction;
import org.example.repository.TransactionRepository;
import org.example.strategy.PaymentStrategy;

/**
 * PaymentService
 */
public class PaymentService {

    private TransactionRepository transactionRepository;

    public PaymentService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction pay(
        double amount,
        PaymentType type,
        String bookingId,
        int userId
    ) {
        PaymentStrategy paymentStrategy = PaymentFactory.create(type);

        Transaction t = new Transaction(bookingId, amount, type, userId);
        transactionRepository.create(t);
        paymentStrategy.pay(amount);

        t = transactionRepository.updatePaymentStatus(
            t.getId(),
            PaymentStatusType.SUCCESS
        );
        return t;
    }
}
