package com.example.tireshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tire {
    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated (EnumType.STRING)
    private TireBrand brand;

    private String model;
    private String size;
    private double price;
    private int stock;

    private int width;
    private int aspectRatio;
    private int diameter;
}
