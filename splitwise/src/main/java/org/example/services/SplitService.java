package org.example.services;

import java.util.List;
import org.example.dtos.SplitRequest;
import org.example.enums.SplitType;
import org.example.models.Split;
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
        List<SplitRequest> splitRequests,
        double totalAmount,
        SplitType type
    ) {
        getSplitStrategy(type);
        return this.splitStrategy.getSplits(splitRequests, totalAmount);
    }
}
