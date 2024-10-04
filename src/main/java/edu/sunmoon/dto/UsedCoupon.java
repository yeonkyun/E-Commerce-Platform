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
public class UsedCoupon {
    private int id;
    private int orderDetailId;
    private int couponId;
    private int couponDiscountPrice;
    private LocalDateTime createdAt;
}