package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Calcaneus;
import ro.ubb.abc2024.biology.dto.Extremeties.CalcaneusDto;
import ro.ubb.abc2024.biology.mapper.Extremities.CalcaneusMapper;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CalcaneusMapper {
    CalcaneusMapper INSTANCE = Mappers.getMapper(CalcaneusMapper.class);

    CalcaneusDto toDto(Calcaneus calcaneus);

    Calcaneus toEntity(CalcaneusDto calcaneusDto);
}
