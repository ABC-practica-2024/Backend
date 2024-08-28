package ro.ubb.abc2024.biology.repository.teeth.permanent;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentCanine;

public interface PermanentCanineRepository extends JpaRepository<PermanentCanine, Long> {
}
