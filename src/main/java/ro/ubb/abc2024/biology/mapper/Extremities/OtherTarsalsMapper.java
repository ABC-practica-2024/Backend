package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.OtherTarsals;
import ro.ubb.abc2024.biology.dto.Extremeties.OtherTarsalsDto;

@Component
@Mapper(componentModel = "spring")
public interface OtherTarsalsMapper {

    OtherTarsalsDto toDto(OtherTarsals otherTarsals);

    OtherTarsals toEntity(OtherTarsalsDto otherTarsalsDto);
}
