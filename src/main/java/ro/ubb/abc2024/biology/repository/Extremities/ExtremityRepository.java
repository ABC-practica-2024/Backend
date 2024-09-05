package ro.ubb.abc2024.biology.repository.Extremities;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.ubb.abc2024.biology.domain.Extremities.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExtremityRepository extends JpaRepository<Extremity, Long> {

    //    -----------------------------------------CAlCANEUS---------------------------------------------------
    @Query(value = "select c from Calcaneus c where c.id=:id")
    Optional<Calcaneus> getCalcaneusById(long id);
    @Query(value = "select c from Calcaneus c")
    List<Calcaneus> getAllCalcaneus();

    @Query("SELECT c FROM Calcaneus c WHERE c.artefactId = :artefactId")
    List<Calcaneus> findCalcaneusAllByArtefactId(@Param("artefactId") UUID artefactId);


//    -----------------------------------------CARPALS---------------------------------------------------
    @Query(value = "select c from Carpals c where c.id=:id")
    Optional<Carpals> getCarpalsById(long id);
    @Query(value = "select c from Carpals c")
    List<Carpals> getAllCarpals();

    @Query("SELECT c FROM Carpals c WHERE c.artefactId = :artefactId")
    List<Carpals> findAllCarpalsByArtefactId(@Param("artefactId") UUID artefactId);


    //    -----------------------------------------METACARPALS---------------------------------------------------

    @Query(value = "select m from Metacarpals m where m.id=:id")
    Optional<Metacarpals> getMetacarpalsById(long id);
    @Query(value = "select m from Metacarpals m")
    List<Metacarpals> getAllMetacarpals();

    @Query("SELECT c FROM Metacarpals c WHERE c.artefactId = :artefactId")
    List<Metacarpals> findAllMetacarpalsByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------METATARSALS---------------------------------------------------

    @Query(value = "select m from Metatarsals m where m.id=:id")
    Optional<Metatarsals> getMetatarsalsById(long id);
    @Query(value = "select m from Metatarsals m")
    List<Metatarsals> getAllMetatarsals();

    @Query("SELECT c FROM Metatarsals c WHERE c.artefactId = :artefactId")
    List<Metatarsals> findAllMetatarsalsByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------OTHER TARSALS---------------------------------------------------

    @Query(value = "select o from OtherTarsals o where o.id=:id")
    Optional<OtherTarsals> getOtherTarsalsById(long id);
    @Query(value = "select o from OtherTarsals o")
    List<OtherTarsals> getAllOtherTarsals();

    @Query("SELECT c FROM OtherTarsals c WHERE c.artefactId = :artefactId")
    List<OtherTarsals> findAllOtherTarsalsByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------PHALANGES---------------------------------------------------

    @Query(value = "select p from Phalanges p where p.id=:id")
    Optional<Phalanges> getPhalangesById(long id);
    @Query(value = "select p from Phalanges p")
    List<Phalanges> getAllPhalanges();

    @Query("SELECT c FROM Phalanges c WHERE c.artefactId = :artefactId")
    List<Phalanges> findAllPhalangesByArtefactId(@Param("artefactId") UUID artefactId);

}
