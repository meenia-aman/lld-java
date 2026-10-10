package org.example.models;

/**
 * Split
 */
public class Split {

    private final String userId;
    private final Double shareAmount;

    public Split(String userId, Double shareAmount) {
        this.userId = userId;
        this.shareAmount = shareAmount;
    }

    public String getUserId() {
        return userId;
    }

    public Double getShareAmount() {
        return shareAmount;
    }
}
