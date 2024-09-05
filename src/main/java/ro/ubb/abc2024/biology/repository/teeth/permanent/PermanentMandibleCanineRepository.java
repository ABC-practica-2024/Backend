package ro.ubb.abc2024.biology.repository.teeth.permanent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleCanine;

import java.util.List;
import java.util.UUID;

public interface PermanentMandibleCanineRepository extends JpaRepository<PermanentMandibleCanine, Long> {
    @Query("SELECT c FROM PermanentMandibleCanine c WHERE c.artefactId = :artefactId")
    List<PermanentMandibleCanine> getAllByArtefactId(@Param("artefactId") UUID artefactId);

}
