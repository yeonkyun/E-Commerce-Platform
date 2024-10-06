package edu.sunmoon.orderDetail;

import edu.sunmoon.dto.OrderDetail;
import edu.sunmoon.service.OrderDetailService;

public class OrderDetailInsert {
    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();
        try {
            orderDetailService.add(OrderDetail.builder()
                            .orderId(62)
                            .productId(102)
                            .quantity(1)
                            .price(100000)
                            .discountPrice(9000)
                            .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
