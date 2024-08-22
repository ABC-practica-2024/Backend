package ro.ubb.abc2024.biology.controller.Extremities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.Extremities.Metatarsals;
import ro.ubb.abc2024.biology.dto.Extremeties.MetatarsalsDto;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.mapper.Extremities.MetatarsalsMapper;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IMetatarsalsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class MetatarsalsController {

    @Autowired
    private IMetatarsalsService metatarsalsService;

    @Autowired
    private MetatarsalsMapper metatarsalsMapper;



    @GetMapping(value="/metatarsals", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MetatarsalsDto>> getAllMetatarsals() {
        try {
            List<Metatarsals> metatarsals = metatarsalsService.getAllMetatarsals();
            List<MetatarsalsDto> metatarsalsDto = metatarsals.stream()
                    .map(metatarsal -> metatarsalsMapper.toDto(metatarsal))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(metatarsalsDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping(value="/metatarsals/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MetatarsalsDto> getMetatarsalsById(@PathVariable
                                                           Long id) {
        try {
            Metatarsals metatarsals = metatarsalsService.getMetatarsalsById(id);
            MetatarsalsDto metatarsalsDto = metatarsalsMapper.toDto(metatarsals);
            return ResponseEntity.ok(metatarsalsDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping(value = "/metatarsals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MetatarsalsDto> updateMetatarsals(@PathVariable
                                                          Long id,
                                                          @RequestBody MetatarsalsDto metatarsalsDto) {
        try {
            Metatarsals updatedMetatarsals = metatarsalsService.updateMetatarsals(id, metatarsalsMapper.toEntity(metatarsalsDto));
            MetatarsalsDto updatedMetatarsalsDto = metatarsalsMapper.toDto(updatedMetatarsals);
            return ResponseEntity.ok(updatedMetatarsalsDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value = "/metatarsals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteMetatarsals(@PathVariable
                                              Long id) {
        try {
            metatarsalsService.deleteMetatarsalsById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
