package org.example.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Expense
 */
public class Expense {

    private final String id;
    private String title;
    private String description;
    private String createdBy;
    private String paidBy;
    private double amount;
    private Map<String, Split> splits = new HashMap<>();

    public Expense(
        String title,
        String description,
        String createdBy,
        String paidBy,
        double amount,
        Map<String, Split> splits
    ) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.paidBy = paidBy;
        this.amount = amount;
        this.splits = splits;
    }

    public String getId() {
        return this.id;
    }

    public List<Split> getSplits() {
        return this.splits.values().stream().toList();
    }

    public Split getSplitByUserId(String userId) {
        return this.splits.getOrDefault(userId, null);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public double getAmount() {
        return amount;
    }
}
