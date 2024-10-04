package edu.sunmoon.couponBox;

import edu.sunmoon.dto.CouponBox;
import edu.sunmoon.service.CouponBoxService;

import java.util.List;

public class CouponBoxSelect {
    public static void main(String[] args) {
        CouponBoxService service = new CouponBoxService();
        try {
            List<CouponBox> list = service.get();
            for (CouponBox couponBox : list) {
                System.out.println(couponBox);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
