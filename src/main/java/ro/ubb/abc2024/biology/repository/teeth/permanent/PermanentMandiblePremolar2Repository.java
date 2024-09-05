package ro.ubb.abc2024.biology.repository.teeth.permanent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandiblePremolar2;

import java.util.List;
import java.util.UUID;

public interface PermanentMandiblePremolar2Repository extends JpaRepository<PermanentMandiblePremolar2, Long> {
    @Query("SELECT c FROM PermanentMandiblePremolar2 c WHERE c.artefactId = :artefactId")
    List<PermanentMandiblePremolar2> getAllByArtefactId(@Param("artefactId") UUID artefactId);

}
