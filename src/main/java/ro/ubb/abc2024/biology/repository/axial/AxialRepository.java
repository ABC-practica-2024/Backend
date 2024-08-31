package ro.ubb.abc2024.biology.repository.axial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ubb.abc2024.biology.domain.axial.*;

import java.util.Optional;

@Repository
public interface AxialRepository extends JpaRepository<Axial, Long> {

    //    -----------------------------------------Coccyx---------------------------------------------------
    @Query(value = "select c from Coccyx c where c.id=:id")
    Optional<Coccyx> getCoccyxById(Long id);

    //    -----------------------------------------Ribs---------------------------------------------------
    @Query(value = "select c from Ribs c where c.id=:id")
    Optional<Ribs> getRibsById(Long id);

    //    -----------------------------------------Sacrum---------------------------------------------------
    @Query(value = "select c from Sacrum c where c.id=:id")
    Optional<Sacrum> getSacrumById(Long id);

    //    -----------------------------------------Sternum---------------------------------------------------
    @Query(value = "select c from Sternum c where c.id=:id")
    Optional<Sternum> getSternumById(Long id);

    //    -----------------------------------------Vertebrae---------------------------------------------------
    @Query(value = "select c from Vertebrae c where c.id=:id")
    Optional<Vertebrae> getVertebraeById(Long id);
}
