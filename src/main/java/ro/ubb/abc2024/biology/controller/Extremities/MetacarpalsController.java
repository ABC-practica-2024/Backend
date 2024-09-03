package ro.ubb.abc2024.biology.controller.Extremities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.Extremities.Metacarpals;
import ro.ubb.abc2024.biology.domain.Extremities.Metacarpals;
import ro.ubb.abc2024.biology.domain.Extremities.Extremity;
import ro.ubb.abc2024.biology.domain.Extremities.Metacarpals;
import ro.ubb.abc2024.biology.dto.Extremeties.MetacarpalsDto;
import ro.ubb.abc2024.biology.dto.Extremeties.MetacarpalsDto;
import ro.ubb.abc2024.biology.dto.Extremeties.MetacarpalsDto;
import ro.ubb.abc2024.biology.mapper.Extremities.MetacarpalsMapper;
import ro.ubb.abc2024.biology.service.Extremities.ExtremityService;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class MetacarpalsController {

        @Autowired
        private  ExtremityService extremityService;

        @Autowired
        private MetacarpalsMapper metacarpalsMapper;
        
        
        List<EnumsBio.ExtremityBone> metacarpalsEnums = List.of(
                EnumsBio.ExtremityBone.METACARPALS,
                EnumsBio.ExtremityBone.UPPER_SESAMOIDS
        );
        @GetMapping(value = "/metacarpals", produces = MediaType.APPLICATION_JSON_VALUE)
        public Result<List<MetacarpalsDto>> getAllMetacarpals() {
                List<Extremity> extremities = extremityService.getAll(EnumsBio.ExtremityBone.SCAPHOID);  // Use any metacarpal enum here
                List<Metacarpals> metacarpals = extremities.stream()
                        .filter(extremity -> extremity instanceof Metacarpals)
                        .map(extremity -> (Metacarpals) extremity)
                        .collect(Collectors.toList());
                if (metacarpals.isEmpty()) {
                        return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Metacarpals not found", null);
                }
                List<MetacarpalsDto> metacarpalsDto = metacarpals.stream()
                        .map(metacarpal -> metacarpalsMapper.toDto(metacarpal))
                        .collect(Collectors.toList());
                return new Result<>(true, HttpStatus.OK.value(), "Here are the metacarpals", metacarpalsDto);
        }

        @GetMapping(value="/metacarpals/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public Result<?> getExtremityById( @PathVariable Long id) {
                for (EnumsBio.ExtremityBone bone : metacarpalsEnums) {
                        try {
                                Metacarpals metacarpals = (Metacarpals) extremityService.getById(bone, id);
                                MetacarpalsDto metacarpalsDto = metacarpalsMapper.toDto(metacarpals);
                                return new Result<>(true, HttpStatus.OK.value(), "Here are the metacarpals", metacarpalsDto);
                        } catch (RuntimeException e) {
                        }
                }
                return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Metacarpals not found with id: " + id, null);
        }


        //
//
        @PostMapping(value = "/metacarpals", produces = MediaType.APPLICATION_JSON_VALUE)
        public Result<MetacarpalsDto> saveMetacarpals(@RequestBody MetacarpalsDto metacarpalsDto) {
                Metacarpals savedMetacarpals = (Metacarpals) extremityService.save(metacarpalsMapper.toEntity(metacarpalsDto));
                MetacarpalsDto savedMetacarpalsDto = metacarpalsMapper.toDto(savedMetacarpals);
                return new Result<>(true, HttpStatus.OK.value(), "Metacarpals saved successfully", savedMetacarpalsDto);
        }


        @PutMapping(value = "/metacarpals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public Result<MetacarpalsDto> updateMetacarpals(@PathVariable
                                                Long id,
                                                @RequestBody MetacarpalsDto metacarpalsDto) {

                for (EnumsBio.ExtremityBone bone : metacarpalsEnums) {
                        try {
                                Metacarpals metacarpals = metacarpalsMapper.toEntity(metacarpalsDto);
                                metacarpals.setId(id);
                                metacarpals.setBoneType(bone);
                                Metacarpals updatedMetacarpals = (Metacarpals) extremityService.update(bone, metacarpals);
                                MetacarpalsDto updatedMetacarpalsDto = metacarpalsMapper.toDto(updatedMetacarpals);
                                return new Result<>(true, HttpStatus.OK.value(), "Metacarpals updated successfully", updatedMetacarpalsDto);
                        } catch (RuntimeException e) {
                                // Log the error or handle the exception as needed
                        }
                }
                return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Metacarpals not found with id: " + id, null);
        }


        @DeleteMapping(value = "/metacarpals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public Result<?> deleteMetacarpals(@PathVariable
                                       Long id) {
                for (EnumsBio.ExtremityBone bone : metacarpalsEnums) {
                        try {
                                extremityService.deleteById(bone, id);
                                return new Result<>(true, HttpStatus.NO_CONTENT.value(), "Metacarpals deleted successfully");
                        } catch (RuntimeException e) {
                        }
                }
                return new Result<>(false, HttpStatus.NOT_FOUND.value(), "Metacarpals not found with id: " + id, null);
        }
}
