package ro.ubb.abc2024.biology.repository.teeth.deciduous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaCanine;

import java.util.List;
import java.util.UUID;

public interface DeciduousMaxillaCanineRepository extends JpaRepository<DeciduousMaxillaCanine, Long> {
    @Query("SELECT c FROM DeciduousMaxillaCanine c WHERE c.artefactId = :artefactId")
    List<DeciduousMaxillaCanine> getAllByArtefactId(@Param("artefactId") UUID artefactId);

}
