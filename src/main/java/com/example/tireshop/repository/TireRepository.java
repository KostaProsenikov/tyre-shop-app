package com.example.tireshop.repository;

import com.example.tireshop.model.Tire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TireRepository extends JpaRepository<Tire, UUID> {}