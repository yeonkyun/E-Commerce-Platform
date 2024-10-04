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
public class Product {
    private int id;
    private int categoryId;
    private String name;
    private String description;
    private int price;
    private int stockQuantity;
    private boolean isSelling;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}