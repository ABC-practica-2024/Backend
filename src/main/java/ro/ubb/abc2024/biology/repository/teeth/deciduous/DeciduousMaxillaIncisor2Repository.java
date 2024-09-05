package ro.ubb.abc2024.biology.repository.teeth.deciduous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaIncisor2;

import java.util.List;
import java.util.UUID;

public interface DeciduousMaxillaIncisor2Repository extends JpaRepository<DeciduousMaxillaIncisor2, Long> {
    @Query("SELECT c FROM DeciduousMaxillaIncisor2 c WHERE c.artefactId = :artefactId")
    List<DeciduousMaxillaIncisor2> getAllByArtefactId(@Param("artefactId") UUID artefactId);

}
