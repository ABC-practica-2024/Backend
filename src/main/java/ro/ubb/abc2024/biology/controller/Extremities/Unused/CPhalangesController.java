//package ro.ubb.abc2024.biology.controller.Extremities.Unused;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import ro.ubb.abc2024.biology.mapper.Extremities.CPhalangesMapper;
//
//import ro.ubb.abc2024.biology.service.Extremities.ExtremityService;
//
//@RestController
//@RequestMapping("${api.endpoint.base-url}/")
//public class CPhalangesController {
//
//    @Autowired
//    private ExtremityService extremityService;
//
//    @Autowired
//    private CPhalangesMapper cPhalangesMapper;
//

//
//    @GetMapping(value="/cPhalanges", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<List<CPhalangesDto>> getAllCPhalanges() {
//        List<CPhalanges> cPhalanges = cPhalangesService.getAllCPhalanges();
//        List<CPhalangesDto> cPhalangesDto = cPhalanges.stream()
//                .map(cPhalange -> cPhalangesMapper.toDto(cPhalange))
//                .collect(Collectors.toList());
//        return new Result<>(true, HttpStatus.OK.value(), "Here is the list of c. phalanges", cPhalangesDto);
//    }
//
//
//    @GetMapping(value="/cPhalanges/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<CPhalangesDto> getCPhalangesById(@PathVariable
//                                                 Long id) {
//        CPhalanges cPhalanges = cPhalangesService.getCPhalangesById(id);
//        CPhalangesDto cPhalangesDto = cPhalangesMapper.toDto(cPhalanges);
//        return new Result<>(true, HttpStatus.OK.value(), "Here is the c. phalange", cPhalangesDto);
//    }
//
//
//    @PostMapping(value = "/cPhalanges", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<CPhalangesDto> saveCPhalanges(@RequestBody CPhalangesDto cPhalangesDto) {
//        CPhalanges savedCPhalanges = cPhalangesService.saveCPhalanges(cPhalangesMapper.toEntity(cPhalangesDto));
//        CPhalangesDto savedCPhalangesDto = cPhalangesMapper.toDto(savedCPhalanges);
//        return new Result<>(true, HttpStatus.OK.value(), "C. phalange saved successfully", savedCPhalangesDto);
//    }
//
//
//    @PutMapping(value = "/cPhalanges/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<CPhalangesDto> updateCPhalanges(@PathVariable
//                                                Long id,
//                                                @RequestBody CPhalangesDto cPhalangesDto) {
//        CPhalanges updatedCPhalanges = cPhalangesService.updateCPhalanges(id, cPhalangesMapper.toEntity(cPhalangesDto));
//        CPhalangesDto updatedCPhalangesDto = cPhalangesMapper.toDto(updatedCPhalanges);
//        return new Result<>(true, HttpStatus.OK.value(), "C. phalange updated successfully", updatedCPhalangesDto);
//    }
//
//
//    @DeleteMapping(value = "/cPhalanges/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Result<?> deleteCPhalanges(@PathVariable
//                                     Long id) {
//        cPhalangesService.deleteCPhalangesById(id);
//        return new Result<>(true, HttpStatus.NO_CONTENT.value(), "C. phalange deleted successfully");
//    }
//}
