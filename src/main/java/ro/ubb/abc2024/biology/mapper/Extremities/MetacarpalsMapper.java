package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Metacarpals;
import ro.ubb.abc2024.biology.dto.Extremeties.MetacarpalsDto;

@Component
@Mapper(componentModel = "spring")
public interface MetacarpalsMapper {

    MetacarpalsDto toDto(Metacarpals metacarpals);

    Metacarpals toEntity(MetacarpalsDto metacarpalsDto);
}
