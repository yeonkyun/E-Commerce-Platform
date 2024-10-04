package edu.sunmoon.couponBox;

import edu.sunmoon.dto.CouponBox;
import edu.sunmoon.service.CouponBoxService;

public class CouponBoxInsert {
    public static void main(String[] args) {
        CouponBoxService service = new CouponBoxService();
        try {
            service.add(CouponBox.builder()
                    .customerId("customer999")
                    .couponId(31)
                    .isUsed(false)
                    .build());
            System.out.println("CouponBox inserted: " + service.getByCustomerId("customer999"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
