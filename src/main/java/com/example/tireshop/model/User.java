package com.example.tireshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private String role; // e.g., ROLE_USER, ROLE_ADMIN
}
