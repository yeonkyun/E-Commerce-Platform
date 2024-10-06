package edu.sunmoon.order;

import edu.sunmoon.service.OrderService;

public class OrderDelete {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        try {
            orderService.remove(62);
            System.out.println("Deleted: " + orderService.get(62));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
