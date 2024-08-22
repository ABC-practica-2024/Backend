package ro.ubb.abc2024.biology.controller.Extremities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.Extremities.Calcaneus;
import ro.ubb.abc2024.biology.dto.Extremeties.CalcaneusDto;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.mapper.Extremities.CalcaneusMapper;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.ICalcaneusService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class CalcaneusController {

    @Autowired
    private ICalcaneusService calcaneusService;

    @Autowired
    private CalcaneusMapper calcaneusMapper;



    @GetMapping(value="/calcaneus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CalcaneusDto>> getAllCalcanei() {
        try {
            List<Calcaneus> calcaneus = calcaneusService.getAllCalcanei();
            List<CalcaneusDto> calcaneusDto = calcaneus.stream()
                    .map(calcanei -> calcaneusMapper.toDto(calcanei))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(calcaneusDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping(value="/calcaneus/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalcaneusDto> getCalcaneusById(@PathVariable
                                                             Long id) {
        try {
            Calcaneus calcaneus = calcaneusService.getCalcaneusById(id);
            CalcaneusDto calcaneusDto = calcaneusMapper.toDto(calcaneus);
            return ResponseEntity.ok(calcaneusDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(value = "/calcaneus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalcaneusDto> saveCalcaneus(@RequestBody CalcaneusDto calcaneusDto) {
        try {
            Calcaneus savedCalcaneus = calcaneusService.saveCalcaneus(calcaneusMapper.toEntity(calcaneusDto));
            CalcaneusDto savedCalcaneusDto = calcaneusMapper.toDto(savedCalcaneus);
            return ResponseEntity.ok(savedCalcaneusDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping(value = "/calcaneus/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalcaneusDto> updateCalcaneus(@PathVariable
                                                            Long id,
                                                            @RequestBody CalcaneusDto calcaneusDto) {
        try {
            Calcaneus updatedCalcaneus = calcaneusService.updateCalcaneus(id, calcaneusMapper.toEntity(calcaneusDto));
            CalcaneusDto updatedCalcaneusDto = calcaneusMapper.toDto(updatedCalcaneus);
            return ResponseEntity.ok(updatedCalcaneusDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value = "/calcaneus/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCalcaneus(@PathVariable
                                               Long id) {
        try {
            calcaneusService.deleteCalcaneusById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
