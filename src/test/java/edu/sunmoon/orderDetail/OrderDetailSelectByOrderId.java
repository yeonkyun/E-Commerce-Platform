package edu.sunmoon.orderDetail;

import edu.sunmoon.dto.OrderDetail;
import edu.sunmoon.service.OrderDetailService;

import java.util.List;

public class OrderDetailSelectByOrderId {
    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();
        try {
            List<OrderDetail> list = orderDetailService.getByOrderId(11);
            for (OrderDetail orderDetail : list) {
                System.out.println(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
