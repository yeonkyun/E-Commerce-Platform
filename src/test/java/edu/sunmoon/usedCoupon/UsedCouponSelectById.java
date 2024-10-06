package edu.sunmoon.usedCoupon;

import edu.sunmoon.service.UsedCouponService;

public class UsedCouponSelectById {
    public static void main(String[] args) {
        UsedCouponService usedCouponService = new UsedCouponService();
        try {
            System.out.println(usedCouponService.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
