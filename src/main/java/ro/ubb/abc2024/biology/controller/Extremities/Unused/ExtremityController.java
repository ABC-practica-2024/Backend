//package ro.ubb.abc2024.biology.controller.Extremities;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import ro.ubb.abc2024.biology.mapper.Extremities.ExtremityMapper;
//import ro.ubb.abc2024.biology.service.Extremities.ExtremityService;
//
//@RestController
//@RequestMapping("${api.endpoint.base-url}/")
//public class ExtremityController {
//
//    @Autowired
//    private  ExtremityService extremityService;
//    @Autowired
//    private ExtremityMapper extremityMapper;

//
//    @Operation(summary = "Find all Extremities",
//            description = "Retrieves a comprehensive list of extremities",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "Extremities found"),
//                    @ApiResponse(responseCode = "404", description = "Extremities not found", content = @Content)
//            })
//    @GetMapping(value="/extremities", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<List<ExtremitiesDto>> getAllExtremities() {
//            List<Extremities> extremities = extremitiesService.getAllExtremities();
//            List<ExtremitiesDto> extremitiesDto = extremities.stream()
//                    .map(extremity -> extremitiesMapper.toDto(extremity))
//                    .collect(Collectors.toList());
//            return new Result<>(true, HttpStatus.OK.value(), "Here is the list of extremities.", extremitiesDto);
//
//        }
//
//    @Operation(summary = "Find Extremities by ID",
//            description = "Retrieves a extremities by their id",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "Extremities found"),
//                    @ApiResponse(responseCode = "404", description = "Extremities not found", content = @Content)
//            })
//    @GetMapping(value="/extremities/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<ExtremitiesDto> getExtremitiesById(@PathVariable
//                                               @Parameter(description = "The id of the extremities")
//                                               Long id) {
//            Extremities extremities = extremitiesService.getExtremitiesById(id);
//            ExtremitiesDto extremitiesDto = extremitiesMapper.toDto(extremities);
//        return new Result<>(true, HttpStatus.OK.value(), "Here is the extremity.", extremitiesDto);
//
//    }
//
//
//    @PostMapping(value = "/extremities", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<ExtremitiesDto> saveExtremities(@RequestBody ExtremitiesDto extremitiesDto) {
//        Extremities savedExtremities = extremitiesService.saveExtremities(extremitiesMapper.toEntity(extremitiesDto));
//        ExtremitiesDto savedExtremitiesDto = extremitiesMapper.toDto(savedExtremities);
//        return new Result<>(true, HttpStatus.OK.value(), "Extremities was saved", savedExtremitiesDto);
//    }
//
//    @Operation(summary = "Update an existing Extremities by ID",
//            description = "Update an existing extremities’s information",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "Updated"),
//                    @ApiResponse(responseCode = "404", description = "Extremities not found", content = @Content)
//            })
//    @PutMapping(value = "/extremities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<ExtremitiesDto> updateExtremities(@PathVariable
//                                              @Parameter(description = "The id of the extremities")
//                                              Long id,
//                                              @RequestBody ExtremitiesDto extremitiesDto) {
//            Extremities updatedExtremities = extremitiesService.updateExtremities(id, extremitiesMapper.toEntity(extremitiesDto));
//            ExtremitiesDto updatedExtremitiesDto = extremitiesMapper.toDto(updatedExtremities);
//        return new Result<>(true, HttpStatus.OK.value(), "Extremity updated successfully.", updatedExtremitiesDto);
//    }
//
//    @Operation(summary = "Delete an existing Extremities by ID",
//            description = "Remove a extremities by their ID",
//            responses = {
//                    @ApiResponse(responseCode = "204", description = "Extremities successfully deleted"),
//                    @ApiResponse(responseCode = "404", description = "Extremities not found", content = @Content)
//            })
//    @DeleteMapping(value = "/extremities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<?> deleteExtremities(@PathVariable
//                                        @Parameter(description = "The id of the extremities")
//                                        Long id) {
//            extremitiesService.deleteExtremitiesById(id);
//        return new Result<>(true, HttpStatus.OK.value(), "Extremity deleted successfully");
//    }

//}


