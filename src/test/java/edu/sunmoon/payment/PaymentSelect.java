package edu.sunmoon.payment;

import edu.sunmoon.dto.Payment;
import edu.sunmoon.service.PaymentService;

import java.util.List;

public class PaymentSelect {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        try {
            List<Payment> list = service.get();
            for (Payment payment : list) {
                System.out.println(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
