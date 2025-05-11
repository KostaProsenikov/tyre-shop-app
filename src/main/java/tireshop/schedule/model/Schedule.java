package tireshop.schedule.model;

import jakarta.persistence.*;
import lombok.*;
import tireshop.user.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID orderId;

    private LocalDateTime availableSlot;

    private boolean isBooked;

    @ManyToOne()
    private User user;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn = LocalDateTime.now();
}
