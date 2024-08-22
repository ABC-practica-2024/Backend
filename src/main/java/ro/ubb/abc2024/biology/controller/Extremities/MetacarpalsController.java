package ro.ubb.abc2024.biology.controller.Extremities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.Extremities.Metacarpals;
import ro.ubb.abc2024.biology.dto.Extremeties.MetacarpalsDto;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.mapper.Extremities.MetacarpalsMapper;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IMetacarpalsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class MetacarpalsController {


        @Autowired
        private IMetacarpalsService metacarpalsService;

        @Autowired
        private MetacarpalsMapper metacarpalsMapper;



        @GetMapping(value="/metacarpals", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<MetacarpalsDto>> getAllMetacarpals() {
                try {
                        List<Metacarpals> metacarpals = metacarpalsService.getAllMetacarpals();
                        List<MetacarpalsDto> metacarpalsDto = metacarpals.stream()
                                .map(metacarpal -> metacarpalsMapper.toDto(metacarpal))
                                .collect(Collectors.toList());
                        return ResponseEntity.ok(metacarpalsDto);
                } catch (ResourceNotFoundException e) {
                        return ResponseEntity.notFound().build();
                }
        }


        @GetMapping(value="/metacarpals/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<MetacarpalsDto> getMetacarpalsById(@PathVariable
                                                               Long id) {
                try {
                        Metacarpals metacarpals = metacarpalsService.getMetacarpalsById(id);
                        MetacarpalsDto metacarpalsDto = metacarpalsMapper.toDto(metacarpals);
                        return ResponseEntity.ok(metacarpalsDto);
                } catch (ResourceNotFoundException e) {
                        return ResponseEntity.notFound().build();
                }
        }


        @PutMapping(value = "/metacarpals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<MetacarpalsDto> updateMetacarpals(@PathVariable
                                                              Long id,
                                                              @RequestBody MetacarpalsDto metacarpalsDto) {
                try {
                        Metacarpals updatedMetacarpals = metacarpalsService.updateMetacarpals(id, metacarpalsMapper.toEntity(metacarpalsDto));
                        MetacarpalsDto updatedMetacarpalsDto = metacarpalsMapper.toDto(updatedMetacarpals);
                        return ResponseEntity.ok(updatedMetacarpalsDto);
                } catch (ResourceNotFoundException e) {
                        return ResponseEntity.notFound().build();
                }
        }


        @DeleteMapping(value = "/metacarpals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<?> deleteMetacarpals(@PathVariable
                                                  Long id) {
                try {
                        metacarpalsService.deleteMetacarpalsById(id);
                        return ResponseEntity.noContent().build();
                } catch (ResourceNotFoundException e) {
                        return ResponseEntity.notFound().build();
                }
        }        
}
