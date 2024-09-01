package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.appendicular.Ulna;
import ro.ubb.abc2024.biology.dto.appendicular.UlnaDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UlnaMapper {
    UlnaDto toDto(Ulna entity);

    Ulna toEntity(UlnaDto dto);

    Ulna updateEntityFromDto(UlnaDto dto, @MappingTarget Ulna entity);

}
