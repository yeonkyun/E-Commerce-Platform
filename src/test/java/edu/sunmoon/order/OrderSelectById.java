package edu.sunmoon.order;

import edu.sunmoon.service.OrderService;

public class OrderSelectById {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        try {
            System.out.println(orderService.get(62));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
