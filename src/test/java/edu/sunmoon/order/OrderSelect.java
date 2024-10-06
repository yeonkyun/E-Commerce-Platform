package edu.sunmoon.order;

import edu.sunmoon.dto.Order;
import edu.sunmoon.service.OrderService;

import java.util.List;

public class OrderSelect {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        try {
            List<Order> orders = orderService.get();
            for (Order order : orders) {
                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
