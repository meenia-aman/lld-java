package org.example.strategy;

import java.util.ArrayList;
import java.util.List;
import org.example.dtos.SplitRequest;
import org.example.enums.SplitType;
import org.example.models.Split;

/**
 * EqualSplitStrategy
 */
public class EqualSplitStrategy implements SplitStrategy {

    public EqualSplitStrategy() {}

    @Override
    public List<Split> getSplits(
        List<SplitRequest> splitRequests,
        double totalAmount
    ) {
        if (splitRequests.size() == 0) {
            System.out.println(
                " Please select atlest one user to creat the split"
            );
            return null;
        }

        double amount = totalAmount / splitRequests.size();

        List<Split> splits = new ArrayList<>();
        for (SplitRequest splitRequest : splitRequests) {
            Split split = new Split(splitRequest.userId(), amount);
            splits.add(split);
        }

        return splits;
    }

    @Override
    public SplitType getType() {
        return SplitType.EQUAL;
    }
}
