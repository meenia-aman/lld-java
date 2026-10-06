package org.example.repository.repoInterface;

import org.example.models.transaction.Transaction;

public interface PaymentRepository {
     void create(Transaction t);
     Transaction getById(String id);
     void updateTransaction(Transaction t);
}
