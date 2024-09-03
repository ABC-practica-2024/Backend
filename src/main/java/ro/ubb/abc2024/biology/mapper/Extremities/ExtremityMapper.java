package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Extremity;
import ro.ubb.abc2024.biology.dto.Extremeties.ExtremityDto;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExtremityMapper {
    ExtremityMapper INSTANCE = Mappers.getMapper(ExtremityMapper.class);

    ExtremityDto toDto(Extremity extremities);

    Extremity toEntity(ExtremityDto extremitiesDto);
}
