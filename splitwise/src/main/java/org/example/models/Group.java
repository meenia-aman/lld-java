package org.example.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Group
 */
public class Group {

    private final String id;
    private String name;
    private String createdBy;
    private List<Expense> expenses = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private Map<String, BalanceSheet> balanceSheets = new HashMap<>();

    public Group(String name, String createdBy, List<User> users) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.createdBy = createdBy;
        this.users = users;
        for (User user : users) {
            addNewUserToBalanceSheet(user.getId());
        }
    }

    private void addNewUserToBalanceSheet(String userId) {
        balanceSheets.put(userId, new BalanceSheet(userId));
    }

    public User addUser(User user) {
        users.add(user);
        addNewUserToBalanceSheet(user.getId());
        return user;
    }

    public List<User> getUsers() {
        return users;
    }

    public Map<String, BalanceSheet> getBalanceSheets() {
        return balanceSheets;
    }

    public BalanceSheet getBalanceSheetByUserId(String userId) {
        return this.balanceSheets.getOrDefault(userId, null);
    }

    public List<Expense> getAllExpenses() {
        return this.expenses;
    }

    public Expense addExpense(Expense expense) {
        this.expenses.add(expense);
        return expense;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void replaceBalanceSheet(Map<String, BalanceSheet> balanceSheet) {
        this.balanceSheets = balanceSheet;
    }
}
