package ro.ubb.abc2024.biology.repository.teeth.deciduous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMaxillaMolar2;

import java.util.List;
import java.util.UUID;

public interface DeciduousMaxillaMolar2Repository extends JpaRepository<DeciduousMaxillaMolar2, Long> {
    @Query("SELECT c FROM DeciduousMaxillaMolar2 c WHERE c.artefactId = :artefactId")
    List<DeciduousMaxillaMolar2> getAllByArtefactId(@Param("artefactId") UUID artefactId);

}
