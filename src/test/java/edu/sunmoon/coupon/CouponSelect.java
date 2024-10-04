package edu.sunmoon.coupon;

import edu.sunmoon.dto.Coupon;
import edu.sunmoon.service.CouponService;

import java.util.List;

public class CouponSelect {
    public static void main(String[] args) {
        CouponService service = new CouponService();
        try {
            List<Coupon> list = service.get();
            for (Coupon coupon : list) {
                System.out.println(coupon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
