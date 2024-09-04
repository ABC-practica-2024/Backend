package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Calcaneus;
import ro.ubb.abc2024.biology.dto.Extremeties.CalcaneusDto;

@Component
@Mapper(componentModel = "spring")
public interface CalcaneusMapper {

    CalcaneusDto toDto(Calcaneus calcaneus);

    Calcaneus toEntity(CalcaneusDto calcaneusDto);
}
