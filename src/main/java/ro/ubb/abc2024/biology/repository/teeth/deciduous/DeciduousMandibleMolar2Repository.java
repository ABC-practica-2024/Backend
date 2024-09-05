package ro.ubb.abc2024.biology.repository.teeth.deciduous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleMolar2;

import java.util.List;
import java.util.UUID;

public interface DeciduousMandibleMolar2Repository extends JpaRepository<DeciduousMandibleMolar2, Long> {
    @Query("SELECT c FROM DeciduousMandibleMolar2 c WHERE c.artefactId = :artefactId")
    List<DeciduousMandibleMolar2> getAllByArtefactId(@Param("artefactId") UUID artefactId);

}
