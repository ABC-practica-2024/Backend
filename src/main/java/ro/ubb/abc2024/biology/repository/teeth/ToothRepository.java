package ro.ubb.abc2024.biology.repository.teeth;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.biology.domain.Tooth;

public interface ToothRepository extends JpaRepository<Tooth, Long> {
}
