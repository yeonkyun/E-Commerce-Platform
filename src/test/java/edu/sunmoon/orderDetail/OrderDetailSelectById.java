package edu.sunmoon.orderDetail;

import edu.sunmoon.service.OrderDetailService;

public class OrderDetailSelectById {
    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();
        try {
            System.out.println(orderDetailService.get(77));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
