package edu.sunmoon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data               // @Getter, @Setter, @ToString, @EqualsAndHashCode
@Builder            // @Builder
@NoArgsConstructor  // @NoArgsConstructor
@AllArgsConstructor // @AllArgsConstructor
public class Customer {
    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String level;   // ENUM('일반', '실버', '골드', 'VIP')
    private LocalDate birthDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean status;
}