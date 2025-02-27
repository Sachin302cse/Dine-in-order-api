package com.example.dine_in_order_api.model;

import com.example.dine_in_order_api.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name ="users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private UserRole userRole;
    private LocalDate createdAt;
    private LocalDate lastModified;

}
