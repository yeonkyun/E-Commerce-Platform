package edu.sunmoon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private int id;
    private String customerId;
    private String type;    // 집, 회사, 기타
    private String name;
    private String phone;
    private String address1;
    private String address2;
    private String zipCode;
    private boolean isDefault;
}