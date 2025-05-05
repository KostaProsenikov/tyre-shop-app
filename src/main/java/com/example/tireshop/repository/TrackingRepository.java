package com.example.tireshop.repository;

import com.example.tireshop.model.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackingRepository extends JpaRepository<Tracking, UUID> {}