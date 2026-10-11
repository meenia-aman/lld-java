package org.example.services;

import java.util.List;
import java.util.Map;
import org.example.models.BalanceSheet;
import org.example.models.Expense;
import org.example.models.Group;
import org.example.models.Split;

/**
 * BalanceSheetService
 */
public class BalanceSheetService {

    public Map<String, BalanceSheet> balanceGroupExpense(
        Map<String, BalanceSheet> balanceSheets,
        Expense expense
    ) {
        String createdBy = expense.getCreatedBy();

        for (Split split : expense.getSplits()) {
            String userId = split.getUserId();
            double amount = split.getShareAmount();

            BalanceSheet balanceSheet = balanceSheets.get(userId);
            if (balanceSheet == null) {
                balanceSheet = new BalanceSheet(userId);
            }
            balanceSheet.setTotal_expense_share(
                balanceSheet.getTotal_expense_share() + amount
            );
            if (userId.equals(createdBy)) {
                balanceSheet = updateCurrentUser(
                    balanceSheet,
                    amount,
                    expense.getSplits(),
                    expense.getAmount(),
                    createdBy
                );
            } else {
                balanceSheet = updateOtherUsers(
                    balanceSheet,
                    amount,
                    createdBy
                );
            }
            balanceSheets.put(userId, balanceSheet);
        }

        return balanceSheets;
    }

    private BalanceSheet updateCurrentUser(
        BalanceSheet balanceSheet,
        double amount,
        List<Split> splits,
        double totalAmount,
        String createdBy
    ) {
        balanceSheet.setTotal_amount_paid(
            balanceSheet.getTotal_amount_paid() + totalAmount
        );
        for (Split split : splits) {
            String userId = split.getUserId();
            if (userId.equals(createdBy)) continue;
            balanceSheet.updateUserBalance(
                userId,
                amount + balanceSheet.getUserBalance(userId)
            );
        }

        return balanceSheet;
    }

    private BalanceSheet updateOtherUsers(
        BalanceSheet balanceSheet,
        double amount,
        String userId
    ) {
        double total_amount = balanceSheet.getUserBalance(userId);
        total_amount -= amount;
        balanceSheet.updateUserBalance(userId, total_amount);
        return balanceSheet;
    }

    public BalanceSheet getBalanceSheetByUserId(Group group, String userId) {
        BalanceSheet balanceSheet = group.getBalanceSheetByUserId(userId);

        System.out.println("========= Balance Sheet =========");
        System.out.println("User id " + userId);

        System.out.println(
            " Total Amount Paid " + balanceSheet.getTotal_amount_paid()
        );
        System.out.println(
            " Total Expense Share " + balanceSheet.getTotal_expense_share()
        );
        for (Map.Entry<String, Double> it : balanceSheet
            .getUsers()
            .entrySet()) {
            String id = it.getKey();
            Double amount = it.getValue();

            if (amount > 0) {
                System.out.println(
                    "You will receive $ " + amount + " from user " + id
                );
            } else {
                System.out.println(
                    " You have to pay $ " + amount + " to user " + id
                );
            }
        }
        System.out.println(" ==============================================");
        System.out.println();

        return balanceSheet;
    }
}
