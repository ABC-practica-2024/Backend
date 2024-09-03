package ro.ubb.abc2024.biology.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.Cranial.*;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.dto.Cranial.*;
import ro.ubb.abc2024.biology.mapper.*;
import ro.ubb.abc2024.biology.service.CranialService;
import ro.ubb.abc2024.utils.dto.Result;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/cranial")
public class CranialController {

    private final CranialService cranialService;
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
    private final StureClosureMapper stureClosureMapper;
    private final TemporalMapper temporalMapper;
    private final ThyroidMapper thyroidMapper;
    private final TMJMapper tmjMapper;
    private final VomerMapper vomerMapper;
    private final ZygomaticMapper zygomaticMapper;

    @GetMapping("/{cranialBoneType}/{id}")
    public Result<CranialDto> getById(@PathVariable EnumsBio.CranialBoneType cranialBoneType, @PathVariable Long id) {
        Cranial cranial = cranialService.getById(cranialBoneType, id);
        if (cranial == null) {
            throw new EntityNotFoundException(String.format("Entity with ID %d not found", id));
        }
        CranialDto dto = mapToDto(cranialBoneType, cranial);
        return new Result<>(true, HttpStatus.OK.value(), "Entity retrieved successfully", dto);
    }

    @PostMapping("/{cranialBoneType}")
    public Result<CranialDto> save(@PathVariable EnumsBio.CranialBoneType cranialBoneType, @RequestBody CranialDto cranialDto) {
        try {
            Cranial cranialEntity = mapToEntity(cranialBoneType, cranialDto);
            Cranial savedCranial = cranialService.save(cranialBoneType, cranialEntity);
            CranialDto responseDto = mapToDto(cranialBoneType, savedCranial);
            return new Result<>(true, HttpStatus.CREATED.value(), "Entity created successfully", responseDto);
        } catch (IllegalArgumentException e) {
            return new Result<>(false, HttpStatus.BAD_REQUEST.value(), e.getMessage(), null);
        } catch (Exception e) {
            return new Result<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred", null);
        }
    }

    @PutMapping("/{cranialBoneType}")
    public Result<CranialDto> update(@PathVariable EnumsBio.CranialBoneType cranialBoneType, @RequestBody CranialDto cranialDto) {
        Cranial entity = cranialService.update(cranialBoneType, cranialDto);
        if (entity == null) {
            throw new EntityNotFoundException(String.format("Entity with ID %d not found", cranialDto.getId()));
        }
        CranialDto responseDto = mapToDto(cranialBoneType, entity);
        return new Result<>(true, HttpStatus.OK.value(), "Entity updated successfully", responseDto);
    }

    @DeleteMapping("/{cranialBoneType}/{id}")
    public Result<Void> deleteById(@PathVariable EnumsBio.CranialBoneType cranialBoneType, @PathVariable Long id) {
        Cranial entity = cranialService.getById(cranialBoneType, id);
        if (entity == null) {
            throw new EntityNotFoundException(String.format("Entity with ID %d not found", id));
        }
        cranialService.deleteById(cranialBoneType, id);
        return new Result<>(true, HttpStatus.NO_CONTENT.value(), "Entity deleted successfully", null);
    }

    private Cranial mapToEntity(EnumsBio.CranialBoneType cranialBoneType, CranialDto cranialDto) {
        return switch (cranialBoneType) {
            case ETHMOID -> {
                if (!(cranialDto instanceof EthmoidDto ethmoidDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for ETHMOID");
                }
                yield ethmoidMapper.toEntity(ethmoidDto);
            }
            case FRONTAL -> {
                if (!(cranialDto instanceof FrontalDto frontalDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for FRONTAL");
                }
                yield frontalMapper.toEntity(frontalDto);
            }
            case HYOID -> {
                if (!(cranialDto instanceof HyoidDto hyoidDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for HYOID");
                }
                yield hyoidMapper.toEntity(hyoidDto);
            }
            case INFERIOR_NASAL_CONCHA -> {
                if (!(cranialDto instanceof InferiorNasalConchaDto inferiorNasalConchaDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for INFERIOR NASAL CONCHA");
                }
                yield inferiorNasalConchaMapper.toEntity(inferiorNasalConchaDto);
            }
            case LACRIMAL -> {
                if (!(cranialDto instanceof LacrimalDto lacrimalDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for LACRIMAL");
                }
                yield lacrimalMapper.toEntity(lacrimalDto);
            }
            case MANDIBLE -> {
                if (!(cranialDto instanceof MandibleDto mandibleDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for MANDIBLE");
                }
                yield mandibleMapper.toEntity(mandibleDto);
            }
            case MAXILLA -> {
                if (!(cranialDto instanceof MaxillaDto maxillaDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for MAXILLA");
                }
                yield maxillaMapper.toEntity(maxillaDto);
            }
            case NASAL -> {
                if (!(cranialDto instanceof NasalDto nasalDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for NASAL");
                }
                yield nasalMapper.toEntity(nasalDto);
            }
            case OCCIPITAL -> {
                if (!(cranialDto instanceof OccipitalDto occipitalDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for OCCIPITAL");
                }
                yield occipitalMapper.toEntity(occipitalDto);
            }
            case OSSICLES -> {
                if (!(cranialDto instanceof OssiclesDto ossiclesDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for OSSICLES");
                }
                yield ossiclesMapper.toEntity(ossiclesDto);
            }
            case PALATINE -> {
                if (!(cranialDto instanceof PalatineDto palatineDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for PALATINE");
                }
                yield palatineMapper.toEntity(palatineDto);
            }
            case PARIETAL -> {
                if (!(cranialDto instanceof ParietalDto parietalDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for PARIETAL");
                }
                yield parietalMapper.toEntity(parietalDto);
            }
            case SPHENOID -> {
                if (!(cranialDto instanceof SphenoidDto sphenoidDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for SPHENOID");
                }
                yield sphenoidMapper.toEntity(sphenoidDto);
            }
            case TEMPORAL -> {
                if (!(cranialDto instanceof TemporalDto temporalDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for TEMPORAL");
                }
                yield temporalMapper.toEntity(temporalDto);
            }
            case THYROID -> {
                if (!(cranialDto instanceof ThyroidDto thyroidDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for THYROID");
                }
                yield thyroidMapper.toEntity(thyroidDto);
            }
            case TMJ -> {
                if (!(cranialDto instanceof TMJDto tmjDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for TMJ");
                }
                yield tmjMapper.toEntity(tmjDto);
            }
            case VOMER -> {
                if (!(cranialDto instanceof VomerDto vomerDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for VOMER");
                }
                yield vomerMapper.toEntity(vomerDto);
            }
            case ZYGOMATIC -> {
                if (!(cranialDto instanceof ZygomaticDto zygomaticDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for ZYGOMATIC");
                }
                yield zygomaticMapper.toEntity(zygomaticDto);
            }
        };
    }


    private CranialDto mapToDto(EnumsBio.CranialBoneType cranialBoneType, Cranial cranial) {
        return switch (cranialBoneType) {
            case ETHMOID -> {
                if (!(cranial instanceof Ethmoid ethmoid)) {
                    throw new IllegalArgumentException("Invalid entity type for ETHMOID");
                }
                yield ethmoidMapper.toDto(ethmoid);
            }
            case FRONTAL -> {
                if (!(cranial instanceof Frontal frontal)) {
                    throw new IllegalArgumentException("Invalid entity type for FRONTAL");
                }
                yield frontalMapper.toDto(frontal);
            }
            case HYOID -> {
                if (!(cranial instanceof Hyoid hyoid)) {
                    throw new IllegalArgumentException("Invalid entity type for HYOID");
                }
                yield hyoidMapper.toDto(hyoid);
            }
            case INFERIOR_NASAL_CONCHA -> {
                if (!(cranial instanceof InferiorNasalConcha inferiorNasalConcha)) {
                    throw new IllegalArgumentException("Invalid entity type for INFERIOR_NASAL_CONCHA");
                }
                yield inferiorNasalConchaMapper.toDto(inferiorNasalConcha);
            }
            case LACRIMAL -> {
                if (!(cranial instanceof Lacrimal lacrimal)) {
                    throw new IllegalArgumentException("Invalid entity type for LACRIMAL");
                }
                yield lacrimalMapper.toDto(lacrimal);
            }
            case MANDIBLE -> {
                if (!(cranial instanceof Mandible mandible)) {
                    throw new IllegalArgumentException("Invalid entity type for MANDIBLE");
                }
                yield mandibleMapper.toDto(mandible);
            }
            case MAXILLA -> {
                if (!(cranial instanceof Maxilla maxilla)) {
                    throw new IllegalArgumentException("Invalid entity type for MAXILLA");
                }
                yield maxillaMapper.toDto(maxilla);
            }
            case NASAL -> {
                if (!(cranial instanceof Nasal nasal)) {
                    throw new IllegalArgumentException("Invalid entity type for NASAL");
                }
                yield nasalMapper.toDto(nasal);
            }
            case OCCIPITAL -> {
                if (!(cranial instanceof Occipital occipital)) {
                    throw new IllegalArgumentException("Invalid entity type for OCCIPITAL");
                }
                yield occipitalMapper.toDto(occipital);
            }
            case OSSICLES -> {
                if (!(cranial instanceof Ossicles ossicles)) {
                    throw new IllegalArgumentException("Invalid entity type for OSSICLES");
                }
                yield ossiclesMapper.toDto(ossicles);
            }
            case PALATINE -> {
                if (!(cranial instanceof Palatine palatine)) {
                    throw new IllegalArgumentException("Invalid entity type for PALATINE");
                }
                yield palatineMapper.toDto(palatine);
            }
            case PARIETAL -> {
                if (!(cranial instanceof Parietal parietal)) {
                    throw new IllegalArgumentException("Invalid entity type for PARIETAL");
                }
                yield parietalMapper.toDto(parietal);
            }
            case SPHENOID -> {
                if (!(cranial instanceof Sphenoid sphenoid)) {
                    throw new IllegalArgumentException("Invalid entity type for SPHENOID");
                }
                yield sphenoidMapper.toDto(sphenoid);
            }
            case TEMPORAL -> {
                if (!(cranial instanceof Temporal temporal)) {
                    throw new IllegalArgumentException("Invalid entity type for TEMPORAL");
                }
                yield temporalMapper.toDto(temporal);
            }
            case THYROID -> {
                if (!(cranial instanceof Thyroid thyroid)) {
                    throw new IllegalArgumentException("Invalid entity type for THYROID");
                }
                yield thyroidMapper.toDto(thyroid);
            }
            case TMJ -> {
                if (!(cranial instanceof TMJ tmj)) {
                    throw new IllegalArgumentException("Invalid entity type for TMJ");
                }
                yield tmjMapper.toDto(tmj);
            }
            case VOMER -> {
                if (!(cranial instanceof Vomer vomer)) {
                    throw new IllegalArgumentException("Invalid entity type for VOMER");
                }
                yield vomerMapper.toDto(vomer);
            }
            case ZYGOMATIC -> {
                if (!(cranial instanceof Zygomatic zygomatic)) {
                    throw new IllegalArgumentException("Invalid entity type for ZYGOMATIC");
                }
                yield zygomaticMapper.toDto(zygomatic);
            }
        };
    }

}
