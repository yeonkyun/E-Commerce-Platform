package edu.sunmoon.payment;

import edu.sunmoon.dto.Payment;
import edu.sunmoon.service.PaymentService;

public class PaymentInsert {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        try {
            System.out.println(paymentService.add(Payment.builder()
                    .orderId(62)
                    .paymentMethod("신용카드")
                    .status("결제완료")
                    .build()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
