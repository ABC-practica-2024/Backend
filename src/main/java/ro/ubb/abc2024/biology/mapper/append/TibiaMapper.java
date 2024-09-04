package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.appendicular.Tibia;
import ro.ubb.abc2024.biology.dto.appendicular.TibiaDto;

@Mapper(componentModel = "spring")
public interface TibiaMapper {
    TibiaDto toDto(Tibia entity);

    Tibia toEntity(TibiaDto dto);

    Tibia updateEntityFromDto(TibiaDto dto, @MappingTarget Tibia entity);

}
