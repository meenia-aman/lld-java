package org.example.strategy;

import java.util.ArrayList;
import java.util.List;
import org.example.enums.SplitType;
import org.example.models.Split;
import org.example.models.User;

/**
 * EqualSplitStrategy
 */
public class EqualSplitStrategy implements SplitStrategy {

    public EqualSplitStrategy() {}

    @Override
    public List<Split> getSplits(List<User> users, double totalAmount) {
        if (users.size() == 0) {
            System.out.println(
                " Please select atlest one user to creat the split"
            );
            return null;
        }

        double amount = totalAmount / users.size();

        List<Split> splits = new ArrayList<>();
        for (User user : users) {
            Split split = new Split(user.getId(), amount);
            splits.add(split);
        }

        return splits;
    }

    @Override
    public SplitType getType() {
        return SplitType.EQUAL;
    }
}
