package org.example.repository;

import org.example.enums.PaymentStatusType;
import org.example.models.Transaction;

/**
 * TransactionRepository
 */
public interface TransactionRepository {
    Transaction create(Transaction t);
    Transaction updatePaymentStatus(String id, PaymentStatusType t);
    Transaction getById(String id);
}
