package ro.ubb.abc2024.biology.controller.Extremities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.Extremities.Phalanges;
import ro.ubb.abc2024.biology.dto.Extremeties.PhalangesDto;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.mapper.Extremities.PhalangesMapper;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IPhalangesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class PhalangesController {

    @Autowired
    private IPhalangesService phalangesService;

    @Autowired
    private PhalangesMapper phalangesMapper;



    @GetMapping(value="/phalanges", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PhalangesDto>> getAllPhalanges() {
        try {
            List<Phalanges> phalanges = phalangesService.getAllPhalanges();
            List<PhalangesDto> phalangesDto = phalanges.stream()
                    .map(phalange -> phalangesMapper.toDto(phalange))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(phalangesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping(value="/phalanges/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhalangesDto> getPhalangesById(@PathVariable
                                                           Long id) {
        try {
            Phalanges phalanges = phalangesService.getPhalangesById(id);
            PhalangesDto phalangesDto = phalangesMapper.toDto(phalanges);
            return ResponseEntity.ok(phalangesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping(value = "/phalanges/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhalangesDto> updatePhalanges(@PathVariable
                                                          Long id,
                                                          @RequestBody PhalangesDto phalangesDto) {
        try {
            Phalanges updatedPhalanges = phalangesService.updatePhalanges(id, phalangesMapper.toEntity(phalangesDto));
            PhalangesDto updatedPhalangesDto = phalangesMapper.toDto(updatedPhalanges);
            return ResponseEntity.ok(updatedPhalangesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value = "/phalanges/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePhalanges(@PathVariable
                                              Long id) {
        try {
            phalangesService.deletePhalangesById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
