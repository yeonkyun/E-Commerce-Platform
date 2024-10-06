package edu.sunmoon.payment;

import edu.sunmoon.service.PaymentService;

public class PaymentSelectById {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        try {
            System.out.println(service.get(62));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
