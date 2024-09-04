package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Carpals;
import ro.ubb.abc2024.biology.dto.Extremeties.CarpalsDto;

@Component
@Mapper(componentModel = "spring")
public interface CarpalsMapper {

    CarpalsDto toDto(Carpals carpals);

    Carpals toEntity(CarpalsDto carpalsDto);
}
