package org.example.dtos;

/**
 * Transaction
 */
public record Transaction(String userId, String toUser, double amount) {}
