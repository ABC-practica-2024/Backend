package ro.ubb.abc2024.biology.repository.teeth.permanent;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentPremolar;

public interface PermanentPremolarRepository extends JpaRepository<PermanentPremolar, Long> {
}
