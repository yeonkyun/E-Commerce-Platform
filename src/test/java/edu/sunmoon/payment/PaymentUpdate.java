package edu.sunmoon.payment;

import edu.sunmoon.dto.Payment;
import edu.sunmoon.service.PaymentService;

public class PaymentUpdate {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        try {
            System.out.println(paymentService.modify(Payment.builder()
                    .id(66)
                    .status("결제취소")
                    .build()));
            System.out.println(paymentService.get(66));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
