package ro.ubb.abc2024.biology.repository.teeth;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.abc2024.biology.domain.teeth.Tooth;

public interface ToothRepository<T extends Tooth> extends JpaRepository<T, Long> {
}
