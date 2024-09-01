package ro.ubb.abc2024.biology.repository.appendicular;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ubb.abc2024.biology.domain.appendicular.*;

import java.util.Optional;

@Repository
public interface AppendRepository extends JpaRepository<Append, Long> {

    //    -----------------------------------------Clavicle---------------------------------------------------
    @Query(value = "select c from Clavicle c where c.id=:id")
    Optional<Clavicle> getClavicleById(Long id);

    //    -----------------------------------------Femur---------------------------------------------------
    @Query(value = "select c from Femur c where c.id=:id")
    Optional<Femur> getFemurById(Long id);

    //    -----------------------------------------Fibula---------------------------------------------------
    @Query(value = "select c from Fibula c where c.id=:id")
    Optional<Fibula> getFibulaById(Long id);

    //    -----------------------------------------Humerus---------------------------------------------------
    @Query(value = "select c from Humerus c where c.id=:id")
    Optional<Humerus> getHumerusById(Long id);

    //    -----------------------------------------Ilium---------------------------------------------------
    @Query(value = "select c from Ilium c where c.id=:id")
    Optional<Ilium> getIliumById(Long id);

    //    -----------------------------------------InnominateOsCoxaHipBone---------------------------------------------------
    @Query(value = "select c from InnominateOsCoxaHipBone c where c.id=:id")
    Optional<InnominateOsCoxaHipBone> getInnominateOsCoxaHipBoneById(Long id);

    //    -----------------------------------------Ischium---------------------------------------------------
    @Query(value = "select c from Ischium c where c.id=:id")
    Optional<Ischium> getIschiumById(Long id);

    //    -----------------------------------------Patella---------------------------------------------------
    @Query(value = "select c from Patella c where c.id=:id")
    Optional<Patella> getPatellaById(Long id);

    //    -----------------------------------------Pubis---------------------------------------------------
    @Query(value = "select c from Pubis c where c.id=:id")
    Optional<Pubis> getPubisById(Long id);

    //    -----------------------------------------Radius---------------------------------------------------
    @Query(value = "select c from Radius c where c.id=:id")
    Optional<Radius> getRadiusById(Long id);

    //    -----------------------------------------Scapula---------------------------------------------------
    @Query(value = "select c from Scapula c where c.id=:id")
    Optional<Scapula> getScapulaById(Long id);

    //    -----------------------------------------Tibia---------------------------------------------------
    @Query(value = "select c from Tibia c where c.id=:id")
    Optional<Tibia> getTibiaById(Long id);

    //    -----------------------------------------Ulna---------------------------------------------------
    @Query(value = "select c from Ulna c where c.id=:id")
    Optional<Ulna> getUlnaById(Long id);

}
