package org.example.services;

import java.util.List;
import org.example.enums.SplitType;
import org.example.models.Split;
import org.example.models.User;
import org.example.strategy.EqualSplitStrategy;
import org.example.strategy.SplitStrategy;

/**
 * SplitService
 */
public class SplitService {

    private SplitStrategy splitStrategy;

    public void getSplitStrategy(SplitType type) {
        if (type == SplitType.EQUAL) {
            splitStrategy = new EqualSplitStrategy();
        }
    }

    public List<Split> getSplits(
        List<User> users,
        double totalAmount,
        SplitType type
    ) {
        getSplitStrategy(type);
        return this.splitStrategy.getSplits(users, totalAmount);
    }
}
