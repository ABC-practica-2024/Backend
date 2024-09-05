package ro.ubb.abc2024.biology.repository.teeth.deciduous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.ubb.abc2024.biology.domain.teeth.deciduous.DeciduousMandibleIncisor1;

import java.util.List;
import java.util.UUID;

public interface DeciduousMandibleIncisor1Repository extends JpaRepository<DeciduousMandibleIncisor1, Long> {
    @Query("SELECT c FROM DeciduousMandibleIncisor1 c WHERE c.artefactId = :artefactId")
    List<DeciduousMandibleIncisor1> getAllByArtefactId(@Param("artefactId") UUID artefactId);

}
