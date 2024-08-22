package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.TPhalanges;
import ro.ubb.abc2024.biology.dto.Extremeties.TPhalangesDto;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TPhalangesMapper {
    TPhalangesMapper INSTANCE = Mappers.getMapper(TPhalangesMapper.class);

    TPhalangesDto toDto(TPhalanges tPhalanges);

    TPhalanges toEntity(TPhalangesDto tPhalangesDto);
}
