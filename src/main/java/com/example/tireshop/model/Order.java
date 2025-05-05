package com.example.tireshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue
    private UUID id;

    private String customerName;
    private String customerContact;
    private LocalDateTime orderDate = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tire> tires;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}

