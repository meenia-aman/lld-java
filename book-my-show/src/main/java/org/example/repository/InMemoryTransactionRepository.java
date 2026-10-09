package org.example.repository;

import java.util.HashMap;
import java.util.Map;
import org.example.enums.PaymentStatusType;
import org.example.models.Transaction;

/**
 * InMemoryTransactionRepository
 */
public class InMemoryTransactionRepository implements TransactionRepository {

    private Map<String, Transaction> transactions = new HashMap<>();

    @Override
    public Transaction create(Transaction t) {
        transactions.put(t.getId(), t);
        return t;
    }

    @Override
    public Transaction updatePaymentStatus(String id, PaymentStatusType t) {
        Transaction transaction = transactions.get(id);
        if (transaction == null) {
            System.out.println(
                " No Transaction exists with provided Transaction Id"
            );
            return null;
        }
        transaction.updateStatus(t);
        transactions.put(id, transaction);
        return transaction;
    }

    @Override
    public Transaction getById(String id) {
        return this.transactions.getOrDefault(id, null);
    }
}
