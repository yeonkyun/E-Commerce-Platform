package edu.sunmoon.orderDetail;

import edu.sunmoon.service.OrderDetailService;

public class OrderDetailDelete {
    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();
        try {
            System.out.println(orderDetailService.remove(82));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
