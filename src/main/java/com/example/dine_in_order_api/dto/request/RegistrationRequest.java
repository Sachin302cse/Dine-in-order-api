package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {

//    @NotNull
    @NotBlank
    @NotEmpty(message = "User name cannot be null and blank")// its is the combination of @NotNull and @NotBlank
    private String username;

    @NotBlank
    @NotEmpty(message = "Email cannot be null and blank")
    private String email;
    private String password;
    private String phoneNumber;
    private UserRole role;


}
