package ro.ubb.abc2024.biology.repository.teeth.permanent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.permanent.PermanentMaxillaIncisor2;

import java.util.List;
import java.util.UUID;

public interface PermanentMaxillaIncisor2Repository extends JpaRepository<PermanentMaxillaIncisor2, Long> {
    @Query("SELECT c FROM PermanentMaxillaIncisor2 c WHERE c.artefactId = :artefactId")
    List<PermanentMaxillaIncisor2> getAllByArtefactId(@Param("artefactId") UUID artefactId);

}
