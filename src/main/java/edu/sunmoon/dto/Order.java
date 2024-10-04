package edu.sunmoon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private String customerId;
    private String name;
    private String phone;
    private String address1;
    private String address2;
    private String zipCode;
    private int totalPrice;
    private String status;  // ENUM ('주문완료', '결제완료', '배송중', '배송완료', '취소')
    private LocalDateTime createdAt;
}