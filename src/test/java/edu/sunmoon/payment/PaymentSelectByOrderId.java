package edu.sunmoon.payment;

import edu.sunmoon.service.PaymentService;

public class PaymentSelectByOrderId {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        try {
            System.out.println(service.getByOrderId(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
