package com.example.tireshop.repository;

import com.example.tireshop.model.MountingSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MountingScheduleRepository extends JpaRepository<MountingSchedule, UUID> {}