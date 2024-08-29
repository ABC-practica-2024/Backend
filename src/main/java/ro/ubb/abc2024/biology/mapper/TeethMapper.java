package ro.ubb.abc2024.biology.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.Teeth;
import ro.ubb.abc2024.biology.dto.TeethDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TeethMapper {

    TeethDto toDto(Teeth entity);

    Teeth toEntity(TeethDto dto);

}
