package org.example.repository.payment;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Transaction;

/**
 * InMemoryPaymentRepository
 */
public class InMemoryPaymentRepository implements PaymentRepository {

    private Map<String, Transaction> transactions = new HashMap<>();

    @Override
    public Transaction add(Transaction t) {
        this.transactions.put(t.getTransactionId(), t);
        return t;
    }

    @Override
    public Transaction update(Transaction t) {
        this.transactions.put(t.getTransactionId(), t);
        return t;
    }

    @Override
    public Transaction getById(String id) {
        return this.transactions.getOrDefault(id, null);
    }
}
