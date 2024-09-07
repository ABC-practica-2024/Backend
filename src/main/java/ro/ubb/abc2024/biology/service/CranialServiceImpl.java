package ro.ubb.abc2024.biology.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.biology.domain.Cranial.*;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.dto.Cranial.*;
import ro.ubb.abc2024.biology.mapper.*;
import ro.ubb.abc2024.biology.repository.CranialBoneRepository;

@RequiredArgsConstructor
@Service
public class CranialServiceImpl implements CranialService {

    private final CranialBoneRepository cranialRepository;

    private final CranialBoneMapper cranialBoneMapper;
    private final EthmoidMapper ethmoidMapper;
    private final FrontalMapper frontalMapper;
    private final HyoidMapper hyoidMapper;
    private final InferiorNasalConchaMapper inferiorNasalConchaMapper;
    private final LacrimalMapper lacrimalMapper;
    private final MandibleMapper mandibleMapper;
    private final MaxillaMapper maxillaMapper;
    private final NasalMapper nasalMapper;
    private final NonmetricTraitsMidMapper nonmetricTraitsMidMapper;
    private final NonmetricTraitsSideMapper nonmetricTraitsSideMapper;
    private final OccipitalMapper occipitalMapper;
    private final OssiclesMapper ossiclesMapper;
    private final PalatineMapper palatineMapper;
    private final ParietalMapper parietalMapper;
    private final SphenoidMapper sphenoidMapper;
    private final SutureClosureMapper sutureClosureMapper;
    private final TemporalMapper temporalMapper;
    private final ThyroidMapper thyroidMapper;
    private final TMJMapper tmjMapper;
    private final VomerMapper vomerMapper;
    private final ZygomaticMapper zygomaticMapper;
    private final CraniumMeasurementsMapper craniumMeasurementsMapper;



    @Override
    public Cranial getById(EnumsBio.CranialBoneAndTraits cranialBone, Long id) {
        return switch (cranialBone) {
            case FRONTAL -> cranialRepository.findFrontalById(id).orElseThrow(() ->
                    new EntityNotFoundException("Frontal bone not found with id: " + id));
            case PARIETAL -> cranialRepository.findParietalById(id).orElseThrow(() ->
                    new EntityNotFoundException("Parietal bone not found with id: " + id));
            case OCCIPITAL -> cranialRepository.findOccipitalById(id).orElseThrow(() ->
                    new EntityNotFoundException("Occipital bone not found with id: " + id));
            case TEMPORAL -> cranialRepository.findTemporalById(id).orElseThrow(() ->
                    new EntityNotFoundException("Temporal bone not found with id: " + id));
            case TMJ -> cranialRepository.findTmjById(id).orElseThrow(() ->
                    new EntityNotFoundException("TMJ not found with id: " + id));
            case MANDIBLE -> cranialRepository.findMandibleById(id).orElseThrow(() ->
                    new EntityNotFoundException("Mandible not found with id: " + id));
            case ZYGOMATIC -> cranialRepository.findZygomaticById(id).orElseThrow(() ->
                    new EntityNotFoundException("Zygomatic bone not found with id: " + id));
            case MAXILLA -> cranialRepository.findMaxillaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Maxilla not found with id: " + id));
            case NASAL -> cranialRepository.findNasalById(id).orElseThrow(() ->
                    new EntityNotFoundException("Nasal bone not found with id: " + id));
            case LACRIMAL -> cranialRepository.findLacrimalById(id).orElseThrow(() ->
                    new EntityNotFoundException("Lacrimal bone not found with id: " + id));
            case INFERIOR_NASAL_CONCHA -> cranialRepository.findInferiorNasalConchaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Inferior nasal concha bone not found with id: " + id));
            case PALATINE -> cranialRepository.findPalatineById(id).orElseThrow(() ->
                    new EntityNotFoundException("Palatine bone not found with id: " + id));
            case SPHENOID -> cranialRepository.findSphenoidById(id).orElseThrow(() ->
                    new EntityNotFoundException("Sphenoid bone not found with id: " + id));
            case ETHMOID -> cranialRepository.findEthmoidById(id).orElseThrow(() ->
                    new EntityNotFoundException("Ethmoid bone not found with id: " + id));
            case VOMER -> cranialRepository.findVomerById(id).orElseThrow(() ->
                    new EntityNotFoundException("Vomer bone not found with id: " + id));
            case HYOID -> cranialRepository.findHyoidById(id).orElseThrow(() ->
                    new EntityNotFoundException("Hyoid bone not found with id: " + id));
            case THYROID -> cranialRepository.findThyroidById(id).orElseThrow(() ->
                    new EntityNotFoundException("Thyroid/Crycoid bone not found with id: " + id));
            case OSSICLES -> cranialRepository.findOssiclesById(id).orElseThrow(() ->
                    new EntityNotFoundException("Ossicles not found with id: " + id));
            case NONMETRIC_TRAITS_MID -> cranialRepository.findNonMetricTraitsMidById(id).orElseThrow(() ->
                    new EntityNotFoundException("Nonmetric traits mid not found with id: " + id));
            case NONMETRIC_TRAITS_SIDE -> cranialRepository.findNonMetricTraitsSideById(id).orElseThrow(() ->
                    new EntityNotFoundException("Nonmetric traits side not found with id: " + id));
            case SUTURE_CLOSURE -> cranialRepository.findSutureClosureById(id).orElseThrow(() ->
                    new EntityNotFoundException("Suture closure not found with id: " + id));
            case CRANIUM_MEASUREMENTS -> cranialRepository.findCraniumMeasurementsById(id).orElseThrow(() ->
                    new EntityNotFoundException("Cranium measurements not found with id: " + id));
            default -> throw new IllegalArgumentException("Unknown cranial bone: " + cranialBone);
        };

    }

    @Transactional
    @Override
    public Cranial save(EnumsBio.CranialBoneAndTraits cranialBoneType, Cranial cranialBone) {
        if (cranialBone == null) {
            throw new IllegalArgumentException("The entity to be saved cannot be null.");
        }
        return switch (cranialBoneType) {
            case FRONTAL -> {
                if (!(cranialBone instanceof Frontal frontal)) {
                    throw new IllegalArgumentException("Expected an instance of Frontal for FRONTAL.");
                }
                yield cranialRepository.save(frontal);
            }
            case PARIETAL -> {
                if (!(cranialBone instanceof Parietal parietal)) {
                    throw new IllegalArgumentException("Expected an instance of Parietal for PARIETAL.");
                }
                yield cranialRepository.save(parietal);
            }
            case OCCIPITAL -> {
                if (!(cranialBone instanceof Occipital occipital)) {
                    throw new IllegalArgumentException("Expected an instance of Occipital for OCCIPITAL.");
                }
                yield cranialRepository.save(occipital);
            }
            case TEMPORAL -> {
                if (!(cranialBone instanceof Temporal temporal)) {
                    throw new IllegalArgumentException("Expected an instance of Temporal for TEMPORAL.");
                }
                yield cranialRepository.save(temporal);
            }
            case TMJ -> {
                if (!(cranialBone instanceof TMJ tmj)) {
                    throw new IllegalArgumentException("Expected an instance of TMJ for TMJ.");
                }
                yield cranialRepository.save(tmj);
            }
            case MANDIBLE -> {
                if (!(cranialBone instanceof Mandible mandible)) {
                    throw new IllegalArgumentException("Expected an instance of Mandible for MANDIBLE.");
                }
                yield cranialRepository.save(mandible);
            }
            case ZYGOMATIC -> {
                if (!(cranialBone instanceof Zygomatic zygomatic)) {
                    throw new IllegalArgumentException("Expected an instance of Zygomatic for ZYGOMATIC.");
                }
                yield cranialRepository.save(zygomatic);
            }
            case MAXILLA -> {
                if (!(cranialBone instanceof Maxilla maxilla)) {
                    throw new IllegalArgumentException("Expected an instance of Maxilla for MAXILLA.");
                }
                yield cranialRepository.save(maxilla);
            }
            case NASAL -> {
                if (!(cranialBone instanceof Nasal nasal)) {
                    throw new IllegalArgumentException("Expected an instance of Nasal for NASAL.");
                }
                yield cranialRepository.save(nasal);
            }
            case LACRIMAL -> {
                if (!(cranialBone instanceof Lacrimal lacrimal)) {
                    throw new IllegalArgumentException("Expected an instance of Lacrimal for LACRIMAL.");
                }
                yield cranialRepository.save(lacrimal);
            }
            case INFERIOR_NASAL_CONCHA -> {
                if (!(cranialBone instanceof InferiorNasalConcha inferiorNasalConcha)) {
                    throw new IllegalArgumentException("Expected an instance of InferiorNasalConcha for INFERIOR_NASAL_CONCHA.");
                }
                yield cranialRepository.save(inferiorNasalConcha);
            }
            case PALATINE -> {
                if (!(cranialBone instanceof Palatine palatine)) {
                    throw new IllegalArgumentException("Expected an instance of Palatine for PALATINE.");
                }
                yield cranialRepository.save(palatine);
            }
            case SPHENOID -> {
                if (!(cranialBone instanceof Sphenoid sphenoid)) {
                    throw new IllegalArgumentException("Expected an instance of Sphenoid for SPHENOID.");
                }
                yield cranialRepository.save(sphenoid);
            }
            case ETHMOID -> {
                if (!(cranialBone instanceof Ethmoid ethmoid)) {
                    throw new IllegalArgumentException("Expected an instance of Ethmoid for ETHMOID.");
                }
                yield cranialRepository.save(ethmoid);
            }
            case VOMER -> {
                if (!(cranialBone instanceof Vomer vomer)) {
                    throw new IllegalArgumentException("Expected an instance of Vomer for VOMER.");
                }
                yield cranialRepository.save(vomer);
            }
            case HYOID -> {
                if (!(cranialBone instanceof Hyoid hyoid)) {
                    throw new IllegalArgumentException("Expected an instance of Hyoid for HYOID.");
                }
                yield cranialRepository.save(hyoid);
            }
            case THYROID -> {
                if (!(cranialBone instanceof Thyroid thyroid)) {
                    throw new IllegalArgumentException("Expected an instance of Thyroid for THYROID.");
                }
                yield cranialRepository.save(thyroid);
            }
            case OSSICLES -> {
                if (!(cranialBone instanceof Ossicles ossicles)) {
                    throw new IllegalArgumentException("Expected an instance of Ossicles for OSSICLES.");
                }
                yield cranialRepository.save(ossicles);
            }
            case NONMETRIC_TRAITS_MID -> {
                if (!(cranialBone instanceof NonmetricTraitsMidElement  nonmetricTraitsMidElement)) {
                    throw new IllegalArgumentException("Expected an instance of NonmetricTraitsMidElement for NONMETRIC_TRAITS_MID.");
                }
                yield cranialRepository.save(nonmetricTraitsMidElement);
            }
            case NONMETRIC_TRAITS_SIDE -> {
                if (!(cranialBone instanceof NonmetricTraitsMidElement  nonmetricTraitsSideElement)) {
                    throw new IllegalArgumentException("Expected an instance of NonmetricTraitsMidElement for NONMETRIC_TRAITS_SIDE.");
                }
                yield cranialRepository.save(nonmetricTraitsSideElement);
            }

            case SUTURE_CLOSURE -> {
                if (!(cranialBone instanceof SutureClosure  sutureClosure)) {
                    throw new IllegalArgumentException("Expected an instance of SutureClosure for SUTURE_CLOSURE.");
                }
                yield cranialRepository.save(sutureClosure);
            }
            case CRANIUM_MEASUREMENTS -> {
                if (!(cranialBone instanceof CraniumMeasurements  sutureClosure)) {
                    throw new IllegalArgumentException("Expected an instance of CraniumMeasurements for CRANIUM_MEASUREMENTS.");
                }
                yield cranialRepository.save(sutureClosure);
            }
            default -> throw new IllegalArgumentException("Unknown cranial bone: " + cranialBoneType);

        };

    }



    @Transactional
    @Override
    public Cranial update(EnumsBio.CranialBoneAndTraits cranialBone, CranialDto cranialBoneDto) {
        if (cranialBoneDto == null) {
            throw new IllegalArgumentException("The entity to be updated cannot be null.");
        }
        return switch (cranialBone) {
            case ETHMOID -> {
                EthmoidDto source = (EthmoidDto) cranialBoneDto;
                Ethmoid target = (Ethmoid) cranialRepository.findEthmoidById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Ethmoid not found with id: " + cranialBoneDto.getId()));
                ethmoidMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case FRONTAL -> {
                FrontalDto source = (FrontalDto) cranialBoneDto;
                Frontal target = (Frontal) cranialRepository.findFrontalById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Frontal not found with id: " + cranialBoneDto.getId()));
                frontalMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case HYOID -> {
                HyoidDto source = (HyoidDto) cranialBoneDto;
                Hyoid target = (Hyoid) cranialRepository.findHyoidById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Hyoid not found with id: " + cranialBoneDto.getId()));
                hyoidMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case INFERIOR_NASAL_CONCHA -> {
                InferiorNasalConchaDto source = (InferiorNasalConchaDto) cranialBoneDto;
                InferiorNasalConcha target = (InferiorNasalConcha) cranialRepository.findInferiorNasalConchaById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Inferior Nasal Concha not found with id: " + cranialBoneDto.getId()));
                inferiorNasalConchaMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case LACRIMAL -> {
                LacrimalDto source = (LacrimalDto) cranialBoneDto;
                Lacrimal target = (Lacrimal) cranialRepository.findLacrimalById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Lacrimal not found with id: " + cranialBoneDto.getId()));
                lacrimalMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case MANDIBLE -> {
                MandibleDto source = (MandibleDto) cranialBoneDto;
                Mandible target = (Mandible) cranialRepository.findMandibleById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Mandible not found with id: " + cranialBoneDto.getId()));
                mandibleMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case MAXILLA -> {
                MaxillaDto source = (MaxillaDto) cranialBoneDto;
                Maxilla target = (Maxilla) cranialRepository.findMaxillaById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Maxilla not found with id: " + cranialBoneDto.getId()));
                maxillaMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case NASAL -> {
                NasalDto source = (NasalDto) cranialBoneDto;
                Nasal target = (Nasal) cranialRepository.findNasalById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Nasal not found with id: " + cranialBoneDto.getId()));
                nasalMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case OCCIPITAL -> {
                OccipitalDto source = (OccipitalDto) cranialBoneDto;
                Occipital target = (Occipital) cranialRepository.findOccipitalById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Occipital not found with id: " + cranialBoneDto.getId()));
                occipitalMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case OSSICLES -> {
                OssiclesDto source = (OssiclesDto) cranialBoneDto;
                Ossicles target = (Ossicles) cranialRepository.findOssiclesById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Ossicles not found with id: " + cranialBoneDto.getId()));
                ossiclesMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case PALATINE -> {
                PalatineDto source = (PalatineDto) cranialBoneDto;
                Palatine target = (Palatine) cranialRepository.findPalatineById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Palatine not found with id: " + cranialBoneDto.getId()));
                palatineMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case PARIETAL -> {
                ParietalDto source = (ParietalDto) cranialBoneDto;
                Parietal target = (Parietal) cranialRepository.findParietalById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Parietal not found with id: " + cranialBoneDto.getId()));
                parietalMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case SPHENOID -> {
                SphenoidDto source = (SphenoidDto) cranialBoneDto;
                Sphenoid target = (Sphenoid) cranialRepository.findSphenoidById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Sphenoid not found with id: " + cranialBoneDto.getId()));
                sphenoidMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case TEMPORAL -> {
                TemporalDto source = (TemporalDto) cranialBoneDto;
                Temporal target = (Temporal) cranialRepository.findTemporalById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Temporal not found with id: " + cranialBoneDto.getId()));
                temporalMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case THYROID -> {
                ThyroidDto source = (ThyroidDto) cranialBoneDto;
                Thyroid target = (Thyroid) cranialRepository.findThyroidById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Thyroid not found with id: " + cranialBoneDto.getId()));
                thyroidMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case TMJ -> {
                TMJDto source = (TMJDto) cranialBoneDto;
                TMJ target = (TMJ) cranialRepository.findTmjById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("TMJ not found with id: " + cranialBoneDto.getId()));
                tmjMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case VOMER -> {
                VomerDto source = (VomerDto) cranialBoneDto;
                Vomer target = (Vomer) cranialRepository.findVomerById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Vomer not found with id: " + cranialBoneDto.getId()));
                vomerMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case ZYGOMATIC -> {
                ZygomaticDto source = (ZygomaticDto) cranialBoneDto;
                Zygomatic target = (Zygomatic) cranialRepository.findZygomaticById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("Zygomatic not found with id: " + cranialBoneDto.getId()));
                zygomaticMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case NONMETRIC_TRAITS_MID -> {
                NonmetricTraitsMidElementDto source = (NonmetricTraitsMidElementDto) cranialBoneDto;
                NonmetricTraitsMidElement target = (NonmetricTraitsMidElement) cranialRepository.findNonMetricTraitsMidById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("NonMetric Traits Mid not found with id: " + cranialBoneDto.getId()));
                nonmetricTraitsMidMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case NONMETRIC_TRAITS_SIDE -> {
                NonmetricTraitsSideElementDto source = (NonmetricTraitsSideElementDto) cranialBoneDto;
                NonmetricTraitsSideElement target = (NonmetricTraitsSideElement) cranialRepository.findNonMetricTraitsSideById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("NonMetric Traits Mid not found with id: " + cranialBoneDto.getId()));
                nonmetricTraitsSideMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case SUTURE_CLOSURE -> {
                SutureClosureDto source = (SutureClosureDto) cranialBoneDto;
                SutureClosure target = (SutureClosure) cranialRepository.findSutureClosureById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("NonMetric Traits Mid not found with id: " + cranialBoneDto.getId()));
                sutureClosureMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            case CRANIUM_MEASUREMENTS -> {
                CraniumMeasurementsDto source = (CraniumMeasurementsDto) cranialBoneDto;
                CraniumMeasurements target = (CraniumMeasurements) cranialRepository.findSutureClosureById(cranialBoneDto.getId()).orElseThrow(() ->
                        new EntityNotFoundException("NonMetric Traits Mid not found with id: " + cranialBoneDto.getId()));
                craniumMeasurementsMapper.updateEntityFromDto(source, target);
                yield cranialRepository.save(target);
            }
            default -> throw new IllegalArgumentException("Unknown cranial bone: " + cranialBone);

        };
    }


    @Override
    public void deleteById(EnumsBio.CranialBoneAndTraits cranialBone, Long id) {
        switch (cranialBone) {
            case ETHMOID -> cranialRepository.delete(cranialRepository.findEthmoidById(id).orElseThrow(() ->
                    new EntityNotFoundException("Ethmoid not found with id: " + id)));
            case FRONTAL -> cranialRepository.delete(cranialRepository.findFrontalById(id).orElseThrow(() ->
                    new EntityNotFoundException("Frontal not found with id: " + id)));
            case HYOID -> cranialRepository.delete(cranialRepository.findHyoidById(id).orElseThrow(() ->
                    new EntityNotFoundException("Hyoid not found with id: " + id)));
            case INFERIOR_NASAL_CONCHA -> cranialRepository.delete(cranialRepository.findInferiorNasalConchaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Inferior Nasal Concha not found with id: " + id)));
            case LACRIMAL -> cranialRepository.delete(cranialRepository.findLacrimalById(id).orElseThrow(() ->
                    new EntityNotFoundException("Lacrimal not found with id: " + id)));
            case MANDIBLE -> cranialRepository.delete(cranialRepository.findMandibleById(id).orElseThrow(() ->
                    new EntityNotFoundException("Mandible not found with id: " + id)));
            case MAXILLA -> cranialRepository.delete(cranialRepository.findMaxillaById(id).orElseThrow(() ->
                    new EntityNotFoundException("Maxilla not found with id: " + id)));
            case NASAL -> cranialRepository.delete(cranialRepository.findNasalById(id).orElseThrow(() ->
                    new EntityNotFoundException("Nasal not found with id: " + id)));
            case OCCIPITAL -> cranialRepository.delete(cranialRepository.findOccipitalById(id).orElseThrow(() ->
                    new EntityNotFoundException("Occipital not found with id: " + id)));
            case OSSICLES -> cranialRepository.delete(cranialRepository.findOssiclesById(id).orElseThrow(() ->
                    new EntityNotFoundException("Ossicles not found with id: " + id)));
            case PALATINE -> cranialRepository.delete(cranialRepository.findPalatineById(id).orElseThrow(() ->
                    new EntityNotFoundException("Palatine not found with id: " + id)));
            case PARIETAL -> cranialRepository.delete(cranialRepository.findParietalById(id).orElseThrow(() ->
                    new EntityNotFoundException("Parietal not found with id: " + id)));
            case SPHENOID -> cranialRepository.delete(cranialRepository.findSphenoidById(id).orElseThrow(() ->
                    new EntityNotFoundException("Sphenoid not found with id: " + id)));
            case TEMPORAL -> cranialRepository.delete(cranialRepository.findTemporalById(id).orElseThrow(() ->
                    new EntityNotFoundException("Temporal not found with id: " + id)));
            case THYROID -> cranialRepository.delete(cranialRepository.findThyroidById(id).orElseThrow(() ->
                    new EntityNotFoundException("Thyroid not found with id: " + id)));
            case TMJ -> cranialRepository.delete(cranialRepository.findTmjById(id).orElseThrow(() ->
                    new EntityNotFoundException("TMJ not found with id: " + id)));
            case VOMER -> cranialRepository.delete(cranialRepository.findVomerById(id).orElseThrow(() ->
                    new EntityNotFoundException("Vomer not found with id: " + id)));
            case NONMETRIC_TRAITS_MID -> cranialRepository.delete(cranialRepository.findNonMetricTraitsMidById(id).orElseThrow(() ->
                    new EntityNotFoundException("Nonmetric traits mid not found with id: " + id)));
            case NONMETRIC_TRAITS_SIDE -> cranialRepository.delete(cranialRepository.findNonMetricTraitsSideById(id).orElseThrow(() ->
                    new EntityNotFoundException("Nonmetric traits side not found with id: " + id)));
            case SUTURE_CLOSURE -> cranialRepository.delete(cranialRepository.findSutureClosureById(id).orElseThrow(() ->
                    new EntityNotFoundException("Suture closure not found with id: " + id)));
            case CRANIUM_MEASUREMENTS -> cranialRepository.delete(cranialRepository.findCraniumMeasurementsById(id).orElseThrow(() ->
                    new EntityNotFoundException("Suture closure not found with id: " + id)));
        }
    }

}
