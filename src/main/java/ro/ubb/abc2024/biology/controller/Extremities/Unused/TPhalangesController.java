//package ro.ubb.abc2024.biology.controller.Extremities.Unused;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import ro.ubb.abc2024.biology.mapper.Extremities.TPhalangesMapper;
//import ro.ubb.abc2024.biology.service.Extremities.ExtremityService;
//
//@RestController
//@RequestMapping("${api.endpoint.base-url}/")
//public class TPhalangesController {
//
//    @Autowired
//    private ExtremityService extremityService;
//
//    @Autowired
//    private TPhalangesMapper tPhalangesMapper;
//

//
//    @GetMapping(value="/tPhalanges", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<List<TPhalangesDto>> getAllTPhalanges() {
//         List<TPhalanges> tPhalanges = tPhalangesService.getAllTPhalanges();
//         List<TPhalangesDto> tPhalangesDto = tPhalanges.stream()
//                    .map(tPhalange -> tPhalangesMapper.toDto(tPhalange))
//                    .collect(Collectors.toList());
//        return new Result<>(true, HttpStatus.OK.value(), "Here is the list of tPhalanges", tPhalangesDto);
//    }
//
//
//    @GetMapping(value="/tPhalanges/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<TPhalangesDto> getTPhalangesById(@PathVariable
//                                                           Long id) {
//        TPhalanges tPhalanges = tPhalangesService.getTPhalangesById(id);
//        TPhalangesDto tPhalangesDto = tPhalangesMapper.toDto(tPhalanges);
//        return new Result<>(true, HttpStatus.OK.value(), "Here is the t. phalange", tPhalangesDto);
//    }
//
//    @PostMapping(value = "/tPhalanges", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<TPhalangesDto> saveTPhalanges(@RequestBody TPhalangesDto tPhalangesDto) {
//        TPhalanges savedTPhalanges = tPhalangesService.saveTPhalanges(tPhalangesMapper.toEntity(tPhalangesDto));
//        TPhalangesDto savedTPhalangesDto = tPhalangesMapper.toDto(savedTPhalanges);
//        return new Result<>(true, HttpStatus.OK.value(), "T. phalange saved successfully", savedTPhalangesDto);
//    }
//
//    @PutMapping(value = "/tPhalanges/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<TPhalangesDto> updateTPhalanges(@PathVariable
//                                                          Long id,
//                                                          @RequestBody TPhalangesDto tPhalangesDto) {
//        TPhalanges updatedTPhalanges = tPhalangesService.updateTPhalanges(id, tPhalangesMapper.toEntity(tPhalangesDto));
//        TPhalangesDto updatedTPhalangesDto = tPhalangesMapper.toDto(updatedTPhalanges);
//        return new Result<>(true, HttpStatus.OK.value(), "T. phalange updated successfully", updatedTPhalangesDto);
//    }
//
//
//    @DeleteMapping(value = "/tPhalanges/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<?> deleteTPhalanges(@PathVariable
//                                              Long id) {
//        tPhalangesService.deleteTPhalangesById(id);
//        return new Result<>(true, HttpStatus.OK.value(), "T. phalange deleted successfully");
//
//    }
//}
