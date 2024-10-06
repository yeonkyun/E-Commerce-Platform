package edu.sunmoon.payment;

import edu.sunmoon.service.PaymentService;

public class PaymentDelete {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        try {
            System.out.println(paymentService.remove(63));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
