package ro.ubb.abc2024.biology.repository.teeth.permanent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMandibleMolar3;

import java.util.List;
import java.util.UUID;

public interface PermanentMandibleMolar3Repository extends JpaRepository<PermanentMandibleMolar3, Long> {
    @Query("SELECT c FROM PermanentMandibleMolar3 c WHERE c.artefactId = :artefactId")
    List<PermanentMandibleMolar3> getAllByArtefactId(@Param("artefactId") UUID artefactId);

}
