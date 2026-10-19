package org.example.repository.transactions;

import org.example.models.Transaction;

/**
 * TransactionRepository
 */
public interface TransactionRepository {
    Transaction add(Transaction t);
    Transaction update(Transaction t);
    Transaction getById(String id);
}
