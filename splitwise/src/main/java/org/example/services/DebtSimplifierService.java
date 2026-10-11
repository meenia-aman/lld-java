package org.example.services;

import java.util.List;
import org.example.dtos.Transaction;
import org.example.enums.DebtSimplifierType;
import org.example.models.Group;
import org.example.strategy.BasicDebtSimplifierStrategy;
import org.example.strategy.DebtSimplifierStrategy;

/**
 * DebtSimplifierService
 */
public class DebtSimplifierService {

    private DebtSimplifierStrategy debtSimplifierStrategy;

    void createDebtSimplifierObject(DebtSimplifierType type) {
        if (type == DebtSimplifierType.BASICE) {
            this.debtSimplifierStrategy = new BasicDebtSimplifierStrategy();
        }
    }

    public List<Transaction> simplifyDebt(
        Group group,
        DebtSimplifierType type
    ) {
        createDebtSimplifierObject(type);
        return debtSimplifierStrategy.simplifyDebts(group);
    }
}
