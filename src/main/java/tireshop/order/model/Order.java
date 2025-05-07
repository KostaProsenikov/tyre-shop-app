package tireshop.order.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tireshop.tire.model.Tire;
import tireshop.user.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue
    private UUID id;

    private String customerName;

    private String customerContact;

    private LocalDateTime orderDate = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "order_tires",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "tire_id")
    )
    private List<Tire> tires;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;
}

