package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Extremity;
import ro.ubb.abc2024.biology.dto.Extremeties.ExtremityDto;

@Component
@Mapper(componentModel = "spring")
public interface ExtremityMapper {

    ExtremityDto toDto(Extremity extremities);

    Extremity toEntity(ExtremityDto extremitiesDto);
}
