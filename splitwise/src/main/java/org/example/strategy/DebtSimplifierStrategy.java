package org.example.strategy;

import java.util.List;
import org.example.dtos.Transaction;
import org.example.models.Group;

/**
 * DebtSimplifierStrategy
 */
public interface DebtSimplifierStrategy {
    List<Transaction> simplifyDebts(Group group);
}
