package ro.ubb.abc2024.biology.controller.Extremities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.Extremities.OtherTarsals;
import ro.ubb.abc2024.biology.dto.Extremeties.OtherTarsalsDto;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.mapper.Extremities.OtherTarsalsMapper;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IOtherTarsalsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class OtherTarsalsController {

    @Autowired
    private IOtherTarsalsService otherTarsalsService;

    @Autowired
    private OtherTarsalsMapper otherTarsalsMapper;



    @GetMapping(value="/otherTarsals", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OtherTarsalsDto>> getAllOtherTarsals() {
        try {
            List<OtherTarsals> otherTarsals = otherTarsalsService.getAllOtherTarsals();
            List<OtherTarsalsDto> otherTarsalsDto = otherTarsals.stream()
                    .map(otherTarsal -> otherTarsalsMapper.toDto(otherTarsal))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(otherTarsalsDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping(value="/otherTarsals/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OtherTarsalsDto> getOtherTarsalsById(@PathVariable
                                                           Long id) {
        try {
            OtherTarsals otherTarsals = otherTarsalsService.getOtherTarsalsById(id);
            OtherTarsalsDto otherTarsalsDto = otherTarsalsMapper.toDto(otherTarsals);
            return ResponseEntity.ok(otherTarsalsDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping(value = "/otherTarsals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OtherTarsalsDto> updateOtherTarsals(@PathVariable
                                                          Long id,
                                                          @RequestBody OtherTarsalsDto otherTarsalsDto) {
        try {
            OtherTarsals updatedOtherTarsals = otherTarsalsService.updateOtherTarsals(id, otherTarsalsMapper.toEntity(otherTarsalsDto));
            OtherTarsalsDto updatedOtherTarsalsDto = otherTarsalsMapper.toDto(updatedOtherTarsals);
            return ResponseEntity.ok(updatedOtherTarsalsDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value = "/otherTarsals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteOtherTarsals(@PathVariable
                                              Long id) {
        try {
            otherTarsalsService.deleteOtherTarsalsById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
