package edu.sunmoon.usedCoupon;

import edu.sunmoon.dto.UsedCoupon;
import edu.sunmoon.service.UsedCouponService;

import java.util.List;

public class UsedCouponSelect {
    public static void main(String[] args) {
        UsedCouponService usedCouponService = new UsedCouponService();
        try {
            List<UsedCoupon> usedCoupons = usedCouponService.get();
            for (UsedCoupon usedCoupon : usedCoupons) {
                System.out.println(usedCoupon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
