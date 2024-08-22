package ro.ubb.abc2024.biology.controller.Extremities;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.Extremities.Extremities;
import ro.ubb.abc2024.biology.dto.Extremeties.ExtremitiesDto;
import ro.ubb.abc2024.biology.exception.ResourceNotFoundException;
import ro.ubb.abc2024.biology.mapper.Extremities.ExtremitiesMapper;
import ro.ubb.abc2024.biology.service.Extremities.Interfaces.IExtremitiesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class ExtremitiesController {

    @Autowired
    private IExtremitiesService extremitiesService;

    @Autowired
    private ExtremitiesMapper extremitiesMapper;


    @Operation(summary = "Find all Extremities",
            description = "Retrieves a comprehensive list of extremities",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Extremities found"),
                    @ApiResponse(responseCode = "404", description = "Extremities not found", content = @Content)
            })
    @GetMapping(value="/extremities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExtremitiesDto>> getAllExtremities() {
        try {
            List<Extremities> extremities = extremitiesService.getAllExtremities();
            List<ExtremitiesDto> extremitiesDto = extremities.stream()
                    .map(extremity -> extremitiesMapper.toDto(extremity))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(extremitiesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find Extremities by ID",
            description = "Retrieves a extremities by their id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Extremities found"),
                    @ApiResponse(responseCode = "404", description = "Extremities not found", content = @Content)
            })
    @GetMapping(value="/extremities/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExtremitiesDto> getExtremitiesById(@PathVariable
                                               @Parameter(description = "The id of the extremities")
                                               Long id) {
        try {
            Extremities extremities = extremitiesService.getExtremitiesById(id);
            ExtremitiesDto extremitiesDto = extremitiesMapper.toDto(extremities);
            return ResponseEntity.ok(extremitiesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(summary = "Update an existing Extremities by ID",
            description = "Update an existing extremities’s information",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Updated"),
                    @ApiResponse(responseCode = "404", description = "Extremities not found", content = @Content)
            })
    @PutMapping(value = "/extremities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExtremitiesDto> updateExtremities(@PathVariable
                                              @Parameter(description = "The id of the extremities")
                                              Long id,
                                              @RequestBody ExtremitiesDto extremitiesDto) {
        try {
            Extremities updatedExtremities = extremitiesService.updateExtremities(id, extremitiesMapper.toEntity(extremitiesDto));
            ExtremitiesDto updatedExtremitiesDto = extremitiesMapper.toDto(updatedExtremities);
            return ResponseEntity.ok(updatedExtremitiesDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete an existing Extremities by ID",
            description = "Remove a extremities by their ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Extremities successfully deleted"),
                    @ApiResponse(responseCode = "404", description = "Extremities not found", content = @Content)
            })
    @DeleteMapping(value = "/extremities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteExtremities(@PathVariable
                                        @Parameter(description = "The id of the extremities")
                                        Long id) {
        try {
            extremitiesService.deleteExtremitiesById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}


