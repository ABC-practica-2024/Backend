package ro.ubb.abc2024.biology.controller.Extremities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.Extremities.CPhalanges;
import ro.ubb.abc2024.biology.dto.Extremeties.CPhalangesDto;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.mapper.Extremities.CPhalangesMapper;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.ICPhalangesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class CPhalangesController {

    @Autowired
    private ICPhalangesService cPhalangesService;

    @Autowired
    private CPhalangesMapper cPhalangesMapper;



    @GetMapping(value="/cPhalanges", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CPhalangesDto>> getAllCPhalanges() {
        try {
            List<CPhalanges> cPhalanges = cPhalangesService.getAllCPhalanges();
            List<CPhalangesDto> cPhalangesDto = cPhalanges.stream()
                    .map(cPhalange -> cPhalangesMapper.toDto(cPhalange))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(cPhalangesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping(value="/cPhalanges/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CPhalangesDto> getCPhalangesById(@PathVariable
                                                             Long id) {
        try {
            CPhalanges cPhalanges = cPhalangesService.getCPhalangesById(id);
            CPhalangesDto cPhalangesDto = cPhalangesMapper.toDto(cPhalanges);
            return ResponseEntity.ok(cPhalangesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping(value = "/cPhalanges/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CPhalangesDto> updateCPhalanges(@PathVariable
                                                            Long id,
                                                            @RequestBody CPhalangesDto cPhalangesDto) {
        try {
            CPhalanges updatedCPhalanges = cPhalangesService.updateCPhalanges(id, cPhalangesMapper.toEntity(cPhalangesDto));
            CPhalangesDto updatedCPhalangesDto = cPhalangesMapper.toDto(updatedCPhalanges);
            return ResponseEntity.ok(updatedCPhalangesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value = "/cPhalanges/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCPhalanges(@PathVariable
                                               Long id) {
        try {
            cPhalangesService.deleteCPhalangesById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
