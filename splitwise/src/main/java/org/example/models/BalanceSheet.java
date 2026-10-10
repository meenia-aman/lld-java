package org.example.models;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * BalanceSheet
 */
public class BalanceSheet {

    private final String id;
    private final String userId;
    private double total_amount_paid;
    private double total_amount_received;
    private double total_expense_share;
    private Map<String, Double> users;

    public BalanceSheet(String userId) {
        this.userId = userId;
        this.id = UUID.randomUUID().toString();
        this.total_amount_paid = 0.0;
        this.total_amount_received = 0.0;
        this.total_expense_share = 0.0;
        this.users = new HashMap<>();
    }

    public Map<String, Double> getUsers() {
        return users;
    }

    public void setUsers(Map<String, Double> users) {
        this.users = users;
    }

    public void updateUserBalance(String userId, double amount) {
        this.users.put(userId, amount);
    }

    public double getUserBalance(String userId) {
        if (users.get(userId) == null) return 0.0;
        return users.get(userId);
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public double getTotal_amount_paid() {
        return total_amount_paid;
    }

    public void setTotal_amount_paid(double total_amount_paid) {
        this.total_amount_paid = total_amount_paid;
    }

    public double getTotal_amount_received() {
        return total_amount_received;
    }

    public void setTotal_amount_received(double total_amount_received) {
        this.total_amount_received = total_amount_received;
    }

    public double getTotal_expense_share() {
        return total_expense_share;
    }

    public void setTotal_expense_share(double total_expense_share) {
        this.total_expense_share = total_expense_share;
    }
}
