package tireshop.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tireshop.schedule.model.Schedule;
import tireshop.tracking.model.Tracking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String username;

    private String password;

    private String fullName;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private boolean isActive;

    private boolean isDeleted;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tracking> trackings = new ArrayList<>();

    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedules = new ArrayList<>();

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;
}
