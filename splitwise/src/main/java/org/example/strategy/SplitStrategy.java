package org.example.strategy;

import java.util.List;
import org.example.dtos.SplitRequest;
import org.example.enums.SplitType;
import org.example.models.Split;

/**
 * SplitStrategy
 */
public interface SplitStrategy {
    List<Split> getSplits(List<SplitRequest> splits, double totalAmount);
    SplitType getType();
}
