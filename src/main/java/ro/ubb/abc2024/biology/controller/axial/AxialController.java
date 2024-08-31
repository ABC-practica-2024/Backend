package ro.ubb.abc2024.biology.controller.axial;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.axial.*;
import ro.ubb.abc2024.biology.dto.axial.*;
import ro.ubb.abc2024.biology.mapper.axial.*;
import ro.ubb.abc2024.biology.service.axial.AxialService;
import ro.ubb.abc2024.utils.dto.Result;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/axial")
public class AxialController {

    private final AxialService axialService;
    private final CoccyxMapper coccyxMapper;
    private final RibsMapper ribsMapper;
    private final SacrumMapper sacrumMapper;
    private final SternumMapper sternumMapper;
    private final VertebraeMapper vertebraeMapper;

    @GetMapping("/{axialBoneType}/{id}")
    public Result<AxialDto> getById(@PathVariable EnumsBio.AxialBoneType axialBoneType, @PathVariable Long id) {
        Axial axial = axialService.getById(axialBoneType, id);
        if (axial == null) {
            throw new EntityNotFoundException(String.format("Entity with ID %d not found", id));
        }
        AxialDto dto = mapToDto(axialBoneType, axial);
        return new Result<>(true, HttpStatus.OK.value(), "Entity retrieved successfully", dto);
    }

    @PostMapping("/{axialBoneType}")
    public Result<AxialDto> save(@PathVariable EnumsBio.AxialBoneType axialBoneType, @RequestBody AxialDto axialDto) {
        try {
            Axial axialEntity = mapToEntity(axialBoneType, axialDto);
            Axial savedAxial = axialService.save(axialBoneType, axialEntity);
            AxialDto responseDto = mapToDto(axialBoneType, savedAxial);
            return new Result<>(true, HttpStatus.CREATED.value(), "Entity created successfully", responseDto);
        } catch (IllegalArgumentException e) {
            return new Result<>(false, HttpStatus.BAD_REQUEST.value(), e.getMessage(), null);
        } catch (Exception e) {
            return new Result<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred", null);
        }
    }

    @PutMapping("/{axialBoneType}")
    public Result<AxialDto> update(@PathVariable EnumsBio.AxialBoneType axialBoneType, @RequestBody AxialDto axialDto) {
        Axial entity = axialService.update(axialBoneType, axialDto);
        if (entity == null) {
            throw new EntityNotFoundException(String.format("Entity with ID %d not found", axialDto.getId()));
        }
        AxialDto responseDto = mapToDto(axialBoneType, entity);
        return new Result<>(true, HttpStatus.OK.value(), "Entity updated successfully", responseDto);
    }

    @DeleteMapping("/{axialBoneType}/{id}")
    public Result<Void> deleteById(@PathVariable EnumsBio.AxialBoneType axialBoneType, @PathVariable Long id) {
        Axial entity = axialService.getById(axialBoneType, id);
        if (entity == null) {
            throw new EntityNotFoundException(String.format("Entity with ID %d not found", id));
        }
        axialService.deleteById(axialBoneType, id);
        return new Result<>(true, HttpStatus.NO_CONTENT.value(), "Entity deleted successfully", null);
    }

    private Axial mapToEntity(EnumsBio.AxialBoneType axialBoneType, AxialDto axialDto) {
        return switch (axialBoneType) {
            case COCCYX -> {
                if (!(axialDto instanceof CoccyxDto source)) {
                    throw new IllegalArgumentException("Invalid DTO type for COCCYX");
                }
                yield coccyxMapper.toEntity(source);
            }
            case RIBS -> {
                if (!(axialDto instanceof RibsDto source)) {
                    throw new IllegalArgumentException("Invalid DTO type for RIBS");
                }
                yield ribsMapper.toEntity(source);
            }
            case SACRUM -> {
                if (!(axialDto instanceof SacrumDto source)) {
                    throw new IllegalArgumentException("Invalid DTO type for SACRUM");
                }
                yield sacrumMapper.toEntity(source);
            }
            case STERNUM -> {
                if (!(axialDto instanceof SternumDto source)) {
                    throw new IllegalArgumentException("Invalid DTO type for STERNUM");
                }
                yield sternumMapper.toEntity(source);
            }
            case VERTEBRAE -> {
                if (!(axialDto instanceof VertebraeDto source)) {
                    throw new IllegalArgumentException("Invalid DTO type for VERTEBRAE");
                }
                yield vertebraeMapper.toEntity(source);
            }
        };
    }


    private AxialDto mapToDto(EnumsBio.AxialBoneType axialBoneType, Axial axial) {
        return switch (axialBoneType) {
            case COCCYX -> {
                if (!(axial instanceof Coccyx coccyx)) {
                    throw new IllegalArgumentException("Invalid entity type for COCCYX");
                }
                yield coccyxMapper.toDto(coccyx);
            }
            case RIBS -> {
                if (!(axial instanceof Ribs ribs)) {
                    throw new IllegalArgumentException("Invalid entity type for RIBS");
                }
                yield ribsMapper.toDto(ribs);
            }
            case SACRUM -> {
                if (!(axial instanceof Sacrum sacrum)) {
                    throw new IllegalArgumentException("Invalid entity type for SACRUM");
                }
                yield sacrumMapper.toDto(sacrum);
            }
            case STERNUM -> {
                if (!(axial instanceof Sternum sternum)) {
                    throw new IllegalArgumentException("Invalid entity type for STERNUM");
                }
                yield sternumMapper.toDto(sternum);
            }
            case VERTEBRAE -> {
                if (!(axial instanceof Vertebrae vertebrae)) {
                    throw new IllegalArgumentException("Invalid entity type for VERTEBRAE");
                }
                yield vertebraeMapper.toDto(vertebrae);
            }
        };
    }
}