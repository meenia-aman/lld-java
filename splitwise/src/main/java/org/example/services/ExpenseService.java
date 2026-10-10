package org.example.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.enums.SplitType;
import org.example.models.BalanceSheet;
import org.example.models.Expense;
import org.example.models.Group;
import org.example.models.Split;
import org.example.models.User;

/**
 * ExpenseService
 */
public class ExpenseService {

    private GroupService groupService;
    private SplitService splitService;
    private BalanceSheetService balanceSheetService;

    public ExpenseService(
        GroupService groupService,
        SplitService splitService,
        BalanceSheetService balanceSheetService
    ) {
        this.groupService = groupService;
        this.balanceSheetService = balanceSheetService;
        this.splitService = splitService;
    }

    public Expense createExpense(
        String groupId,
        String title,
        String description,
        String createdBy,
        String paidBy,
        double amount,
        SplitType type,
        List<User> users
    ) {
        Group group = groupService.getGroupById(groupId);
        if (group == null) {
            System.out.println(" No group found");
            return null;
        }

        List<Split> splits = splitService.getSplits(users, amount, type);

        Map<String, Split> split_map = new HashMap<>();

        for (Split split : splits) {
            split_map.put(split.getUserId(), split);
        }

        Expense expense = new Expense(
            title,
            description,
            createdBy,
            paidBy,
            amount,
            split_map
        );

        group.addExpense(expense);

        Map<String, BalanceSheet> balanceSheet =
            balanceSheetService.balanceGroupExpense(
                group.getBalanceSheets(),
                expense
            );

        group.replaceBalanceSheet(balanceSheet);

        groupService.updateGroup(groupId, group);

        System.out.println("Expense create successfully");
        System.out.println(
            "ExpenseId " + expense.getId() + " Amount " + expense.getAmount()
        );

        return expense;
    }

    public List<Expense> getAllExpenses(String groupId) {
        Group group = groupService.getGroupById(groupId);
        if (group == null) {
            System.out.println("No group found");
            return null;
        }
        return group.getAllExpenses();
    }

    public BalanceSheet getBalanceSheetByUserId(String groupId, String userId) {
        Group group = groupService.getGroupById(groupId);
        if (group == null) {
            System.out.println("No group found with provided groupId");
            return null;
        }
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
