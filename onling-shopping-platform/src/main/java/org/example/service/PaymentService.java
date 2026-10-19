package org.example.service;

import org.example.enums.PaymentStatus;
import org.example.enums.PaymentType;
import org.example.factory.PaymentFactory;
import org.example.models.Transaction;
import org.example.repository.transactions.TransactionRepository;
import org.example.strategy.payment.PaymentStrategy;

/**
 * PaymentService
 */
public class PaymentService {

    private TransactionRepository transactionRepository;
    private PaymentStrategy paymentStrategy;
    private PaymentFactory paymentFactory;

    public PaymentService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void getPaymentObject(PaymentType type) {
        this.paymentStrategy = paymentFactory.create(type);
    }

    public Transaction createTransaction(
        String userId,
        String orderId,
        double amount,
        PaymentType paymentType
    ) {
        Transaction transaction = new Transaction(
            userId,
            orderId,
            amount,
            paymentType
        );

        transactionRepository.add(transaction);

        return transaction;
    }

    public Transaction pay(String id) {
        Transaction transaction = transactionRepository.getById(id);

        getPaymentObject(transaction.getPaymentType());

        paymentStrategy.pay(transaction.getAmount());

        transaction.updateStatus(PaymentStatus.SUCCESS);
        transactionRepository.update(transaction);
        return transaction;
    }
}
