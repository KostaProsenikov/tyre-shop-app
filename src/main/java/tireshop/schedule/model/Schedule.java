package tireshop.schedule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tireshop.user.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID orderId;

    private LocalDateTime availableSlot;

    private boolean isBooked;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn = LocalDateTime.now();
}
