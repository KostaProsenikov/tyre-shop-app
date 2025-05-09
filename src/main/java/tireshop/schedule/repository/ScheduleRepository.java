package tireshop.schedule.repository;

import tireshop.schedule.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {

    Optional<Schedule> findByAvailableSlotAndIsBookedFalse(LocalDateTime availableSlot);

    List<Schedule> findTop10ByIsBookedFalseOrderByAvailableSlotAsc();

}