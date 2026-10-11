package org.example.dtos;

/**
 * TransactionResponse
 */
public record TransactionResponse(
    String userId,
    String userName,
    String toUser,
    String toUserName,
    double amount
) {}
