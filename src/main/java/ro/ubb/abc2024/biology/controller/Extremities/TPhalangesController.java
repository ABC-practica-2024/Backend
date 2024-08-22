package ro.ubb.abc2024.biology.controller.Extremities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.Extremities.TPhalanges;
import ro.ubb.abc2024.biology.dto.Extremeties.TPhalangesDto;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.mapper.Extremities.TPhalangesMapper;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.ITPhalangesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class TPhalangesController {

    @Autowired
    private ITPhalangesService tPhalangesService;

    @Autowired
    private TPhalangesMapper tPhalangesMapper;



    @GetMapping(value="/tPhalanges", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TPhalangesDto>> getAllTPhalanges() {
        try {
            List<TPhalanges> tPhalanges = tPhalangesService.getAllTPhalanges();
            List<TPhalangesDto> tPhalangesDto = tPhalanges.stream()
                    .map(tPhalange -> tPhalangesMapper.toDto(tPhalange))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(tPhalangesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping(value="/tPhalanges/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TPhalangesDto> getTPhalangesById(@PathVariable
                                                           Long id) {
        try {
            TPhalanges tPhalanges = tPhalangesService.getTPhalangesById(id);
            TPhalangesDto tPhalangesDto = tPhalangesMapper.toDto(tPhalanges);
            return ResponseEntity.ok(tPhalangesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping(value = "/tPhalanges/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TPhalangesDto> updateTPhalanges(@PathVariable
                                                          Long id,
                                                          @RequestBody TPhalangesDto tPhalangesDto) {
        try {
            TPhalanges updatedTPhalanges = tPhalangesService.updateTPhalanges(id, tPhalangesMapper.toEntity(tPhalangesDto));
            TPhalangesDto updatedTPhalangesDto = tPhalangesMapper.toDto(updatedTPhalanges);
            return ResponseEntity.ok(updatedTPhalangesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value = "/tPhalanges/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteTPhalanges(@PathVariable
                                              Long id) {
        try {
            tPhalangesService.deleteTPhalangesById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
