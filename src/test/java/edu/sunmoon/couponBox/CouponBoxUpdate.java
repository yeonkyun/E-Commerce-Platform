package edu.sunmoon.couponBox;

import edu.sunmoon.dto.CouponBox;
import edu.sunmoon.service.CouponBoxService;

public class CouponBoxUpdate {
    public static void main(String[] args) {
        CouponBoxService service = new CouponBoxService();
        try {
            service.modify(CouponBox.builder()
                    .id(51)
                    .couponId(31)
                    .customerId("customer999")
                    .isUsed(false)
                    .build());
            System.out.println(service.getByCustomerId("customer999"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
