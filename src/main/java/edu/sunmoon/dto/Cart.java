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
public class Cart {
    private int id;
    private String customerId;
    private int productId;
    private int quantity;
    private int totalPrice;
    private LocalDateTime createdAt;
}