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
public class Coupon {
    private int id;
    private String name;
    private String code;
    private String type;    // ENUM (퍼센트, 금액)
    private int discount;
    private int minOrderPrice;
    private int maxDiscountPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isActive;
    private LocalDateTime createdAt;
}