package edu.sunmoon.orderDetail;

import edu.sunmoon.dto.OrderDetail;
import edu.sunmoon.service.OrderDetailService;

public class OrderDetailUpdate {
    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();
        try {
            System.out.println(orderDetailService.modify(OrderDetail.builder()
                    .id(83)
                    .price(100000)
                    .discountPrice(5000)
                    .quantity(2)
                    .build()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
