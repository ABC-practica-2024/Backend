package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Metatarsals;
import ro.ubb.abc2024.biology.dto.Extremeties.MetatarsalsDto;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MetatarsalsMapper {
    MetatarsalsMapper INSTANCE = Mappers.getMapper(MetatarsalsMapper.class);

    MetatarsalsDto toDto(Metatarsals metatarsals);

    Metatarsals toEntity(MetatarsalsDto metatarsalsDto);
}
