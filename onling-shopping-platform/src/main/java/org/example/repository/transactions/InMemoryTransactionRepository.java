package org.example.repository.transactions;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Transaction;

/**
 * InMemoryTransactionRepository
 */
public class InMemoryTransactionRepository implements TransactionRepository {

    private Map<String, Transaction> transactions = new HashMap<>();

    @Override
    public Transaction add(Transaction t) {
        transactions.put(t.getId(), t);
        return t;
    }

    @Override
    public Transaction update(Transaction t) {
        transactions.put(t.getId(), t);
        return t;
    }

    @Override
    public Transaction getById(String id) {
        return transactions.getOrDefault(id, null);
    }
}
