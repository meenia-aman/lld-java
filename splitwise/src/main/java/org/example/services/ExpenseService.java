package org.example.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.dtos.CreateExpenseRequest;
import org.example.dtos.SplitRequest;
import org.example.enums.SplitType;
import org.example.models.Expense;
import org.example.models.Group;
import org.example.models.Split;

/**
 * ExpenseService
 */
public class ExpenseService {

    private SplitService splitService;

    public ExpenseService(SplitService splitService) {
        this.splitService = splitService;
    }

    public Expense createExpense(CreateExpenseRequest expenseRequest) {
        String title = expenseRequest.title();
        String description = expenseRequest.description();
        String createdBy = expenseRequest.createdBy();
        String paidBy = expenseRequest.paidBy();
        double amount = expenseRequest.amount();
        SplitType type = expenseRequest.type();
        List<SplitRequest> splitRequests = expenseRequest.splits();

        List<Split> splits = splitService.getSplits(
            splitRequests,
            amount,
            type
        );

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

        System.out.println("Expense create successfully");
        System.out.println(
            "ExpenseId " + expense.getId() + " Amount " + expense.getAmount()
        );

        return expense;
    }

    public List<Expense> getAllExpenses(Group group) {
        if (group == null) return List.of();
        return group.getAllExpenses();
    }
}
