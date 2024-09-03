package ro.ubb.abc2024.biology.controller.Extremities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.Extremities.Extremity;
import ro.ubb.abc2024.biology.domain.Extremities.Phalanges;
import ro.ubb.abc2024.biology.dto.Extremeties.PhalangesDto;
import ro.ubb.abc2024.biology.mapper.Extremities.PhalangesMapper;
import ro.ubb.abc2024.biology.service.Extremities.ExtremityService;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class PhalangesController {

    @Autowired
    private ExtremityService extremityService;

    @Autowired
    private PhalangesMapper phalangesMapper;
    List<EnumsBio.ExtremityBone> phalangesEnums = List.of(
            EnumsBio.ExtremityBone.UPPER_PROXIMAL_PHALANGES,
            EnumsBio.ExtremityBone.LOWER_PROXIMAL_PHALANGES,
            EnumsBio.ExtremityBone.UPPER_MIDDLE_PHALANGES,
            EnumsBio.ExtremityBone.LOWER_MIDDLE_PHALANGES,
            EnumsBio.ExtremityBone.UPPER_DISTAL_PHALANGES,
            EnumsBio.ExtremityBone.LOWER_DISTAL_PHALANGES
    );

    @GetMapping(value = "/phalanges", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<List<PhalangesDto>> getAllPhalanges() {
        List<Extremity> extremities = extremityService.getAll(EnumsBio.ExtremityBone.SCAPHOID);  // Use any phalange enum here
        List<Phalanges> phalanges = extremities.stream()
                .filter(extremity -> extremity instanceof Phalanges)
                .map(extremity -> (Phalanges) extremity)
                .collect(Collectors.toList());
        if (phalanges.isEmpty()) {
            return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Phalanges not found", null);
        }
        List<PhalangesDto> phalangesDto = phalanges.stream()
                .map(phalange -> phalangesMapper.toDto(phalange))
                .collect(Collectors.toList());
        return new Result<>(true, HttpStatus.OK.value(), "Here are the phalanges", phalangesDto);
    }

    @GetMapping(value="/phalanges/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<?> getExtremityById( @PathVariable Long id) {
        for (EnumsBio.ExtremityBone bone : phalangesEnums) {
            try {
                Phalanges phalanges = (Phalanges) extremityService.getById(bone, id);
                PhalangesDto phalangesDto = phalangesMapper.toDto(phalanges);
                return new Result<>(true, HttpStatus.OK.value(), "Here are the phalanges", phalangesDto);
            } catch (RuntimeException e) {
            }
        }
        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Phalanges not found with id: " + id, null);
    }


    //
//
    @PostMapping(value = "/phalanges", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<PhalangesDto> savePhalanges(@RequestBody PhalangesDto phalangesDto) {
        Phalanges savedPhalanges = (Phalanges) extremityService.save(phalangesMapper.toEntity(phalangesDto));
        PhalangesDto savedPhalangesDto = phalangesMapper.toDto(savedPhalanges);
        return new Result<>(true, HttpStatus.OK.value(), "Carpi saved successfully", savedPhalangesDto);
    }


    @PutMapping(value = "/phalanges/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<PhalangesDto> updatePhalanges(@PathVariable
                                                      Long id,
                                                      @RequestBody PhalangesDto phalangesDto) {

        for (EnumsBio.ExtremityBone bone : phalangesEnums) {
            try {
                Phalanges phalanges = phalangesMapper.toEntity(phalangesDto);
                phalanges.setId(id);
                phalanges.setBoneType(bone);
                Phalanges updatedPhalanges = (Phalanges) extremityService.update(bone, phalanges);
                PhalangesDto updatedPhalangesDto = phalangesMapper.toDto(updatedPhalanges);
                return new Result<>(true, HttpStatus.OK.value(), "Carpi updated successfully", updatedPhalangesDto);
            } catch (RuntimeException e) {
                // Log the error or handle the exception as needed
            }
        }
        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Phalanges not found with id: " + id, null);
    }


    @DeleteMapping(value = "/phalanges/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<?> deletePhalanges(@PathVariable
                                        Long id) {
        for (EnumsBio.ExtremityBone bone : phalangesEnums) {
            try {
                extremityService.deleteById(bone, id);
                return new Result<>(true, HttpStatus.NO_CONTENT.value(), "Phalanges deleted successfully");
            } catch (RuntimeException e) {
            }
        }
        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Phalanges not found with id: " + id, null);
    }
}
