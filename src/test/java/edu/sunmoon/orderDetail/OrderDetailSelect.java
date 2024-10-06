package edu.sunmoon.orderDetail;

import edu.sunmoon.dto.OrderDetail;
import edu.sunmoon.service.OrderDetailService;

import java.util.List;

public class OrderDetailSelect {
    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();
        try {
            List<OrderDetail> list = orderDetailService.get();
            for (OrderDetail orderDetail : list) {
                System.out.println(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
