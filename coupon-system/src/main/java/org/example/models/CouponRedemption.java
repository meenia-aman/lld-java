package org.example.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.example.enums.RedemptionStatus;

/**
 * CouponRedemption
 */
public class CouponRedemption {

    private String id;
    private String userId;
    private String oderId;
    private double total_amount;
    private double discounted_amount;
    private List<String> coupons; // Coupon Code or Coupong id
    private LocalDateTime created_at;
    private LocalDateTime expired_at;
    private RedemptionStatus redemptionStatus;

    public CouponRedemption(
        String userId,
        String orderid,
        double total_amount,
        double discounted_amount,
        List<String> coupons,
        LocalDateTime created_at,
        LocalDateTime expired_at
    ) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.oderId = orderid;
        this.total_amount = total_amount;
        this.discounted_amount = discounted_amount;
        this.coupons = coupons;
        this.created_at = created_at;
        this.expired_at = expired_at;
        this.redemptionStatus = RedemptionStatus.RESERVED;
    }

    public void setRedemptionStatus(RedemptionStatus redemptionStatus) {
        this.redemptionStatus = redemptionStatus;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getOderId() {
        return oderId;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public double getDiscounted_amount() {
        return discounted_amount;
    }

    public List<String> getCoupons() {
        return coupons;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getExpired_at() {
        return expired_at;
    }

    public RedemptionStatus getRedemptionStatus() {
        return redemptionStatus;
    }
}
