package ro.ubb.abc2024.biology.repository.teeth.permanent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaMolar3;

import java.util.List;
import java.util.UUID;

public interface PermanentMaxillaMolar3Repository extends JpaRepository<PermanentMaxillaMolar3, Long> {
    @Query("SELECT c FROM PermanentMaxillaMolar3 c WHERE c.artefactId = :artefactId")
    List<PermanentMaxillaMolar3> getAllByArtefactId(@Param("artefactId") UUID artefactId);

}
