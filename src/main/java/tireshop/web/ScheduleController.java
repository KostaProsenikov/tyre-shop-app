package tireshop.web;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tireshop.schedule.model.Schedule;
import tireshop.schedule.service.ScheduleService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping ("/book")
    public ResponseEntity<Object> bookSlot(@RequestParam UUID userId,
                                      @RequestParam UUID orderId,
                                      @RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime slot) {
        Optional<Schedule> result = scheduleService.checkAndBookSlot(userId, slot, orderId);
        return (ResponseEntity<Object>) result.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Requested time slot is not available."));
    }
}
