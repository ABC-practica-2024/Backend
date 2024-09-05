package ro.ubb.abc2024.biology.repository.teeth.deciduous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar1;

import java.util.List;
import java.util.UUID;

public interface DeciduousMaxillaMolar1Repository extends JpaRepository<DeciduousMaxillaMolar1, Long> {
    @Query("SELECT c FROM DeciduousMaxillaMolar1 c WHERE c.artefactId = :artefactId")
    List<DeciduousMaxillaMolar1> getAllByArtefactId(@Param("artefactId") UUID artefactId);

}
