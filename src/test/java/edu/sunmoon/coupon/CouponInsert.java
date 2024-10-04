package edu.sunmoon.coupon;

import edu.sunmoon.dto.Coupon;
import edu.sunmoon.service.CouponService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CouponInsert {
    public static void main(String[] args) {
        CouponService service = new CouponService();
        try {
            service.add(Coupon.builder()
                    .name("9월 10% 할인 쿠폰")
                    .code("SEP10")
                    .type("퍼센트")
                    .discount(10)
                    .minOrderPrice(10000)
                    .maxDiscountPrice(10000)
                    .startDate(LocalDateTime.parse("2024-09-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .endDate(LocalDateTime.parse("2024-09-30 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .isActive(true)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
