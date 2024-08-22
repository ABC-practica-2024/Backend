package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Metacarpals;
import ro.ubb.abc2024.biology.dto.Extremeties.MetacarpalsDto;
import ro.ubb.abc2024.biology.mapper.Extremities.MetacarpalsMapper;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MetacarpalsMapper {
    MetacarpalsMapper INSTANCE = Mappers.getMapper(MetacarpalsMapper.class);

    MetacarpalsDto toDto(Metacarpals metacarpals);

    Metacarpals toEntity(MetacarpalsDto metacarpalsDto);
}
