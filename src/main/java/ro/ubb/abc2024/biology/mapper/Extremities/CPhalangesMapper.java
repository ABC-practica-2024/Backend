package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.CPhalanges;
import ro.ubb.abc2024.biology.dto.Extremeties.CPhalangesDto;
import ro.ubb.abc2024.biology.mapper.Extremities.CPhalangesMapper;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CPhalangesMapper {
    CPhalangesMapper INSTANCE = Mappers.getMapper(CPhalangesMapper.class);

    CPhalangesDto toDto(CPhalanges cPhalanges);

    CPhalanges toEntity(CPhalangesDto cPhalangesDto);
}
