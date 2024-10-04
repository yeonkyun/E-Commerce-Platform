package edu.sunmoon.couponBox;

import edu.sunmoon.service.CouponBoxService;

public class CouponBoxSelectByCouponId {
    public static void main(String[] args) {
        CouponBoxService service = new CouponBoxService();
        try {
            System.out.println(service.getByCouponId("1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
