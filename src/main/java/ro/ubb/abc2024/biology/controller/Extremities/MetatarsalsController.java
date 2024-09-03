package ro.ubb.abc2024.biology.controller.Extremities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.Extremities.Extremity;
import ro.ubb.abc2024.biology.domain.Extremities.Metatarsals;
import ro.ubb.abc2024.biology.dto.Extremeties.MetatarsalsDto;
import ro.ubb.abc2024.biology.mapper.Extremities.MetatarsalsMapper;
import ro.ubb.abc2024.biology.service.Extremities.ExtremityService;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class MetatarsalsController {

    @Autowired
    private ExtremityService extremityService;

    @Autowired
    private MetatarsalsMapper metatarsalsMapper;

    List<EnumsBio.ExtremityBone> metatarsalsEnums = List.of(
            EnumsBio.ExtremityBone.METATARSALS,
            EnumsBio.ExtremityBone.UPPER_SESAMOIDS
    );

    @GetMapping(value = "/metatarsals", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<List<MetatarsalsDto>> getAllMetatarsals() {
        List<Extremity> extremities = extremityService.getAll(EnumsBio.ExtremityBone.SCAPHOID);  // Use any metatarsal enum here
        List<Metatarsals> metatarsals = extremities.stream()
                .filter(extremity -> extremity instanceof Metatarsals)
                .map(extremity -> (Metatarsals) extremity)
                .collect(Collectors.toList());
        if (metatarsals.isEmpty()) {
            return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Metatarsals not found", null);
        }
        List<MetatarsalsDto> metatarsalsDto = metatarsals.stream()
                .map(metatarsal -> metatarsalsMapper.toDto(metatarsal))
                .collect(Collectors.toList());
        return new Result<>(true, HttpStatus.OK.value(), "Here are the metatarsals", metatarsalsDto);
    }

    @GetMapping(value="/metatarsals/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<?> getExtremityById( @PathVariable Long id) {
        for (EnumsBio.ExtremityBone bone : metatarsalsEnums) {
            try {
                Metatarsals metatarsals = (Metatarsals) extremityService.getById(bone, id);
                MetatarsalsDto metatarsalsDto = metatarsalsMapper.toDto(metatarsals);
                return new Result<>(true, HttpStatus.OK.value(), "Here are the metatarsals", metatarsalsDto);
            } catch (RuntimeException e) {
            }
        }
        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Metatarsals not found with id: " + id, null);
    }


    //
//
    @PostMapping(value = "/metatarsals", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<MetatarsalsDto> saveMetatarsals(@RequestBody MetatarsalsDto metatarsalsDto) {
        Metatarsals savedMetatarsals = (Metatarsals) extremityService.save(metatarsalsMapper.toEntity(metatarsalsDto));
        MetatarsalsDto savedMetatarsalsDto = metatarsalsMapper.toDto(savedMetatarsals);
        return new Result<>(true, HttpStatus.OK.value(), "Carpi saved successfully", savedMetatarsalsDto);
    }


    @PutMapping(value = "/metatarsals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<MetatarsalsDto> updateMetatarsals(@PathVariable
                                                    Long id,
                                                    @RequestBody MetatarsalsDto metatarsalsDto) {

        for (EnumsBio.ExtremityBone bone : metatarsalsEnums) {
            try {
                Metatarsals metatarsals = metatarsalsMapper.toEntity(metatarsalsDto);
                metatarsals.setId(id);
                metatarsals.setBoneType(bone);
                Metatarsals updatedMetatarsals = (Metatarsals) extremityService.update(bone, metatarsals);
                MetatarsalsDto updatedMetatarsalsDto = metatarsalsMapper.toDto(updatedMetatarsals);
                return new Result<>(true, HttpStatus.OK.value(), "Carpi updated successfully", updatedMetatarsalsDto);
            } catch (RuntimeException e) {
                // Log the error or handle the exception as needed
            }
        }
        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Metatarsals not found with id: " + id, null);
    }


    @DeleteMapping(value = "/metatarsals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<?> deleteMetatarsals(@PathVariable
                                       Long id) {
        for (EnumsBio.ExtremityBone bone : metatarsalsEnums) {
            try {
                extremityService.deleteById(bone, id);
                return new Result<>(true, HttpStatus.NO_CONTENT.value(), "Metatarsals deleted successfully");
            } catch (RuntimeException e) {
            }
        }
        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Metatarsals not found with id: " + id, null);
    }
}
