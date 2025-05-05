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
        Optional<Schedule> slotOpt = scheduleRepository.findByAvailableSlotAndIsBookedFalse(requestedSlot);

        if (slotOpt.isPresent()) {
            Schedule slot = slotOpt.get();
            slot.setBooked(true);
            slot.setOrderId(orderId);

            userRepository.findById(userId).ifPresent(slot::setUser);
            slot.setUpdatedOn(LocalDateTime.now());

            return Optional.of(scheduleRepository.save(slot));
        }

        return Optional.empty();
    }
}
