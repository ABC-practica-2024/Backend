package ro.ubb.abc2024.biology.controller.Extremities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.Extremities.Carpals;
import ro.ubb.abc2024.biology.dto.Extremeties.CarpalsDto;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.mapper.Extremities.CarpalsMapper;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.ICarpalsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class CarpalsController {

    @Autowired
    private ICarpalsService carpalsService;

    @Autowired
    private CarpalsMapper carpalsMapper;



    @GetMapping(value="/carpals", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CarpalsDto>> getAllCarpals() {
        try {
            List<Carpals> carpals = carpalsService.getAllCarpals();
            List<CarpalsDto> carpalsDto = carpals.stream()
                    .map(carpi -> carpalsMapper.toDto(carpi))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(carpalsDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping(value="/carpals/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarpalsDto> getCarpalsById(@PathVariable
                                                             Long id) {
        try {
            Carpals carpals = carpalsService.getCarpalsById(id);
            CarpalsDto carpalsDto = carpalsMapper.toDto(carpals);
            return ResponseEntity.ok(carpalsDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping(value = "/carpals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarpalsDto> updateCarpals(@PathVariable
                                                            Long id,
                                                            @RequestBody CarpalsDto carpalsDto) {
        try {
            Carpals updatedCarpals = carpalsService.updateCarpals(id, carpalsMapper.toEntity(carpalsDto));
            CarpalsDto updatedCarpalsDto = carpalsMapper.toDto(updatedCarpals);
            return ResponseEntity.ok(updatedCarpalsDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value = "/carpals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCarpals(@PathVariable
                                               Long id) {
        try {
            carpalsService.deleteCarpalsById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
