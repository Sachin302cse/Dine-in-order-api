package com.example.dine_in_order_api.dto.response;

import com.example.dine_in_order_api.enums.UserRole;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private long userId;
    private String username;
    private UserRole role;
    private LocalDate createdAt;
    private LocalDate lastModified;

}
