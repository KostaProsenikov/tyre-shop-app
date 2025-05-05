package tireshop.tire.repository;

import tireshop.tire.model.Tire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TireRepository extends JpaRepository<Tire, UUID> {}