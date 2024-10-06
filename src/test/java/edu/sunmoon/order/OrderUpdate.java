package edu.sunmoon.order;

import edu.sunmoon.dto.Order;
import edu.sunmoon.service.OrderService;

public class OrderUpdate {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        try {
            Order order = Order.builder()
                    .id(62)
                    .name("정연균")
                    .phone("010-5213-0917")
                    .address1("경기도 성남시 분당구 정자동")
                    .address2("정자동 178-1")
                    .zipCode("13509")
                    .status("배송중")
                    .build();
            orderService.modify(order);
            System.out.println("Updated: " + orderService.get(62));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
