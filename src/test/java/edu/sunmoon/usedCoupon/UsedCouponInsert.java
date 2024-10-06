package edu.sunmoon.usedCoupon;

import edu.sunmoon.dto.UsedCoupon;
import edu.sunmoon.service.UsedCouponService;

public class UsedCouponInsert {
    public static void main(String[] args) {
        UsedCouponService usedCouponService = new UsedCouponService();
        try {
            System.out.println(usedCouponService.add(UsedCoupon.builder()
                    .orderDetailId(77)
                    .couponId(3)
                    .couponDiscountPrice(5000)
                    .build()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
