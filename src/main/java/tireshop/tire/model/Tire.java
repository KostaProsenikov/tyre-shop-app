package tireshop.tire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tire {
    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated (EnumType.STRING)
    private TireBrand brand;

    private String model;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private BigDecimal price;

    @Column()
    private int stock;

    @Column(nullable = false)
    private int width;

    @Column(nullable = false)
    private int aspectRatio;

    @Column(nullable = false)
    private int diameter;

    @Column()
    private LocalDateTime createdOn;

    @Column()
    private LocalDateTime updatedOn;
}
