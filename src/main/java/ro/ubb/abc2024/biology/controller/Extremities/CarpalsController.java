package ro.ubb.abc2024.biology.controller.Extremities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.Extremities.Calcaneus;
import ro.ubb.abc2024.biology.domain.Extremities.Carpals;
import ro.ubb.abc2024.biology.domain.Extremities.Extremity;
import ro.ubb.abc2024.biology.dto.Extremeties.CalcaneusDto;
import ro.ubb.abc2024.biology.dto.Extremeties.CarpalsDto;
import ro.ubb.abc2024.biology.mapper.Extremities.CarpalsMapper;
import ro.ubb.abc2024.biology.service.Extremities.ExtremityService;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class CarpalsController {

    @Autowired
    private ExtremityService extremityService;

    @Autowired
    private CarpalsMapper carpalsMapper;


    List<EnumsBio.ExtremityBone> carpalsEnums = List.of(
            EnumsBio.ExtremityBone.SCAPHOID,
            EnumsBio.ExtremityBone.LUNATE,
            EnumsBio.ExtremityBone.TRIQUETRUM,
            EnumsBio.ExtremityBone.PISIFORM,
            EnumsBio.ExtremityBone.HAMATE,
            EnumsBio.ExtremityBone.CAPITATE,
            EnumsBio.ExtremityBone.TRAPEZIUM,
            EnumsBio.ExtremityBone.TRAPEZOID
    );

    @GetMapping(value = "/carpals", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<List<CarpalsDto>> getAllCarpals() {
        List<Extremity> extremities = extremityService.getAll(EnumsBio.ExtremityBone.SCAPHOID);  // Use any carpal enum here
        List<Carpals> carpals = extremities.stream()
                .filter(extremity -> extremity instanceof Carpals)
                .map(extremity -> (Carpals) extremity)
                .collect(Collectors.toList());
        if (carpals.isEmpty()) {
            return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Carpals not found", null);
        }
        List<CarpalsDto> carpalsDto = carpals.stream()
                .map(carpal -> carpalsMapper.toDto(carpal))
                .collect(Collectors.toList());
        return new Result<>(true, HttpStatus.OK.value(), "Here are the carpals", carpalsDto);
    }

    @GetMapping(value="/carpals/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<?> getExtremityById( @PathVariable Long id) {
        for (EnumsBio.ExtremityBone bone : carpalsEnums) {
            try {
                Carpals carpals = (Carpals) extremityService.getById(bone, id);
                CarpalsDto carpalsDto = carpalsMapper.toDto(carpals);
                return new Result<>(true, HttpStatus.OK.value(), "Here are the carpals", carpalsDto);
            } catch (RuntimeException e) {
            }
        }
        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Carpals not found with id: " + id, null);
    }


//
//
    @PostMapping(value = "/carpals", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<CarpalsDto> saveCarpals(@RequestBody CarpalsDto carpalsDto) {
        Carpals savedCarpals = (Carpals) extremityService.save(carpalsMapper.toEntity(carpalsDto));
        CarpalsDto savedCarpalsDto = carpalsMapper.toDto(savedCarpals);
        return new Result<>(true, HttpStatus.OK.value(), "Carpi saved successfully", savedCarpalsDto);
    }


    @PutMapping(value = "/carpals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<CarpalsDto> updateCarpals(@PathVariable
                                                Long id,
                                                @RequestBody CarpalsDto carpalsDto) {

        for (EnumsBio.ExtremityBone bone : carpalsEnums) {
            try {
                Carpals carpals = carpalsMapper.toEntity(carpalsDto);
                carpals.setId(id);
                carpals.setBoneType(bone);
                Carpals updatedCarpals = (Carpals) extremityService.update(bone, carpals);
                CarpalsDto updatedCarpalsDto = carpalsMapper.toDto(updatedCarpals);
                return new Result<>(true, HttpStatus.OK.value(), "Carpi updated successfully", updatedCarpalsDto);
            } catch (RuntimeException e) {
                // Log the error or handle the exception as needed
            }
        }
        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Carpals not found with id: " + id, null);
    }


    @DeleteMapping(value = "/carpals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<?> deleteCarpals(@PathVariable
                                     Long id) {
        for (EnumsBio.ExtremityBone bone : carpalsEnums) {
            try {
                extremityService.deleteById(bone, id);
                return new Result<>(true, HttpStatus.NO_CONTENT.value(), "Carpals deleted successfully");
            } catch (RuntimeException e) {
            }
        }
        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Carpals not found with id: " + id, null);
    }
}
