package com.example.tireshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tracking {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID orderId;
    private String currentLocation;
    private String status;
    private LocalDateTime updatedAt = LocalDateTime.now();
}
