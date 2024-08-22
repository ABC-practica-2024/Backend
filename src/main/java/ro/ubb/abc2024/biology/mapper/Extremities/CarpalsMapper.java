package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Carpals;
import ro.ubb.abc2024.biology.dto.Extremeties.CarpalsDto;
import ro.ubb.abc2024.biology.mapper.Extremities.CarpalsMapper;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarpalsMapper {
    CarpalsMapper INSTANCE = Mappers.getMapper(CarpalsMapper.class);

    CarpalsDto toDto(Carpals carpals);

    Carpals toEntity(CarpalsDto carpalsDto);
}
