package edu.sunmoon.usedCoupon;

import edu.sunmoon.service.UsedCouponService;

public class UsedCouponDelete {
    public static void main(String[] args) {
        UsedCouponService usedCouponService = new UsedCouponService();
        try {
            boolean result = usedCouponService.remove(32);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
