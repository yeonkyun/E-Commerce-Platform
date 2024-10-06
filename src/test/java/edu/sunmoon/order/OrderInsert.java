package edu.sunmoon.order;

import edu.sunmoon.dto.Order;
import edu.sunmoon.service.OrderService;

public class OrderInsert {
    public static void main(String[] args) {
        OrderService service = new OrderService();
        Order order = Order.builder()
                .customerId("customer999")
                .name("정연균")
                .phone("010-5213-0917")
                .address1("경기도 성남시 분당구 정자동")
                .address2("정자동 178-2")
                .zipCode("13509")
                .totalPrice(100000)
                .status("주문완료")
                .build();
        try {
            Order result = service.add(order);
            System.out.println("Inserted: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
