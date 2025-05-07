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
import java.security.Principal;
import tireshop.user.model.User;
import tireshop.user.service.CustomUserDetailsService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final CustomUserDetailsService userDetailsService;

    public ScheduleController(ScheduleService scheduleService, CustomUserDetailsService userDetailsService) {
        this.scheduleService = scheduleService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/book")
    public ResponseEntity<Object> bookSlot(@RequestParam UUID orderId,
                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime slot,
                                           Principal principal) {
        Optional<User> userOpt = userDetailsService.findUserByUsername(principal.getName());
        System.out.printf("User ID: %s%n", userOpt.map(User::getId).orElse(null));
        System.out.println("Principal: " + principal);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user");
        }

        UUID userId = userOpt.get().getId();
        Optional<Schedule> result = scheduleService.checkAndBookSlot(userId, slot, orderId);
        return (ResponseEntity<Object>) result.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Requested time slot is not available."));
    }
}
