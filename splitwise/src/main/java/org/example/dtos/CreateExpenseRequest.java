package org.example.dtos;

import java.util.List;
import org.example.enums.SplitType;

/**
 * CreateExpenseRequest
 */

public record CreateExpenseRequest(
    String groupId,
    String title,
    String description,
    String createdBy,
    String paidBy,
    double amount,
    SplitType type,
    List<SplitRequest> splits
) {}
