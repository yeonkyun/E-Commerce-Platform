package edu.sunmoon.coupon;

import edu.sunmoon.service.CouponService;

public class CouponDelete {
    public static void main(String[] args) {
        CouponService service = new CouponService();
        try {
            Boolean result = service.remove("SEP10");
            System.out.println("CouponDelete - " + result);
            System.out.println(service.get("SEP10"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
