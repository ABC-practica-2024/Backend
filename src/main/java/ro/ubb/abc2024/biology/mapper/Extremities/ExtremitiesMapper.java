package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Extremities;
import ro.ubb.abc2024.biology.dto.Extremeties.ExtremitiesDto;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExtremitiesMapper {
    ExtremitiesMapper INSTANCE = Mappers.getMapper(ExtremitiesMapper.class);

    ExtremitiesDto toDto(Extremities extremities);

    Extremities toEntity(ExtremitiesDto extremitiesDto);
}
