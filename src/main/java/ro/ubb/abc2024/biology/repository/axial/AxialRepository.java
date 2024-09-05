package ro.ubb.abc2024.biology.repository.axial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.ubb.abc2024.biology.domain.axial.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AxialRepository extends JpaRepository<Axial, Long> {

    //    -----------------------------------------Coccyx---------------------------------------------------
    @Query(value = "select c from Coccyx c where c.id=:id")
    Optional<Coccyx> getCoccyxById(Long id);

    @Query("SELECT c FROM Coccyx c WHERE c.artefactId = :artefactId")
    List<Coccyx> findAllCoccyxByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Ribs---------------------------------------------------
    @Query(value = "select c from Ribs c where c.id=:id")
    Optional<Ribs> getRibsById(Long id);

    @Query("SELECT c FROM Ribs c WHERE c.artefactId = :artefactId")
    List<Ribs> findAllRibsByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Sacrum---------------------------------------------------
    @Query(value = "select c from Sacrum c where c.id=:id")
    Optional<Sacrum> getSacrumById(Long id);

    @Query("SELECT c FROM Sacrum c WHERE c.artefactId = :artefactId")
    List<Sacrum> findAllSacrumByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Sternum---------------------------------------------------
    @Query(value = "select c from Sternum c where c.id=:id")
    Optional<Sternum> getSternumById(Long id);

    @Query("SELECT c FROM Sternum c WHERE c.artefactId = :artefactId")
    List<Sternum> findAllSternumByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Vertebrae---------------------------------------------------
    @Query(value = "select c from Vertebrae c where c.id=:id")
    Optional<Vertebrae> getVertebraeById(Long id);

    @Query("SELECT c FROM Vertebrae c WHERE c.artefactId = :artefactId")
    List<Vertebrae> findAllVertebraeByArtefactId(@Param("artefactId") UUID artefactId);

}

