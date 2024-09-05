package ro.ubb.abc2024.biology.service.Extremities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.Extremities.*;

import java.util.Collections;
import java.util.List;

import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.repository.Extremities.ExtremityRepository;


@Service
public class ExtremityServiceImpl implements ExtremityService {
    @Autowired
    private ExtremityRepository extremityRepository;



    public Extremity save(Extremity extremity){
        return switch (extremity) {
            case Calcaneus calcaneus -> extremityRepository.save(calcaneus);
            case Carpals carpals ->  extremityRepository.save(carpals);
            case Metacarpals metacarpals -> extremityRepository.save(metacarpals);
            case Metatarsals metatarsals -> extremityRepository.save(metatarsals);
            case OtherTarsals otherTarsals -> extremityRepository.save(otherTarsals);
            case Phalanges phalanges -> extremityRepository.save(phalanges);
            default -> throw new IllegalStateException("Unexpected value: " + extremity);
        };
    }


    public List<Extremity> getAll(EnumsBio.ExtremityBone extremityBone) {
        return Collections.unmodifiableList(switch (extremityBone) {
            case CALCANEUS -> extremityRepository.getAllCalcaneus();
            case SCAPHOID, LUNATE, TRIQUETRUM,
                    PISIFORM, HAMATE, CAPITATE,
                    TRAPEZIUM, TRAPEZOID  -> extremityRepository.getAllCarpals();
            case METACARPALS, UPPER_SESAMOIDS -> extremityRepository.getAllMetacarpals();

            case METATARSALS, LOWER_SESAMOIDS -> extremityRepository.getAllMetatarsals();

            case MEDIAL_CUNEIFORM, INTERMEDIATE_CUNEIFORM,
                    LATERAL_CUNEIFORM, CUBOID,
                    NAVICULAR, TALUS -> extremityRepository.getAllOtherTarsals();

            case UPPER_PROXIMAL_PHALANGES, LOWER_PROXIMAL_PHALANGES,
                    UPPER_MIDDLE_PHALANGES, LOWER_MIDDLE_PHALANGES,
                    UPPER_DISTAL_PHALANGES, LOWER_DISTAL_PHALANGES -> extremityRepository.getAllPhalanges();
            default -> throw new IllegalStateException("Unexpected value: " + extremityBone);
        });
    }
    public Extremity getById(EnumsBio.ExtremityBone extremityBone, long id) {
        return switch (extremityBone) {
            case CALCANEUS -> extremityRepository.getCalcaneusById(id)
                    .orElseThrow(() -> new RuntimeException("Calcaneus not found with id: " + id));
            case SCAPHOID, LUNATE, TRIQUETRUM,
                    PISIFORM, HAMATE, CAPITATE,
                    TRAPEZIUM, TRAPEZOID -> extremityRepository.getCarpalsById(id)
                    .orElseThrow(() -> new RuntimeException("Carpals not found with id: " + id));
            case METACARPALS, UPPER_SESAMOIDS -> extremityRepository.getMetacarpalsById(id)
                    .orElseThrow(() -> new RuntimeException("Metacarpals not found with id: " + id));
            case METATARSALS, LOWER_SESAMOIDS -> extremityRepository.getMetatarsalsById(id)
                    .orElseThrow(() -> new RuntimeException("Metatarsals not found with id: " + id));
            case MEDIAL_CUNEIFORM, INTERMEDIATE_CUNEIFORM,
                    LATERAL_CUNEIFORM, CUBOID,
                    NAVICULAR, TALUS -> extremityRepository.getOtherTarsalsById(id)
                    .orElseThrow(() -> new RuntimeException("Other Tarsals not found with id: " + id));
            case UPPER_PROXIMAL_PHALANGES, LOWER_PROXIMAL_PHALANGES,
                    UPPER_MIDDLE_PHALANGES, LOWER_MIDDLE_PHALANGES,
                    UPPER_DISTAL_PHALANGES, LOWER_DISTAL_PHALANGES -> extremityRepository.getPhalangesById(id)
                    .orElseThrow(() -> new RuntimeException("Phalanges not found with id: " + id));
            default -> throw new IllegalStateException("Unexpected value: " + extremityBone);
        };
    }


    public Extremity update(EnumsBio.ExtremityBone extremityBone, Extremity extremity){
        return switch (extremityBone){
            case CALCANEUS -> {
                var calcaneus = (Calcaneus)getById(EnumsBio.ExtremityBone.CALCANEUS, extremity.getId());
                var updatedCalcaneus = (Calcaneus) extremity;
                calcaneus.setMaxLength(updatedCalcaneus.getMaxLength());
                calcaneus.setMiddleBreadth(updatedCalcaneus.getMiddleBreadth());
                calcaneus.setStagesOfDJD(updatedCalcaneus.getStagesOfDJD());
                yield this.extremityRepository.save(calcaneus);
            }
            case SCAPHOID, LUNATE, TRIQUETRUM, PISIFORM, HAMATE, CAPITATE, TRAPEZIUM, TRAPEZOID -> {
                var carpals = (Carpals) getById(extremityBone, extremity.getId());
                var updatedCarpals = (Carpals) extremity;
                carpals.setStagesOfDJD(updatedCarpals.getStagesOfDJD());
                yield this.extremityRepository.save(carpals);
            }
            case METACARPALS, UPPER_SESAMOIDS -> {
                var metacarpals = (Metacarpals) getById(extremityBone, extremity.getId());
                var updatedMetacarpals = (Metacarpals) extremity;
                metacarpals.setProximalJuvenileStageOfUnion(updatedMetacarpals.getProximalJuvenileStageOfUnion());
                metacarpals.setDistalJuvenileStageOfUnion(updatedMetacarpals.getDistalJuvenileStageOfUnion());
                metacarpals.setStagesOfDJD(updatedMetacarpals.getStagesOfDJD());
                yield this.extremityRepository.save(metacarpals);
            }
            case METATARSALS, LOWER_SESAMOIDS -> {
                var metatarsals = (Metacarpals) getById(extremityBone, extremity.getId());
                var updatedMetatarsals = (Metatarsals) extremity;
                metatarsals.setProximalJuvenileStageOfUnion(updatedMetatarsals.getProximalJuvenileStageOfUnion());
                metatarsals.setDistalJuvenileStageOfUnion(updatedMetatarsals.getDistalJuvenileStageOfUnion());
                metatarsals.setStagesOfDJD(updatedMetatarsals.getStagesOfDJD());
                yield this.extremityRepository.save(metatarsals);
            }
            case MEDIAL_CUNEIFORM, INTERMEDIATE_CUNEIFORM, LATERAL_CUNEIFORM, CUBOID, NAVICULAR, TALUS ->  {
                var otherTarsals = (OtherTarsals) getById(extremityBone, extremity.getId());
                var updatedOtherTarsals = (OtherTarsals) extremity;
                otherTarsals.setStagesOfDJD(updatedOtherTarsals.getStagesOfDJD());
                yield this.extremityRepository.save(otherTarsals);
            }
            case UPPER_PROXIMAL_PHALANGES, LOWER_PROXIMAL_PHALANGES, UPPER_MIDDLE_PHALANGES,
                    LOWER_MIDDLE_PHALANGES, UPPER_DISTAL_PHALANGES, LOWER_DISTAL_PHALANGES -> {
                var phalanges = (Phalanges) getById(extremityBone, extremity.getId());
                var updatedPhalanges = (Phalanges) extremity;
                phalanges.setProximalJuvenile(updatedPhalanges.getProximalJuvenile());
                phalanges.setHandOrFoot(updatedPhalanges.getHandOrFoot());
                phalanges.setPosition(updatedPhalanges.getPosition());
                phalanges.setStagesOfDJD(updatedPhalanges.getStagesOfDJD());
                yield this.extremityRepository.save(phalanges);
            }
            default -> throw new IllegalStateException("Unexpected value: " + extremityBone);
        };
    }

    public void deleteById(EnumsBio.ExtremityBone extremityBone, long id){
        switch (extremityBone){
            case CALCANEUS -> extremityRepository.delete(
                    extremityRepository.getCalcaneusById(id).orElseThrow(
                            ()->new ResourceNotFoundException("Calcaneus with ID = " + id + " not found")
                    )
            );
            case SCAPHOID, LUNATE, TRIQUETRUM,
                    PISIFORM, HAMATE, CAPITATE,
                    TRAPEZIUM, TRAPEZOID  -> extremityRepository.delete(
                    extremityRepository.getCarpalsById(id).orElseThrow(
                            ()->new ResourceNotFoundException("Carpals with ID = " + id + " not found")
                    )
            );
            case METACARPALS, UPPER_SESAMOIDS -> extremityRepository.delete(
                    extremityRepository.getMetacarpalsById(id).orElseThrow(
                            ()->new ResourceNotFoundException("Metacarpals with ID = " + id + " not found")
                    )
            );
            case METATARSALS, LOWER_SESAMOIDS -> extremityRepository.delete(
                    extremityRepository.getMetatarsalsById(id).orElseThrow(
                            ()->new ResourceNotFoundException("Metatarsals with ID = " + id + " not found")
                    )
            );
            case MEDIAL_CUNEIFORM, INTERMEDIATE_CUNEIFORM,
                    LATERAL_CUNEIFORM, CUBOID,
                    NAVICULAR, TALUS -> extremityRepository.delete(
                    extremityRepository.getOtherTarsalsById(id).orElseThrow(
                            ()->new ResourceNotFoundException("OtherTarsals with ID = " + id + " not found")
                    )
            );

            case UPPER_PROXIMAL_PHALANGES, LOWER_PROXIMAL_PHALANGES,
                    UPPER_MIDDLE_PHALANGES, LOWER_MIDDLE_PHALANGES,
                    UPPER_DISTAL_PHALANGES, LOWER_DISTAL_PHALANGES -> extremityRepository.delete(
                    extremityRepository.getPhalangesById(id).orElseThrow(
                            ()->new ResourceNotFoundException("Phalanges with ID = " + id + " not found")
                    )
            );
            default -> throw new IllegalStateException("Unexpected value: " + extremityBone);
        };
    }
}
