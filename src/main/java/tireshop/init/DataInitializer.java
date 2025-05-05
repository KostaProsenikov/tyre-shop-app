package tireshop.init;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tireshop.tire.model.Tire;
import tireshop.tire.model.TireBrand;
import tireshop.tire.repository.TireRepository;
import tireshop.user.model.User;
import tireshop.user.model.UserRole;
import tireshop.user.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    private final TireRepository tireRepository;

    @Autowired
    public DataInitializer(UserRepository userRepository, TireRepository tireRepository) {
        this.userRepository = userRepository;
        this.tireRepository = tireRepository;
    }

    @PostConstruct
    public void init() {
        try {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123"));
                admin.setFullName("Admin User");
                admin.setEmail("admin@example.com");
                admin.setPhone("1234567890");
                admin.setRole(UserRole.ROLE_ADMIN);
                admin.setCreatedOn(LocalDateTime.now());
                admin.setUpdatedOn(LocalDateTime.now());

                userRepository.save(admin);
            }
            if (userRepository.findByUsername("user1").isEmpty()) {
                User user1 = new User();
                user1.setUsername("user1");
                user1.setPassword(encoder.encode("user1"));
                user1.setFullName("John Doe");
                user1.setEmail("john.doe@example.com");
                user1.setPhone("5551112222");
                user1.setRole(UserRole.ROLE_USER);
                user1.setCreatedOn(LocalDateTime.now());
                user1.setUpdatedOn(LocalDateTime.now());
                userRepository.save(user1);
            }
            if (userRepository.findByUsername("user2").isEmpty()) {
                User user2 = new User();
                user2.setUsername("user2");
                user2.setPassword(encoder.encode("user2"));
                user2.setFullName("Jane Smith");
                user2.setEmail("jane.smith@example.com");
                user2.setPhone("123444444");
                user2.setRole(UserRole.ROLE_USER);
                user2.setCreatedOn(LocalDateTime.now());
                user2.setUpdatedOn(LocalDateTime.now());
                userRepository.save(user2);
            }
            if (userRepository.findByUsername("user3").isEmpty()) {
                User user3 = new User();
                user3.setUsername("user3");
                user3.setPassword(encoder.encode("user3"));
                user3.setFullName("User Three");
                user3.setEmail("john.doe3@example.com");
                user3.setPhone("1234567");
                user3.setRole(UserRole.ROLE_USER);
                user3.setCreatedOn(LocalDateTime.now());
                user3.setUpdatedOn(LocalDateTime.now());
                userRepository.save(user3);
            }
            if (tireRepository.count() == 0) {
                tireRepository.saveAll(List.of(
                        new Tire(null, TireBrand.MICHELIN, "Primacy 4", "205/55R16", new BigDecimal("95.0"), 100, 205, 55, 16,  LocalDateTime.now(), LocalDateTime.now()),
                        new Tire(null, TireBrand.BRIDGESTONE, "Turanza T005", "195/65R15", new BigDecimal("85.5"), 120, 195, 65, 15, LocalDateTime.now(), LocalDateTime.now()),
                        new Tire(null, TireBrand.CONTINENTAL, "PremiumContact 6", "225/45R17", new BigDecimal("110.0"), 80, 225, 45, 17, LocalDateTime.now(), LocalDateTime.now())
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}