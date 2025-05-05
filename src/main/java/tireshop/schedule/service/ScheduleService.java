package tireshop.schedule.service;

import org.springframework.stereotype.Service;
import tireshop.schedule.model.Schedule;
import tireshop.schedule.repository.ScheduleRepository;
import tireshop.user.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final UserRepository userRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }

    public Optional<Schedule> checkAndBookSlot(UUID userId, LocalDateTime requestedSlot, UUID orderId) {
        if (requestedSlot.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Requested time slot must be in the future.");
        }

        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User with provided ID does not exist.");
        }

        Optional<Schedule> slotOpt = scheduleRepository.findByAvailableSlotAndIsBookedFalse(requestedSlot);

        if (slotOpt.isEmpty()) {
            throw new IllegalStateException("Requested time slot is not available.");
        }

        Schedule slot = slotOpt.get();
        slot.setBooked(true);
        slot.setOrderId(orderId);
        userRepository.findById(userId).ifPresent(slot::setUser);
        slot.setUpdatedOn(LocalDateTime.now());

        return Optional.of(scheduleRepository.save(slot));
    }
}
