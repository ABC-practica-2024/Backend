package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.OtherTarsals;
import ro.ubb.abc2024.biology.dto.Extremeties.OtherTarsalsDto;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OtherTarsalsMapper {
    OtherTarsalsMapper INSTANCE = Mappers.getMapper(OtherTarsalsMapper.class);

    OtherTarsalsDto toDto(OtherTarsals otherTarsals);

    OtherTarsals toEntity(OtherTarsalsDto otherTarsalsDto);
}
