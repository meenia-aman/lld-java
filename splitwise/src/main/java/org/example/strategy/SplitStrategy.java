package org.example.strategy;

import java.util.List;
import org.example.enums.SplitType;
import org.example.models.Split;
import org.example.models.User;

/**
 * SplitStrategy
 */
public interface SplitStrategy {
    List<Split> getSplits(List<User> users, double totalAmount);
    SplitType getType();
}
