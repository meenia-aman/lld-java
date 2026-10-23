package org.example.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.example.enums.ExclusivityType;
import org.example.enums.ProductCategory;
import org.example.enums.StackingCategory;
import org.example.strategy.DiscountStrategy;

/**
 * Coupon
 */
public class Coupon {

    private String id;
    private String code;
    private double maxDiscountAmount;
    private double minimumCartAmount;
    private List<EligibilityRule> eligibilityRules;
    private DiscountStrategy discountStrategy;
    private ProductCategory applicablecategory;
    private LocalDateTime start_time;
    private LocalDateTime valid_upto;
    private StackingCategory stackingCategory;
    private ExclusivityType exclusivityType;

    public Coupon(
        String code,
        double maxDiscountAmount,
        double minimumCartAmount,
        List<EligibilityRule> eligibilityRules,
        DiscountStrategy discountStrategy,
        ProductCategory applicatbleCategory,
        LocalDateTime start_time,
        LocalDateTime valid_upto,
        StackingCategory stackingCategory,
        ExclusivityType exclusivityType
    ) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
        this.maxDiscountAmount = maxDiscountAmount;
        this.minimumCartAmount = minimumCartAmount;
        this.eligibilityRules = eligibilityRules;
        this.discountStrategy = discountStrategy;
        this.applicablecategory = applicatbleCategory;
        this.start_time = start_time;
        this.valid_upto = valid_upto;
        this.stackingCategory = stackingCategory;
        this.exclusivityType = exclusivityType;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public double getMaxDiscountAmoun() {
        return maxDiscountAmount;
    }

    public double getMinimumCartAmount() {
        return minimumCartAmount;
    }

    public List<EligibilityRule> getEligibilityRules() {
        return eligibilityRules;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public ProductCategory getApplicablecategory() {
        return applicablecategory;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public LocalDateTime getValid_upto() {
        return valid_upto;
    }

    public StackingCategory getStackingCategory() {
        return stackingCategory;
    }

    public ExclusivityType getExclusivityType() {
        return exclusivityType;
    }

    public double getMaxDiscountAmount() {
        return maxDiscountAmount;
    }
}
