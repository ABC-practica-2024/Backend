package ro.ubb.abc2024.biology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ubb.abc2024.biology.domain.Cranial.Cranial;

import java.util.Optional;

@Repository
public interface CranialBoneRepository extends JpaRepository<Cranial, Long> {
    @Query("SELECT c FROM Frontal c WHERE c.id=:id")
    Optional<Cranial> findFrontalById(Long id);

    @Query("SELECT c FROM Parietal c WHERE c.id=:id")
    Optional<Cranial> findParietalById(Long id);

    @Query("SELECT c FROM Occipital c WHERE c.id=:id")
    Optional<Cranial> findOccipitalById(Long id);

    @Query("SELECT c FROM Temporal c WHERE c.id=:id")
    Optional<Cranial> findTemporalById(Long id);

    @Query("SELECT c FROM TMJ c WHERE c.id=:id")
    Optional<Cranial> findTmjById(Long id);

    @Query("SELECT c FROM Mandible c WHERE c.id=:id")
    Optional<Cranial> findMandibleById(Long id);

    @Query("SELECT c FROM Zygomatic c WHERE c.id=:id")
    Optional<Cranial> findZygomaticById(Long id);

    @Query("SELECT c FROM Maxilla c WHERE c.id=:id")
    Optional<Cranial> findMaxillaById(Long id);

    @Query("SELECT c FROM Nasal c WHERE c.id=:id")
    Optional<Cranial> findNasalById(Long id);

    @Query("SELECT c FROM Lacrimal c WHERE c.id=:id")
    Optional<Cranial> findLacrimalById(Long id);

    @Query("SELECT c FROM InferiorNasalConcha c WHERE c.id=:id")
    Optional<Cranial> findInferiorNasalConchaById(Long id);

    @Query("SELECT c FROM Palatine c WHERE c.id=:id")
    Optional<Cranial> findPalatineById(Long id);

    @Query("SELECT c FROM Sphenoid c WHERE c.id=:id")
    Optional<Cranial> findSphenoidById(Long id);

    @Query("SELECT c FROM Ethmoid c WHERE c.id=:id")
    Optional<Cranial> findEthmoidById(Long id);

    @Query("SELECT c FROM Vomer c WHERE c.id=:id")
    Optional<Cranial> findVomerById(Long id);

    @Query("SELECT c FROM Hyoid c WHERE c.id=:id")
    Optional<Cranial> findHyoidById(Long id);

    @Query("SELECT c FROM Thyroid c WHERE c.id=:id")
    Optional<Cranial> findThyroidById(Long id);

    @Query("SELECT c FROM Ossicles c WHERE c.id=:id")
    Optional<Cranial> findOssiclesById(Long id);

    @Query("SELECT c FROM NonmetricTraitsMidElement c WHERE c.id=:id")
    Optional<Cranial> findNonMetricTraitsMidById(Long id);

    @Query("SELECT c FROM NonmetricTraitsSideElement c WHERE c.id=:id")
    Optional<Cranial> findNonMetricTraitsSideById(Long id);

    @Query("SELECT c FROM SutureClosure c WHERE c.id=:id")
    Optional<Cranial> findSutureClosureById(Long id);

    @Query("SELECT c FROM CraniumMeasurements c WHERE c.id=:id")
    Optional<Cranial> findCraniumMeasurementsById(Long id);
}
