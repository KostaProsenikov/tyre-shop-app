package tireshop.tracking.repository;

import tireshop.tracking.model.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackingRepository extends JpaRepository<Tracking, UUID> {}