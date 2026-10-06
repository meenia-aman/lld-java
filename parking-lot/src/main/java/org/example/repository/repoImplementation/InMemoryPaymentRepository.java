package org.example.repository.repoImplementation;

import kotlin.ResultKt;
import org.example.models.transaction.Transaction;
import org.example.repository.repoInterface.PaymentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPaymentRepository implements PaymentRepository {

    private Map<String,Transaction> transactions;

    public InMemoryPaymentRepository(){
        transactions = new HashMap<>();
  ;  }

    @Override
    public void create(Transaction t) {
        System.out.println("Transaction "+t.getId());
        transactions.put(t.getId(),t);
        System.out.println("Create Transaction is working");
    }

    @Override
    public void updateTransaction(Transaction t) {
        this.transactions.put(t.getId(),t);
    }

    @Override
    public Transaction getById(String id) {
        return this.transactions.getOrDefault(id,null);
    }
}
