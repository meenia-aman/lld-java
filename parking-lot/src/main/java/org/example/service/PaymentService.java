package org.example.service;

import java.util.UUID;
import org.example.enums.PaymentType;
import org.example.factory.PaymentFactory;
import org.example.models.payment.Payment;
import org.example.models.transaction.Transaction;
import org.example.repository.repoInterface.PaymentRepository;

public class PaymentService {
  private final PaymentRepository paymentRepository;

  public PaymentService(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  private Payment getPaymentObj(PaymentType type) {
    return PaymentFactory.createPayment(type);
  }

  public Transaction createTransaction(String ticketId, double amount, PaymentType type) {
    String transaction_id = UUID.randomUUID().toString();
    Transaction transaction = new Transaction(transaction_id, amount, ticketId, type);
    paymentRepository.create(transaction);
    return transaction;
  }

  public boolean makePayment(String transaction_id) {
    Transaction t = paymentRepository.getById(transaction_id);
    if (t == null) return false;
    Payment payment = getPaymentObj(t.getPaymentType());
    payment.pay(t.getAmount());
    t.markPayment(payment.getType());
    return true;
  }
}
