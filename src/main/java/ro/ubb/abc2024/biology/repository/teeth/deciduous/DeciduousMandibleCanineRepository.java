package ro.ubb.abc2024.biology.repository.teeth.deciduous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleCanine;

import java.util.List;
import java.util.UUID;

public interface DeciduousMandibleCanineRepository extends JpaRepository<DeciduousMandibleCanine, Long> {
    @Query("SELECT c FROM DeciduousMandibleCanine c WHERE c.artefactId = :artefactId")
    List<DeciduousMandibleCanine> getAllByArtefactId(@Param("artefactId") UUID artefactId);
}
