package ro.ubb.abc2024.biology.controller.appendicular;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.appendicular.*;
import ro.ubb.abc2024.biology.dto.appendicular.*;
import ro.ubb.abc2024.biology.mapper.append.*;
import ro.ubb.abc2024.biology.service.appendicular.AppendService;
import ro.ubb.abc2024.utils.dto.Result;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/appendicular")
public class AppendController {

    private final AppendService appendService;
    private final ClavicleMapper clavicleMapper;
    private final FemurMapper femurMapper;
    private final FibulaMapper fibulaMapper;
    private final HumerusMapper humerusMapper;
    private final IliumMapper iliumMapper;
    private final InnominateOsCoxaHipBoneMapper innominateOsCoxaHipBoneMapper;
    private final IschiumMapper ischiumMapper;
    private final PatellaMapper patellaMapper;
    private final PubisMapper pubisMapper;
    private final RadiusMapper radiusMapper;
    private final ScapulaMapper scapulaMapper;
    private final TibiaMapper tibiaMapper;
    private final UlnaMapper ulnaMapper;

    @GetMapping("/{appendicularBoneType}/{id}")
    public Result<AppendDto> getById(@PathVariable EnumsBio.AppendicularBoneType appendicularBoneType, @PathVariable Long id) {
        Append append = appendService.getById(appendicularBoneType, id);
        if (append == null) {
            throw new EntityNotFoundException(String.format("Entity with ID %d not found", id));
        }
        AppendDto dto = mapToDto(appendicularBoneType, append);
        return new Result<>(true, HttpStatus.OK.value(), "Entity retrieved successfully", dto);
    }

    @PostMapping("/{appendicularBoneType}")
    public Result<AppendDto> save(@PathVariable EnumsBio.AppendicularBoneType appendicularBoneType, @RequestBody AppendDto appendDto) {
        try {
            Append appendEntity = mapToEntity(appendicularBoneType, appendDto);
            Append savedAppend = appendService.save(appendicularBoneType, appendEntity);
            AppendDto responseDto = mapToDto(appendicularBoneType, savedAppend);
            return new Result<>(true, HttpStatus.CREATED.value(), "Entity created successfully", responseDto);
        } catch (IllegalArgumentException e) {
            return new Result<>(false, HttpStatus.BAD_REQUEST.value(), e.getMessage(), null);
        } catch (Exception e) {
            return new Result<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred", null);
        }
    }

    @PutMapping("/{appendicularBoneType}")
    public Result<AppendDto> update(@PathVariable EnumsBio.AppendicularBoneType appendicularBoneType, @RequestBody AppendDto appendDto) {
        Append entity = appendService.update(appendicularBoneType, appendDto);
        if (entity == null) {
            throw new EntityNotFoundException(String.format("Entity with ID %d not found", appendDto.getId()));
        }
        AppendDto responseDto = mapToDto(appendicularBoneType, entity);
        return new Result<>(true, HttpStatus.OK.value(), "Entity updated successfully", responseDto);
    }

    @DeleteMapping("/{appendicularBoneType}/{id}")
    public Result<Void> deleteById(@PathVariable EnumsBio.AppendicularBoneType appendicularBoneType, @PathVariable Long id) {
        Append entity = appendService.getById(appendicularBoneType, id);
        if (entity == null) {
            throw new EntityNotFoundException(String.format("Entity with ID %d not found", id));
        }
        appendService.deleteById(appendicularBoneType, id);
        return new Result<>(true, HttpStatus.NO_CONTENT.value(), "Entity deleted successfully", null);
    }

    private Append mapToEntity(EnumsBio.AppendicularBoneType appendicularBoneType, AppendDto appendDto) {
        return switch (appendicularBoneType) {
            case CLAVICLE -> {
                if (!(appendDto instanceof ClavicleDto clavicleDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for CLAVICLE");
                }
                yield clavicleMapper.toEntity(clavicleDto);
            }
            case FEMUR -> {
                if (!(appendDto instanceof FemurDto femurDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for FEMUR");
                }
                yield femurMapper.toEntity(femurDto);
            }
            case FIBULA -> {
                if (!(appendDto instanceof FibulaDto fibulaDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for FIBULA");
                }
                yield fibulaMapper.toEntity(fibulaDto);
            }
            case HUMERUS -> {
                if (!(appendDto instanceof HumerusDto humerusDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for HUMERUS");
                }
                yield humerusMapper.toEntity(humerusDto);
            }
            case ILIUM -> {
                if (!(appendDto instanceof IliumDto iliumDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for ILIUM");
                }
                yield iliumMapper.toEntity(iliumDto);
            }
            case OSCOXA -> {
                if (!(appendDto instanceof InnominateOsCoxaHipBoneDto innominateOsCoxaHipBoneDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for OSCOXA");
                }
                yield innominateOsCoxaHipBoneMapper.toEntity(innominateOsCoxaHipBoneDto);
            }
            case ISCHIUM -> {
                if (!(appendDto instanceof IschiumDto ischiumDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for ISCHIUM");
                }
                yield ischiumMapper.toEntity(ischiumDto);
            }
            case PATELLA -> {
                if (!(appendDto instanceof PatellaDto patellaDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for PATELLA");
                }
                yield patellaMapper.toEntity(patellaDto);
            }
            case PUBIS -> {
                if (!(appendDto instanceof PubisDto pubisDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for PUBIS");
                }
                yield pubisMapper.toEntity(pubisDto);
            }
            case RADIUS -> {
                if (!(appendDto instanceof RadiusDto radiusDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for RADIUS");
                }
                yield radiusMapper.toEntity(radiusDto);
            }
            case SCAPULA -> {
                if (!(appendDto instanceof ScapulaDto scapulaDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for SCAPULA");
                }
                yield scapulaMapper.toEntity(scapulaDto);
            }
            case TIBIA -> {
                if (!(appendDto instanceof TibiaDto tibiaDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for TIBIA");
                }
                yield tibiaMapper.toEntity(tibiaDto);
            }
            case ULNA -> {
                if (!(appendDto instanceof UlnaDto ulnaDto)) {
                    throw new IllegalArgumentException("Invalid DTO type for ULNA");
                }
                yield ulnaMapper.toEntity(ulnaDto);
            }
        };
    }


    private AppendDto mapToDto(EnumsBio.AppendicularBoneType appendBoneType, Append append) {
        return switch (appendBoneType) {
            case CLAVICLE -> {
                if (!(append instanceof Clavicle clavicle)) {
                    throw new IllegalArgumentException("Invalid entity type for CLAVICLE");
                }
                yield clavicleMapper.toDto(clavicle);
            }
            case FEMUR -> {
                if (!(append instanceof Femur femur)) {
                    throw new IllegalArgumentException("Invalid entity type for FEMUR");
                }
                yield femurMapper.toDto(femur);
            }
            case FIBULA -> {
                if (!(append instanceof Fibula fibula)) {
                    throw new IllegalArgumentException("Invalid entity type for FIBULA");
                }
                yield fibulaMapper.toDto(fibula);
            }
            case HUMERUS -> {
                if (!(append instanceof Humerus humerus)) {
                    throw new IllegalArgumentException("Invalid entity type for HUMERUS");
                }
                yield humerusMapper.toDto(humerus);
            }
            case ILIUM -> {
                if (!(append instanceof Ilium ilium)) {
                    throw new IllegalArgumentException("Invalid entity type for ILIUM");
                }
                yield iliumMapper.toDto(ilium);
            }
            case OSCOXA -> {
                if (!(append instanceof InnominateOsCoxaHipBone innominateOsCoxaHipBone)) {
                    throw new IllegalArgumentException("Invalid entity type for OSCOXA");
                }
                yield innominateOsCoxaHipBoneMapper.toDto(innominateOsCoxaHipBone);
            }
            case ISCHIUM -> {
                if (!(append instanceof Ischium ischium)) {
                    throw new IllegalArgumentException("Invalid entity type for ISCHIUM");
                }
                yield ischiumMapper.toDto(ischium);
            }
            case PATELLA -> {
                if (!(append instanceof Patella patella)) {
                    throw new IllegalArgumentException("Invalid entity type for PATELLA");
                }
                yield patellaMapper.toDto(patella);
            }
            case PUBIS -> {
                if (!(append instanceof Pubis pubis)) {
                    throw new IllegalArgumentException("Invalid entity type for PUBIS");
                }
                yield pubisMapper.toDto(pubis);
            }
            case RADIUS -> {
                if (!(append instanceof Radius radius)) {
                    throw new IllegalArgumentException("Invalid entity type for RADIUS");
                }
                yield radiusMapper.toDto(radius);
            }
            case SCAPULA -> {
                if (!(append instanceof Scapula scapula)) {
                    throw new IllegalArgumentException("Invalid entity type for SCAPULA");
                }
                yield scapulaMapper.toDto(scapula);
            }
            case TIBIA -> {
                if (!(append instanceof Tibia tibia)) {
                    throw new IllegalArgumentException("Invalid entity type for TIBIA");
                }
                yield tibiaMapper.toDto(tibia);
            }
            case ULNA -> {
                if (!(append instanceof Ulna ulna)) {
                    throw new IllegalArgumentException("Invalid entity type for ULNA");
                }
                yield ulnaMapper.toDto(ulna);
            }
        };
    }

}
