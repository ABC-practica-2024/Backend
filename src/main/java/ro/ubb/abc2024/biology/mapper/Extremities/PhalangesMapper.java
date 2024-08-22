package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Phalanges;
import ro.ubb.abc2024.biology.dto.Extremeties.PhalangesDto;
import ro.ubb.abc2024.biology.mapper.Extremities.PhalangesMapper;
@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhalangesMapper {
    PhalangesMapper INSTANCE = Mappers.getMapper(PhalangesMapper.class);

    PhalangesDto toDto(Phalanges phalanges);

    Phalanges toEntity(PhalangesDto phalangesDto);
}
