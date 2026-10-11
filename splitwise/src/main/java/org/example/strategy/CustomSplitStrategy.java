package org.example.strategy;

import java.util.ArrayList;
import java.util.List;
import org.example.dtos.SplitRequest;
import org.example.enums.SplitType;
import org.example.models.Split;

/**
 * CustomSplitStrategy
 */
public class CustomSplitStrategy implements SplitStrategy {

    @Override
    public List<Split> getSplits(
        List<SplitRequest> splitRequests,
        double totalAmount
    ) {
        double amount = 0.0;
        for (SplitRequest split : splitRequests) {
            amount += split.value();
        }
        if (amount != totalAmount) {
            System.out.println(
                "Sum of amount of all users must be equal to the totalAmount"
            );
            return null;
        }
        List<Split> splits = new ArrayList<>();

        for (SplitRequest split : splitRequests) {
            Split s = new Split(split.userId(), split.value());
            splits.add(s);
        }

        return splits;
    }

    @Override
    public SplitType getType() {
        return SplitType.CUSTOM;
    }
}
