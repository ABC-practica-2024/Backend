package ro.ubb.abc2024.biology.repository.Extremities;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ubb.abc2024.biology.domain.Extremities.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExtremityRepository extends JpaRepository<Extremity, Long> {

    //    -----------------------------------------CAlCANEUS---------------------------------------------------
    @Query(value = "select c from Calcaneus c where c.id=:id")
    Optional<Calcaneus> getCalcaneusById(long id);
    @Query(value = "select c from Calcaneus c")
    List<Calcaneus> getAllCalcaneus();

//    -----------------------------------------CARPALS---------------------------------------------------
    @Query(value = "select c from Carpals c where c.id=:id")
    Optional<Carpals> getCarpalsById(long id);
    @Query(value = "select c from Carpals c")
    List<Carpals> getAllCarpals();




    //    -----------------------------------------METACARPALS---------------------------------------------------

    @Query(value = "select m from Metacarpals m where m.id=:id")
    Optional<Metacarpals> getMetacarpalsById(long id);
    @Query(value = "select m from Metacarpals m")
    List<Metacarpals> getAllMetacarpals();

    //    -----------------------------------------METATARSALS---------------------------------------------------

    @Query(value = "select m from Metatarsals m where m.id=:id")
    Optional<Metatarsals> getMetatarsalsById(long id);
    @Query(value = "select m from Metatarsals m")
    List<Metatarsals> getAllMetatarsals();

    //    -----------------------------------------OTHER TARSALS---------------------------------------------------

    @Query(value = "select o from OtherTarsals o where o.id=:id")
    Optional<OtherTarsals> getOtherTarsalsById(long id);
    @Query(value = "select o from OtherTarsals o")
    List<OtherTarsals> getAllOtherTarsals();

    //    -----------------------------------------PHALANGES---------------------------------------------------

    @Query(value = "select p from Phalanges p where p.id=:id")
    Optional<Phalanges> getPhalangesById(long id);
    @Query(value = "select p from Phalanges p")
    List<Phalanges> getAllPhalanges();


}
