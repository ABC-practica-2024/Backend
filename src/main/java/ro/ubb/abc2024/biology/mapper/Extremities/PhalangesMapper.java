package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Phalanges;
import ro.ubb.abc2024.biology.dto.Extremeties.PhalangesDto;

@Component
@Mapper(componentModel = "spring")
public interface PhalangesMapper {

    PhalangesDto toDto(Phalanges phalanges);

    Phalanges toEntity(PhalangesDto phalangesDto);
}
