package org.example.repository.payment;

import org.example.models.Transaction;

/**
 * PaymentRepository
 */
public interface PaymentRepository {
    Transaction add(Transaction t);
    Transaction update(Transaction t);
    Transaction getById(String id);
}
