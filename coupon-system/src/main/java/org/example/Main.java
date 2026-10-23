package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.example.dtos.CartItem;
import org.example.dtos.CartRequest;
import org.example.dtos.CartResponse;
import org.example.dtos.UserContext;
import org.example.enums.ExclusivityType;
import org.example.enums.ProductCategory;
import org.example.enums.RedemptionStatus;
import org.example.enums.StackingCategory;
import org.example.models.CategoryEligibilityRule;
import org.example.models.Coupon;
import org.example.models.CouponRedemption;
import org.example.models.EligibilityRule;
import org.example.models.MinCartAmountEligibilityRule;
import org.example.repository.coupon.CouponRepository;
import org.example.repository.coupon.InMemoryCouponRepository;
import org.example.repository.couponRedemption.CouponRedemptionRepository;
import org.example.repository.couponRedemption.InMemoryCouponRedemptionRepository;
import org.example.services.CalculateDiscountService;
import org.example.services.CouponRedemptionService;
import org.example.services.CouponService;
import org.example.services.CouponSystem;
import org.example.services.CouponValidationService;
import org.example.strategy.PercentageDiscountStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void main() {
        System.out.println("================ Coupon System =============");

        CouponRepository couponRepository = new InMemoryCouponRepository();
        CouponRedemptionRepository couponRedemptionRepository =
            new InMemoryCouponRedemptionRepository();

        CouponService couponService = new CouponService(couponRepository);
        CalculateDiscountService calculateDiscountService =
            new CalculateDiscountService();
        CouponValidationService couponValidationService =
            new CouponValidationService();

        CouponRedemptionService couponRedemptionService =
            new CouponRedemptionService(
                couponRedemptionRepository,
                calculateDiscountService,
                couponValidationService
            );

        CouponSystem couponSystem = new CouponSystem(
            couponService,
            couponRedemptionService
        );

        List<EligibilityRule> eligibilityRules = List.of(
            new MinCartAmountEligibilityRule(),
            new CategoryEligibilityRule()
        );

        Coupon coupon1 = new Coupon(
            "Aman20",
            1000,
            500,
            eligibilityRules,
            new PercentageDiscountStrategy(20),
            ProductCategory.ELECTRONICS,
            LocalDateTime.now(),
            LocalDateTime.now().plusDays(10),
            StackingCategory.CART,
            ExclusivityType.GLOBAL_EXCLUSIVE
        );

        Coupon coupon = couponSystem.createCoupon(coupon1);

        System.out.println("Coupone code " + coupon.getCode());

        List<CartItem> cartItems = List.of(
            new CartItem("SKU-123", 1123, 0, ProductCategory.ELECTRONICS, 1)
        );

        UserContext userContext = new UserContext("BLINKIT-USER-1", 0);

        List<String> applied_coupons = new ArrayList<>();

        String orderId = "BLINKIT_ORDERID_123";

        CartRequest cartRequest = new CartRequest(
            "BLINKIT-123",
            userContext,
            cartItems,
            applied_coupons,
            1123,
            1123,
            "Aman20",
            orderId
        );

        CartResponse cartResponse = couponSystem.applyCouponToCart(cartRequest);

        System.out.println(" ============= Cart Response =========");
        System.out.println(
            "CartResponse " +
                cartResponse.total_amount() +
                " Amount after discount " +
                cartResponse.total_amount_after_discount()
        );

        CartRequest orderRequest = new CartRequest(
            "BLINKIT-123",
            userContext,
            cartItems,
            applied_coupons,
            1123,
            cartResponse.total_amount_after_discount(),
            "Aman20",
            orderId
        );
        cartResponse = couponSystem.CreateCouponUsageEntry(orderRequest);

        CouponRedemption couponRedemption =
            couponSystem.getCouponRedemptionEntryByOrderId(orderId);

        System.out.println("====== Coupon Entry =====");
        System.out.println("OrderId " + couponRedemption.getOderId());
        System.out.println("TotalAmount " + couponRedemption.getTotal_amount());
        System.out.println(
            "Amount after discount " + couponRedemption.getDiscounted_amount()
        );
        System.out.println("Status " + couponRedemption.getRedemptionStatus());

        couponSystem.updateCouponStatus(orderId, RedemptionStatus.REDEEMED);

        couponRedemption = couponSystem.getCouponRedemptionEntryByOrderId(
            orderId
        );

        System.out.println("====== Coupon Entry =====");
        System.out.println("OrderId " + couponRedemption.getOderId());
        System.out.println("TotalAmount " + couponRedemption.getTotal_amount());
        System.out.println(
            "Amount after discount " + couponRedemption.getDiscounted_amount()
        );
        System.out.println("Status " + couponRedemption.getRedemptionStatus());
    }
}
