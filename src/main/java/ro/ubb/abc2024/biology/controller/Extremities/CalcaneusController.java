package ro.ubb.abc2024.biology.controller.Extremities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.Extremities.Calcaneus;
import ro.ubb.abc2024.biology.domain.Extremities.Carpals;
import ro.ubb.abc2024.biology.domain.Extremities.Extremity;
import ro.ubb.abc2024.biology.dto.Extremeties.CalcaneusDto;
import ro.ubb.abc2024.biology.mapper.Extremities.CalcaneusMapper;
import ro.ubb.abc2024.biology.service.Extremities.ExtremityService;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class CalcaneusController {

    @Autowired
    private ExtremityService extremityService;

    @Autowired
    private CalcaneusMapper calcaneusMapper;



    @GetMapping(value="/calcaneus", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<List<CalcaneusDto>> getAllCalcaneus() {
        List<Extremity> extremities = extremityService.getAll(EnumsBio.ExtremityBone.CALCANEUS);

        List<Calcaneus> calcaneus = extremities.stream()
                .filter(extremity -> extremity instanceof Calcaneus)
                .map(extremity -> (Calcaneus) extremity)
                .collect(Collectors.toList());

        List<CalcaneusDto> calcaneusDto = calcaneus.stream()
                .map(calcanei -> calcaneusMapper.toDto(calcanei))
                .collect(Collectors.toList());

        return new Result<>(true, HttpStatus.OK.value(), "Here is the list of calcaneus", calcaneusDto);
    }


    @GetMapping(value="/calcaneus/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<CalcaneusDto> getCalcaneusById(@PathVariable
                                                             Long id) {
        Calcaneus calcaneus = (Calcaneus) extremityService.getById(EnumsBio.ExtremityBone.CALCANEUS, id);
        CalcaneusDto calcaneusDto = calcaneusMapper.toDto(calcaneus);
        return new Result<>(true, HttpStatus.OK.value(), "Here is the calcanei", calcaneusDto);
    }


    @PostMapping(value = "/calcaneus", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<CalcaneusDto> saveCalcaneus(@RequestBody CalcaneusDto calcaneusDto) {
            Calcaneus savedCalcaneus = (Calcaneus) extremityService.save(calcaneusMapper.toEntity(calcaneusDto));
            CalcaneusDto savedCalcaneusDto = calcaneusMapper.toDto(savedCalcaneus);
        return new Result<>(true, HttpStatus.OK.value(), "Calcaneus saved successfully", savedCalcaneusDto);
    }


    @PutMapping(value = "/calcaneus/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<CalcaneusDto> updateCalcaneus(@PathVariable
                                                            Long id,
                                                @RequestBody CalcaneusDto calcaneusDto) {
        Calcaneus calcaneus = calcaneusMapper.toEntity(calcaneusDto);
        calcaneus.setId(id);
        Calcaneus updatedCalcaneus = (Calcaneus) extremityService.update(EnumsBio.ExtremityBone.CALCANEUS, calcaneus);
        CalcaneusDto updatedCalcaneusDto = calcaneusMapper.toDto(updatedCalcaneus);
        return new Result<>(true, HttpStatus.OK.value(), "Calcanei updated successfully", updatedCalcaneusDto);
    }


    @DeleteMapping(value = "/calcaneus/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<?> deleteCalcaneus(@PathVariable
                                               Long id) {
        extremityService.deleteById(EnumsBio.ExtremityBone.CALCANEUS,id);
        return new Result<>(true, HttpStatus.NO_CONTENT.value(), "Calcanei deleted successfully");
    }
}
