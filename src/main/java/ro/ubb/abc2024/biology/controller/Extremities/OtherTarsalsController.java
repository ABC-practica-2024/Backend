package ro.ubb.abc2024.biology.controller.Extremities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.Extremities.Extremity;
import ro.ubb.abc2024.biology.domain.Extremities.OtherTarsals;
import ro.ubb.abc2024.biology.dto.Extremeties.OtherTarsalsDto;
import ro.ubb.abc2024.biology.mapper.Extremities.OtherTarsalsMapper;
import ro.ubb.abc2024.biology.service.Extremities.ExtremityService;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class OtherTarsalsController {

    @Autowired
    private ExtremityService extremityService;

    @Autowired
    private OtherTarsalsMapper otherTarsalsMapper;
    
    List<EnumsBio.ExtremityBone> otherTarsalsEnums = List.of(
            EnumsBio.ExtremityBone.MEDIAL_CUNEIFORM,
            EnumsBio.ExtremityBone.INTERMEDIATE_CUNEIFORM,
            EnumsBio.ExtremityBone.LATERAL_CUNEIFORM,
            EnumsBio.ExtremityBone.CUBOID,
            EnumsBio.ExtremityBone.NAVICULAR,
            EnumsBio.ExtremityBone.TALUS,
            EnumsBio.ExtremityBone.UPPER_SESAMOIDS
    );

    @GetMapping(value = "/otherTarsals", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<List<OtherTarsalsDto>> getAllOtherTarsals() {
        List<Extremity> extremities = extremityService.getAll(EnumsBio.ExtremityBone.SCAPHOID);  // Use any otherTarsal enum here
        List<OtherTarsals> otherTarsals = extremities.stream()
                .filter(extremity -> extremity instanceof OtherTarsals)
                .map(extremity -> (OtherTarsals) extremity)
                .collect(Collectors.toList());
        if (otherTarsals.isEmpty()) {
            return new Result<>(false, HttpStatus.NOT_FOUND.value(), "OtherTarsals not found", null);
        }
        List<OtherTarsalsDto> otherTarsalsDto = otherTarsals.stream()
                .map(otherTarsal -> otherTarsalsMapper.toDto(otherTarsal))
                .collect(Collectors.toList());
        return new Result<>(true, HttpStatus.OK.value(), "Here are the otherTarsals", otherTarsalsDto);
    }

    @GetMapping(value="/otherTarsals/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<?> getExtremityById( @PathVariable Long id) {
        for (EnumsBio.ExtremityBone bone : otherTarsalsEnums) {
            try {
                OtherTarsals otherTarsals = (OtherTarsals) extremityService.getById(bone, id);
                OtherTarsalsDto otherTarsalsDto = otherTarsalsMapper.toDto(otherTarsals);
                return new Result<>(true, HttpStatus.OK.value(), "Here are the otherTarsals", otherTarsalsDto);
            } catch (RuntimeException e) {
            }
        }
        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "OtherTarsals not found with id: " + id, null);
    }


    //
//
    @PostMapping(value = "/otherTarsals", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<OtherTarsalsDto> saveOtherTarsals(@RequestBody OtherTarsalsDto otherTarsalsDto) {
        OtherTarsals savedOtherTarsals = (OtherTarsals) extremityService.save(otherTarsalsMapper.toEntity(otherTarsalsDto));
        OtherTarsalsDto savedOtherTarsalsDto = otherTarsalsMapper.toDto(savedOtherTarsals);
        return new Result<>(true, HttpStatus.OK.value(), "Carpi saved successfully", savedOtherTarsalsDto);
    }


    @PutMapping(value = "/otherTarsals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<OtherTarsalsDto> updateOtherTarsals(@PathVariable
                                                    Long id,
                                                    @RequestBody OtherTarsalsDto otherTarsalsDto) {

        for (EnumsBio.ExtremityBone bone : otherTarsalsEnums) {
            try {
                OtherTarsals otherTarsals = otherTarsalsMapper.toEntity(otherTarsalsDto);
                otherTarsals.setId(id);
                otherTarsals.setBoneType(bone);
                OtherTarsals updatedOtherTarsals = (OtherTarsals) extremityService.update(bone, otherTarsals);
                OtherTarsalsDto updatedOtherTarsalsDto = otherTarsalsMapper.toDto(updatedOtherTarsals);
                return new Result<>(true, HttpStatus.OK.value(), "Carpi updated successfully", updatedOtherTarsalsDto);
            } catch (RuntimeException e) {
                // Log the error or handle the exception as needed
            }
        }
        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "OtherTarsals not found with id: " + id, null);
    }


    @DeleteMapping(value = "/otherTarsals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<?> deleteOtherTarsals(@PathVariable
                                       Long id) {
        for (EnumsBio.ExtremityBone bone : otherTarsalsEnums) {
            try {
                extremityService.deleteById(bone, id);
                return new Result<>(true, HttpStatus.NO_CONTENT.value(), "OtherTarsals deleted successfully");
            } catch (RuntimeException e) {
            }
        }
        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "OtherTarsals not found with id: " + id, null);
    }
}
