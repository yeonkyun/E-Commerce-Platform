package edu.sunmoon.couponBox;

import edu.sunmoon.service.CouponBoxService;

public class CouponBoxDelete {
    public static void main(String[] args) {
        CouponBoxService service = new CouponBoxService();
        try {
            boolean result = service.remove(52);
            System.out.println("Delete result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
