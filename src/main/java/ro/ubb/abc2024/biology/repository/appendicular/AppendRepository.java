package ro.ubb.abc2024.biology.repository.appendicular;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.ubb.abc2024.biology.domain.appendicular.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppendRepository extends JpaRepository<Append, Long> {

    //    -----------------------------------------Clavicle---------------------------------------------------
    @Query(value = "select c from Clavicle c where c.id=:id")
    Optional<Clavicle> getClavicleById(Long id);

    @Query("SELECT c FROM Clavicle c WHERE c.artefactId = :artefactId")
    List<Clavicle> findAllClavicleByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Femur---------------------------------------------------
    @Query(value = "select c from Femur c where c.id=:id")
    Optional<Femur> getFemurById(Long id);

    @Query("SELECT c FROM Femur c WHERE c.artefactId = :artefactId")
    List<Femur> findAllFemurByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Fibula---------------------------------------------------
    @Query(value = "select c from Fibula c where c.id=:id")
    Optional<Fibula> getFibulaById(Long id);

    @Query("SELECT c FROM Fibula c WHERE c.artefactId = :artefactId")
    List<Fibula> findAllFibulaByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Humerus---------------------------------------------------
    @Query(value = "select c from Humerus c where c.id=:id")
    Optional<Humerus> getHumerusById(Long id);

    @Query("SELECT c FROM Humerus c WHERE c.artefactId = :artefactId")
    List<Humerus> findAllHumerusByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Ilium---------------------------------------------------
    @Query(value = "select c from Ilium c where c.id=:id")
    Optional<Ilium> getIliumById(Long id);

    @Query("SELECT c FROM Ilium c WHERE c.artefactId = :artefactId")
    List<Ilium> findAllIliumByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------InnominateOsCoxaHipBone---------------------------------------------------
    @Query(value = "select c from InnominateOsCoxaHipBone c where c.id=:id")
    Optional<InnominateOsCoxaHipBone> getInnominateOsCoxaHipBoneById(Long id);

    @Query("SELECT c FROM InnominateOsCoxaHipBone c WHERE c.artefactId = :artefactId")
    List<InnominateOsCoxaHipBone> findAllInnominateOsCoxaHipBoneByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Ischium---------------------------------------------------
    @Query(value = "select c from Ischium c where c.id=:id")
    Optional<Ischium> getIschiumById(Long id);

    @Query("SELECT c FROM Ischium c WHERE c.artefactId = :artefactId")
    List<Ischium> findAllIschiumByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Patella---------------------------------------------------
    @Query(value = "select c from Patella c where c.id=:id")
    Optional<Patella> getPatellaById(Long id);

    @Query("SELECT c FROM Patella c WHERE c.artefactId = :artefactId")
    List<Patella> findAllPatellaByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Pubis---------------------------------------------------
    @Query(value = "select c from Pubis c where c.id=:id")
    Optional<Pubis> getPubisById(Long id);

    @Query("SELECT c FROM Pubis c WHERE c.artefactId = :artefactId")
    List<Pubis> findAllPubisByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Radius---------------------------------------------------
    @Query(value = "select c from Radius c where c.id=:id")
    Optional<Radius> getRadiusById(Long id);

    @Query("SELECT c FROM Radius c WHERE c.artefactId = :artefactId")
    List<Radius> findAllRadiusByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Scapula---------------------------------------------------
    @Query(value = "select c from Scapula c where c.id=:id")
    Optional<Scapula> getScapulaById(Long id);

    @Query("SELECT c FROM Scapula c WHERE c.artefactId = :artefactId")
    List<Scapula> findAllScapulaByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Tibia---------------------------------------------------
    @Query(value = "select c from Tibia c where c.id=:id")
    Optional<Tibia> getTibiaById(Long id);

    @Query("SELECT c FROM Tibia c WHERE c.artefactId = :artefactId")
    List<Tibia> findAllTibiaByArtefactId(@Param("artefactId") UUID artefactId);

    //    -----------------------------------------Ulna---------------------------------------------------
    @Query(value = "select c from Ulna c where c.id=:id")
    Optional<Ulna> getUlnaById(Long id);

    @Query("SELECT c FROM Ulna c WHERE c.artefactId = :artefactId")
    List<Ulna> findAllUlnaByArtefactId(@Param("artefactId") UUID artefactId);

}
