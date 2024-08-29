package ro.ubb.abc2024.biology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.biology.domain.Teeth;

public interface TeethRepository extends JpaRepository<Teeth, Long> {
}
