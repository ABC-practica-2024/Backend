package ro.ubb.abc2024.biology.mapper.Extremities;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.biology.domain.Extremities.Metatarsals;
import ro.ubb.abc2024.biology.dto.Extremeties.MetatarsalsDto;

@Component
@Mapper(componentModel = "spring")
public interface MetatarsalsMapper {

    MetatarsalsDto toDto(Metatarsals metatarsals);

    Metatarsals toEntity(MetatarsalsDto metatarsalsDto);
}
