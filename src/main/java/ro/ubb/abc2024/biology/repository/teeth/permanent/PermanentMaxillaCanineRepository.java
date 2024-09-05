package ro.ubb.abc2024.biology.repository.teeth.permanent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaCanine;

import java.util.List;
import java.util.UUID;

public interface PermanentMaxillaCanineRepository extends JpaRepository<PermanentMaxillaCanine, Long> {
    @Query("SELECT c FROM PermanentMaxillaCanine c WHERE c.artefactId = :artefactId")
    List<PermanentMaxillaCanine> getAllByArtefactId(@Param("artefactId") UUID artefactId);

}
