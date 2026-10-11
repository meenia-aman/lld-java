package org.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.example.dtos.CreateExpenseRequest;
import org.example.dtos.Transaction;
import org.example.dtos.TransactionResponse;
import org.example.enums.DebtSimplifierType;
import org.example.models.BalanceSheet;
import org.example.models.Expense;
import org.example.models.Group;
import org.example.models.User;

/**
 * SplitwiseService
 */
// Facade Class(Entry point for the client)
public class SplitwiseService {

    private UserService userService;
    private GroupService groupService;
    private ExpenseService expenseService;
    private DebtSimplifierService debtSimplifierService;
    private BalanceSheetService balanceSheetService;

    public SplitwiseService(
        UserService userService,
        GroupService groupService,
        ExpenseService expenseService,
        DebtSimplifierService debtSimplifierService,
        BalanceSheetService balanceSheetService
    ) {
        this.userService = userService;
        this.groupService = groupService;
        this.expenseService = expenseService;
        this.debtSimplifierService = debtSimplifierService;
        this.balanceSheetService = balanceSheetService;
    }

    public User createUser(String name, String email) {
        return userService.createUser(name, email);
    }

    public User getUserById(String userId) {
        return userService.getUserById(userId);
    }

    public Group createGroup(String name, String createdBy, List<User> users) {
        return groupService.CreateGroup(name, createdBy, users);
    }

    public Group getGroupById(String groupId) {
        return groupService.getGroupById(groupId);
    }

    private Group updateGroup(String groupId, Group group) {
        return groupService.updateGroup(groupId, group);
    }

    public Expense createExpense(
        String groupId,
        CreateExpenseRequest createExpenseRequest
    ) {
        Group group = getGroupById(groupId);
        Expense expense = expenseService.createExpense(createExpenseRequest);
        group.addExpense(expense);

        Map<String, BalanceSheet> balanceSheet =
            balanceSheetService.balanceGroupExpense(
                group.getBalanceSheets(),
                expense
            );

        group.replaceBalanceSheet(balanceSheet);

        this.updateGroup(groupId, group);
        return expense;
    }

    public BalanceSheet getBalanceSheetByUserId(String groupId, String userId) {
        Group group = this.getGroupById(groupId);
        return balanceSheetService.getBalanceSheetByUserId(group, userId);
    }

    public List<TransactionResponse> simplifyDebt(
        String groupId,
        DebtSimplifierType type
    ) {
        Group group = this.getGroupById(groupId);

        List<Transaction> transactions = debtSimplifierService.simplifyDebt(
            group,
            type
        );

        List<TransactionResponse> transactionResponses = new ArrayList<>();

        for (Transaction transaction : transactions) {
            String userId = transaction.userId();
            String otherUserId = transaction.toUser();

            User u1 = this.getUserById(userId);
            User u2 = this.getUserById(otherUserId);

            TransactionResponse transactionResponse = new TransactionResponse(
                userId,
                u1.getName(),
                otherUserId,
                u2.getName(),
                transaction.amount()
            );
            transactionResponses.add(transactionResponse);
        }

        return transactionResponses;
    }

    public List<Expense> getAllExpenseByGroupId(String groupId) {
        Group group = this.getGroupById(groupId);
        return expenseService.getAllExpenses(group);
    }
}
