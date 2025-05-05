package tireshop.tracking.model;

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
public class Tracking {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID orderId;

    private String currentLocation;

    private String status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    private LocalDateTime updatedOn = LocalDateTime.now();

    private LocalDateTime createdOn;
}
