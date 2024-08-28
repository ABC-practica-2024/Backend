package ro.ubb.abc2024.biology.controller.Extremities.Unused;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.biology.domain.EnumsBio;
import ro.ubb.abc2024.biology.domain.Extremities.Calcaneus;
import ro.ubb.abc2024.biology.dto.Extremeties.CalcaneusDto;
import ro.ubb.abc2024.biology.mapper.Extremities.CalcaneusMapper;
import ro.ubb.abc2024.biology.service.Extremities.ExtremityService;
import ro.ubb.abc2024.utils.dto.Result;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/")
public class CalcaneusControllerV2 {

    private final ExtremityService extremitiesService;

    private final CalcaneusMapper calcaneusMapper;

    @GetMapping(value = "/calcaneusV2/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<CalcaneusDto> getCalcaneusById(@PathVariable
                                                 long id) {
        Calcaneus calcaneus = (Calcaneus) extremitiesService.getById(EnumsBio.ExtremityBone.CALCANEUS, id);
        CalcaneusDto calcaneusDto = calcaneusMapper.toDto(calcaneus);
        return new Result<>(true, HttpStatus.OK.value(), "Here is the calcanei", calcaneusDto);
    }

    @GetMapping(value = "/calcaneusV3/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<CalcaneusDto> getCalcaneusById2(@PathVariable
                                                  long id) {
        Calcaneus calcaneus = (Calcaneus) extremitiesService.getById(EnumsBio.ExtremityBone.CALCANEUS, id);
        CalcaneusDto calcaneusDto = calcaneusMapper.toDto(calcaneus);
        return new Result<>(true, HttpStatus.OK.value(), "Here is the calcanei", calcaneusDto);
    }


}
