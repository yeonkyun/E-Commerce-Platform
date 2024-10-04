package edu.sunmoon.coupon;

import edu.sunmoon.service.CouponService;

public class CouponSelectByCode {
    public static void main(String[] args) {
        CouponService service = new CouponService();
        try {
            System.out.println(service.get("SEP10"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
