package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.appendicular.Tibia;
import ro.ubb.abc2024.biology.dto.appendicular.TibiaDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TibiaMapper {
    TibiaDto toDto(Tibia entity);

    Tibia toEntity(TibiaDto dto);

    Tibia updateEntityFromDto(TibiaDto dto, @MappingTarget Tibia entity);

}
