package ro.ubb.abc2024.biology.repository.Extremities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Extremities.Carpals;

@Service
public interface CarpalsRepository extends JpaRepository<Carpals, Long> {
}
