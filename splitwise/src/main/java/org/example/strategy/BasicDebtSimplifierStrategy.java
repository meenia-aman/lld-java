package org.example.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.example.dtos.Transaction;
import org.example.models.BalanceSheet;
import org.example.models.Group;

/**
 * BasicDebtSimplifierStrategy
 */
public class BasicDebtSimplifierStrategy implements DebtSimplifierStrategy {

    private record UserBalance(String userId, double amount) {}

    @Override
    public List<Transaction> simplifyDebts(Group group) {
        List<Transaction> transactions = new ArrayList<>();

        Map<String, Double> netBalance = new HashMap<>();

        for (Map.Entry<String, BalanceSheet> entry : group
            .getBalanceSheets()
            .entrySet()) {
            String userId = entry.getKey();
            BalanceSheet sheet = entry.getValue();

            double net =
                sheet.getTotal_amount_paid() - sheet.getTotal_expense_share();

            if (Math.abs(net) > 0.0) {
                netBalance.put(userId, net);
            }
        }

        PriorityQueue<UserBalance> creditors = new PriorityQueue<>((a, b) ->
            Double.compare(b.amount(), a.amount())
        );

        PriorityQueue<UserBalance> debtors = new PriorityQueue<>((a, b) ->
            Double.compare(b.amount(), a.amount())
        );

        for (Map.Entry<String, Double> entry : netBalance.entrySet()) {
            if (entry.getValue() > 0) {
                creditors.add(
                    new UserBalance(entry.getKey(), entry.getValue())
                );
            } else if (entry.getValue() < 0) {
                debtors.add(new UserBalance(entry.getKey(), -entry.getValue()));
            }
        }

        while (!debtors.isEmpty() && !creditors.isEmpty()) {
            UserBalance debtor = debtors.poll();
            UserBalance creditor = creditors.poll();

            double settledAmount = Math.min(debtor.amount(), creditor.amount());

            transactions.add(
                new Transaction(
                    debtor.userId(),
                    creditor.userId(),
                    settledAmount
                )
            );

            double remainingDebtorAmount = debtor.amount() - settledAmount;
            double remainingCreditorAmount = creditor.amount() - settledAmount;

            if (remainingDebtorAmount > 0.0) {
                debtors.add(
                    new UserBalance(debtor.userId(), remainingDebtorAmount)
                );
            }

            if (remainingCreditorAmount > 0.01) {
                creditors.add(
                    new UserBalance(creditor.userId(), remainingCreditorAmount)
                );
            }
        }

        System.out.println("Transactions size " + transactions.size());

        return transactions;
    }
}
